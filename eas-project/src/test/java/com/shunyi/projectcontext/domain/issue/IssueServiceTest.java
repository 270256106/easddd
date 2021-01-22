package com.shunyi.projectcontext.domain.issue;

import com.shunyi.projectcontext.acl.port.ChangeHistoryRepository;
import com.shunyi.projectcontext.acl.port.IssueRepository;
import com.shunyi.projectcontext.domain.changehistory.ChangeHistory;
import com.shunyi.projectcontext.domain.changehistory.Operator;
import com.shunyi.projectcontext.domain.exception.IssueException;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class IssueServiceTest {
    private IssueId issueId;
    private Operator operator;
    private IssueService issueService;
    private IssueOwner owner;

    @Before
    public void setUp() throws Exception {
        issueId = new IssueId("#1");
        operator = new Operator("200010100007", "admin");
        issueService = new IssueService();
        owner = new IssueOwner("200901010111", "zhangyi", "zhangyi@eas.com");
    }

    @Test
    public void should_assign_issue_to_specific_owner_and_generate_change_history() {
        Issue issue = Issue.of(issueId, "test issue", "test desc");

        IssueRepository issueRepo = mock(IssueRepository.class);
        when(issueRepo.issueOf(issueId)).thenReturn(Optional.of(issue));
        issueService.setIssueRepository(issueRepo);

        ChangeHistoryRepository changeHistoryRepo = mock(ChangeHistoryRepository.class);
        issueService.setChangeHistoryRepo(changeHistoryRepo);

        issueService.assign(issueId, owner, operator);

        assertThat(issue.ownerId()).isEqualTo(owner.id());
        verify(issueRepo).issueOf(issueId);
        verify(issueRepo).update(issue);
        verify(changeHistoryRepo).add(isA(ChangeHistory.class));
    }

    @Test
    public void should_throw_IssueException_given_no_issue_found_given_issueId() {
        IssueRepository issueRepo = mock(IssueRepository.class);
        when(issueRepo.issueOf(issueId)).thenReturn(Optional.empty());
        issueService.setIssueRepository(issueRepo);

        ChangeHistoryRepository changeHistoryRepo = mock(ChangeHistoryRepository.class);
        issueService.setChangeHistoryRepo(changeHistoryRepo);

        assertThatThrownBy(() -> issueService.assign(issueId, owner, operator))
                .isInstanceOf(IssueException.class)
                .hasMessageContaining("issue")
                .hasMessageContaining("not found");
        verify(issueRepo).issueOf(issueId);
        verify(issueRepo, never()).update(isA(Issue.class));
        verify(changeHistoryRepo, never()).add(isA(ChangeHistory.class));
    }
}
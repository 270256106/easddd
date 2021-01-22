package com.shunyi.projectcontext.domain.issue;

import com.shunyi.projectcontext.acl.port.ChangeHistoryRepository;
import com.shunyi.projectcontext.acl.port.IssueRepository;
import com.shunyi.projectcontext.domain.changehistory.ChangeHistory;
import com.shunyi.projectcontext.domain.changehistory.Operator;
import com.shunyi.projectcontext.domain.exception.IssueException;

import java.util.Optional;

/**
 * @author zhang
 * @create 2021-01-22 14:13
 */
public class IssueService {
    private IssueRepository issueRepo;
    private ChangeHistoryRepository changeHistoryRepo;

    public void assign(IssueId issueId, IssueOwner owner, Operator operator) {
        Optional<Issue> optIssue = issueRepo.issueOf(issueId);
        Issue issue = optIssue.orElseThrow(() -> issueNotFoundError(issueId));

        ChangeHistory changeHistory = issue.assignTo(owner, operator);

        issueRepo.update(issue);
        changeHistoryRepo.add(changeHistory);
    }

    private IssueException issueNotFoundError(IssueId issueId) {
        return new IssueException(String.format("issue with id {%s} was not found", issueId.id()));
    }

    public void setIssueRepository(IssueRepository issueRepo) {
        this.issueRepo = issueRepo;
    }

    public void setChangeHistoryRepo(ChangeHistoryRepository changeHistoryRepo) {
        this.changeHistoryRepo = changeHistoryRepo;
    }
}
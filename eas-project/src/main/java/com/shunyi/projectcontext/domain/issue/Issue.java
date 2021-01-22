package com.shunyi.projectcontext.domain.issue;

import com.shunyi.ddd.core.stereotype.Aggregate;
import com.shunyi.projectcontext.domain.changehistory.ChangeHistory;
import com.shunyi.projectcontext.domain.changehistory.Operation;
import com.shunyi.projectcontext.domain.changehistory.Operator;
import com.shunyi.projectcontext.domain.exception.AssignmentIssueException;

import java.time.LocalDateTime;

/**
 * @author zhang
 * @create 2021-01-22 14:13
 */
@Aggregate
public class Issue {
    private IssueId issueId;
    private String name;
    private String description;
    private String ownerId;
    private IssueStatus status;

    private Issue(IssueId issueId, String name, String description) {
        this.issueId = issueId;
        this.name = name;
        this.description = description;
        this.status = IssueStatus.Open;
    }

    public static Issue of(IssueId issueId, String name, String description) {
        return new Issue(issueId, name, description);
    }

    public ChangeHistory assignTo(IssueOwner owner, Operator operator) {
        if (status.isResolved()) {
            throw new AssignmentIssueException("resolved issue can not be assigned.");
        }
        if (status.isClosed()) {
            throw new AssignmentIssueException("closed issue can not be assigned.");
        }
        if (this.ownerId != null && this.ownerId.equals(owner.id())) {
            throw new AssignmentIssueException("issue can not be assign to same owner again.");
        }
        this.ownerId = owner.id();
        return ChangeHistory
                .operate(Operation.Assignment)
                .to(issueId.id())
                .by(operator)
                .at(LocalDateTime.now());
    }

    public String ownerId() {
        return ownerId;
    }

    public IssueStatus status() {
        return this.status;
    }

    public void changeStatusTo(IssueStatus issueStatus) {
        this.status = issueStatus;
    }
}
package com.shunyi.projectcontext.domain.changehistory;

import com.shunyi.ddd.core.stereotype.Aggregate;

import java.time.LocalDateTime;

/**
 * @author zhang
 * @create 2021-01-22 14:01
 */
@Aggregate
public class ChangeHistory {
    private ChangeHistoryId changeHistoryId;
    private Operation operation;
    private String issueId;
    private Operator operatedBy;
    private LocalDateTime operatedAt;

    public ChangeHistory(Operation operation) {
        this.changeHistoryId = ChangeHistoryId.next();
        this.operation = operation;
    }

    public static ChangeHistory operate(Operation operation) {
        return new ChangeHistory(operation);
    }

    public Operation operation() {
        return this.operation;
    }

    public String issueId() {
        return this.issueId;
    }

    public Operator operatedBy() {
        return this.operatedBy;
    }

    public LocalDateTime operatedAt() {
        return this.operatedAt;
    }

    public ChangeHistory to(String issueId) {
        this.issueId = issueId;
        return this;
    }

    public ChangeHistory by(Operator operator) {
        this.operatedBy = operator;
        return this;
    }

    public ChangeHistory at(LocalDateTime operatedTime) {
        this.operatedAt = operatedTime;
        return this;
    }
}
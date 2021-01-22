package com.shunyi.projectcontext.domain.issue;

/**
 * @author zhang
 * @create 2021-01-22 14:13
 */
public enum IssueStatus {
    Resolved,Open,Closed;

    public boolean isResolved() {
        return this == Resolved;
    }

    public boolean isClosed() {
        return this == Closed;
    }
}
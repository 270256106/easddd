package com.shunyi.projectcontext.domain.issue;

/**
 * @author zhang
 * @create 2021-01-22 14:13
 */
public class IssueOwner {
    private String ownerId;
    private String name;
    private String email;

    public IssueOwner(String ownerId, String name, String email) {
        this.ownerId = ownerId;
        this.name = name;
        this.email = email;
    }

    public String id() {
        return this.ownerId;
    }
}
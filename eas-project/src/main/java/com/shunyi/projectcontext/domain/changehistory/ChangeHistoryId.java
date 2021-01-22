package com.shunyi.projectcontext.domain.changehistory;

import java.util.UUID;

/**
 * @author zhang
 * @create 2021-01-22 14:02
 */
public class ChangeHistoryId {
    private final String id;

    private ChangeHistoryId(String id) {
        this.id = id;
    }

    public static ChangeHistoryId next() {
        return new ChangeHistoryId(UUID.randomUUID().toString());
    }
}
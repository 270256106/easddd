package com.shunyi.projectcontext.domain.changehistory;

/**
 * @author zhang
 * @create 2021-01-22 14:02
 */
public class Operator {
    private String operatorId;
    private String name;

    public Operator(String operatorId, String name) {
        this.operatorId = operatorId;
        this.name = name;
    }
}
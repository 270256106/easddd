package com.shunyi.trainingcontext.domain.tickethistory;

import java.util.Objects;

/**
 * @author zhang
 * @create 2021-01-12 13:48
 */
public class Operator {
    private String operatorId;
    private String name;

    public Operator(String operatorId, String name) {
        this.operatorId = operatorId;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(operatorId, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Operator operator = (Operator) obj;
        return operatorId.equals(operator.operatorId) &&
                name.equals(operator.name);
    }
}
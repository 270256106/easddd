package com.shunyi.trainingcontext.domain.ticket;


import com.shunyi.trainingcontext.domain.tickethistory.Operator;

import java.util.Objects;

/**
 * @author zhang
 * @create 2021-01-12 09:19
 */
public class Nominator {
    private String       employeeId;
    private String       name;
    private String       email;
    private TrainingRole role;

    public Nominator(String employeeId, String name, String email, TrainingRole role) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public String employeeId() {
        return this.employeeId;
    }

    public String name() {
        return this.name;
    }

    public Operator toOperator() {
        return new Operator(employeeId(), name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, name, email, role);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Nominator nominator = (Nominator) obj;
        return employeeId.equals(nominator.employeeId) &&
                name.equals(nominator.name) &&
                email.equals(nominator.email) &&
                role.equals(nominator.role);
    }
}
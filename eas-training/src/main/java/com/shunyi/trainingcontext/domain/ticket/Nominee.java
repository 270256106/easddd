package com.shunyi.trainingcontext.domain.ticket;

import java.util.Objects;

/**
 * @author zhang
 * @create 2021-01-12 09:19
 */
public class Nominee {
    private String employeeId;
    private String name;
    private String email;

    public Nominee(String employeeId, String name, String email) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
    }

    public String employeeId() {
        return this.employeeId;
    }

    public String name() {
        return this.name;
    }

    public String email() {
        return this.email;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, name, email);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Nominee nominee = (Nominee) obj;
        return employeeId.equals(nominee.employeeId) &&
                name.equals(nominee.name) &&
                email.equals(nominee.email);
    }
}
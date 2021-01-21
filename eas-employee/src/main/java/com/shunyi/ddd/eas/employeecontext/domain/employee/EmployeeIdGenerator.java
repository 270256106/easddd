package com.shunyi.ddd.eas.employeecontext.domain.employee;

import com.shunyi.ddd.eas.employeecontext.repository.EmployeeRepository;

/**
 * @author zhang
 * @create 2021-01-05 15:30
 */
public class EmployeeIdGenerator {
    public static final String START_SEQUENCE_NO = "0000";

    private EmployeeRepository empRepo;

    public void generate(Employee employee) {
        String sequenceNo = empRepo.latestEmployee().map(e->e.id().sequenceNo()).orElse(START_SEQUENCE_NO);
        employee.assignIdFrom(sequenceNo);
    }

    public void setEmployeeRepository(EmployeeRepository empRepo) {
        this.empRepo = empRepo;
    }
}
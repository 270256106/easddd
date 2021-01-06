package com.shunyi.ddd.eas.employeecontext.repository;

import com.shunyi.ddd.eas.employeecontext.domain.Employee;

import java.util.Optional;

public interface EmployeeRepository {

    Optional<Employee> latestEmployee();
}

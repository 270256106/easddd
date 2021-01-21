package com.shunyi.ddd.eas.employeecontext.repository;

import com.shunyi.ddd.core.stereotype.Port;
import com.shunyi.ddd.core.stereotype.PortType;
import com.shunyi.ddd.eas.employeecontext.domain.employee.Employee;

import java.util.Optional;

/**
 * @author zhang
 */
@Port(PortType.Repository)
public interface EmployeeRepository {

    Optional<Employee> latestEmployee();
}

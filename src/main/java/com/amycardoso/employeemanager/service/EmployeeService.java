package com.amycardoso.employeemanager.service;

import com.amycardoso.employeemanager.exception.UserNotFoundException;
import com.amycardoso.employeemanager.model.Employee;
import com.amycardoso.employeemanager.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    EmployeeRepository repository;

    public Employee add(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        LOGGER.info("Created user with code: {}", employee.getEmployeeCode());
        return repository.save(employee);
    }

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public Employee update(Employee employee) {
        return repository.save(employee);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public Employee findById(String id) {
        return repository.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by ID " + id + " was not found"));
    }

}

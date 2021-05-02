package com.amycardoso.employeemanager.repository;

import com.amycardoso.employeemanager.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Optional<Employee> findEmployeeById(String id);
    List<Employee> findEmployeeByNameContaining(String name);
}

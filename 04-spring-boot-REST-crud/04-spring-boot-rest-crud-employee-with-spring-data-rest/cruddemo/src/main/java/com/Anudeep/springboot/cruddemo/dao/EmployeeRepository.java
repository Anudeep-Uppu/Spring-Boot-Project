package com.Anudeep.springboot.cruddemo.dao;

import com.Anudeep.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // This will take care of everything...
    // No DAO implementations required...
    // This will get all the methods from JpaRepository which would be implemented for us.
}

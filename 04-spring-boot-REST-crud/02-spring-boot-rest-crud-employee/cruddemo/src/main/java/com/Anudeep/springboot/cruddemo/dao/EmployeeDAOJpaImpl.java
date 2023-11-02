package com.Anudeep.springboot.cruddemo.dao;

import com.Anudeep.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // define field for Entity Manager
    private EntityManager entityManager;

    // setup constructor injection

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }
    @Override
    public List<Employee> findAll() {

        // create a query

        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);

        // execute a query

        List<Employee> employees = theQuery.getResultList();

        // return the results

        return employees;
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee theEmployee) {
        return entityManager.merge(theEmployee);
    }

    @Override
    public void deleteById(int id) {

        // find it
        Employee theEmployee = entityManager.find(Employee.class, id);

        // now delete it
        entityManager.remove(theEmployee);
    }
}

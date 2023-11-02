package com.Anudeep.springboot.cruddemo.rest;

import com.Anudeep.springboot.cruddemo.entity.Employee;
import com.Anudeep.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // quick and dirty : inject employee dao (Constructor injection
    @Autowired
    public EmployeeRestController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    // expose /employees and return list of employees

    @GetMapping("/employees")
    public List<Employee> getEmployees()
    {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId)
    {
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null) throw new RuntimeException("Employee not found with id : " + employeeId);

        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee postEmployee(@RequestBody Employee theEmployee)
    {
        // also just in case they pass an ID in JSON... set id to 0. This is to force an insert item to database instead of an update.
        theEmployee.setId(0);

        return employeeService.save(theEmployee);
    }

    // Update existing employee

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee)
    {
        // Here we are not changing the id to 0 bcoz we don't wanna insert it but update in DB.
        return employeeService.save(theEmployee);
    }

    // Delete an employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId)
    {
        // find the employee
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null) throw new RuntimeException("Employee id not found : " + employeeId);

        // delete it
        employeeService.deleteById(employeeId);

        return "Employee successfully deleted with id : " + employeeId;
    }
}

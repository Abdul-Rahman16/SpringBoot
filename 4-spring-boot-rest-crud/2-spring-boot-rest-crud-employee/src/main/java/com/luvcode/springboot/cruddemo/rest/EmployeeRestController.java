package com.luvcode.springboot.cruddemo.rest;

import com.luvcode.springboot.cruddemo.entity.Employee;
import com.luvcode.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    //inject employee dao

    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;

    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    //add mapping for GET

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Not Found" + employeeId);
        }
        return theEmployee;
    }

    //add mapping for POST

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        //just in case they pass an id in json...set id to 0
        //save item instead of update

        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    //add mapping for PUT

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee tempEmployee = employeeService.findById(employeeId);

        if (tempEmployee == null) {
            throw new RuntimeException("Employee not Found" + employeeId);
        }
        employeeService.deleteById(employeeId);

        return "Delete employee id" + employeeId;

    }
}


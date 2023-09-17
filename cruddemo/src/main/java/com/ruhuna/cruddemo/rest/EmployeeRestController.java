package com.ruhuna.cruddemo.rest;

import com.ruhuna.cruddemo.dao.EmployeeDAOImpl;
import com.ruhuna.cruddemo.dao.IEmployeeDAO;
import com.ruhuna.cruddemo.entities.Employee;
import com.ruhuna.cruddemo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api")
@RestController
public class EmployeeRestController {
    private IEmployeeService employeeService;


    @Autowired
    //Constructor Based DI
    public EmployeeRestController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    //localhost:8080/api/employees
    @GetMapping("/employees")
    List<Employee> findAllEmployees()
    {
        return employeeService.findAll();
    }

    @GetMapping("employees/{requestedId}")
    Employee findEmployeeById(@PathVariable int requestedId)
    {
        //if this id is not in the database this employee object will be null
        Employee employee = employeeService.findById(requestedId);

        if(employee == null)
        {
            throw new RuntimeException("Requested employee id not found ");
        }
        else
        {
            return employee;
        }
    }
    @PostMapping("/employees")
    Employee addEmployee(@RequestBody  Employee theEmployee)
    {
        Employee savedEmployee = employeeService.save(theEmployee);

        return savedEmployee;

    }
    @PutMapping("/employees")
    Employee updateEmployee(@RequestBody Employee theEmployee)
    {
        //if its there it will update the existing one
        //if its not there it will create a new record in the database
        Employee employee = employeeService.save(theEmployee);

        return employee;
    }
    @DeleteMapping("/employees/{requestedId}")
    public String deletedEmployeeById(@PathVariable int requestedId)
    {
        Employee employee = employeeService.findById(requestedId);
        if(employee == null)
        {
            throw new RuntimeException("Employee id : "+ requestedId +"Not found");
        }
        else
        {
            employeeService.deleteById(requestedId);
        }
        return "Deleted id "+requestedId +" from the database";
    }

}

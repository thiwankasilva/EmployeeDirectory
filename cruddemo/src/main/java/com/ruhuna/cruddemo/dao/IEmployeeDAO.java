package com.ruhuna.cruddemo.dao;

import com.ruhuna.cruddemo.entities.Employee;

import java.util.List;

//hiding implementation details by interfaces
//interfaces is a way to achieve abstraction
public interface IEmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}

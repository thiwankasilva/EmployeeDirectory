package com.ruhuna.cruddemo.service;

import com.ruhuna.cruddemo.entities.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}

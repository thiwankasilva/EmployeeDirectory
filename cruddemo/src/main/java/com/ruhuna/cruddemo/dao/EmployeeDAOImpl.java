package com.ruhuna.cruddemo.dao;

import com.ruhuna.cruddemo.entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository Identifies this class do database operations
//indicates that class provides the mechanism to do database operations(save,delete,update)
@Repository
public class EmployeeDAOImpl implements IEmployeeDAO{

    private EntityManager entityManager;

    //Constructor based Dependency injection
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        //JPQL
        TypedQuery<Employee> typedQuery = entityManager.createQuery("from Employee",Employee.class);
        List<Employee> resultSet = typedQuery.getResultList();

        return  resultSet;

    }

    @Override
    public Employee findById(int id) {

        Employee employee = entityManager.find(Employee.class,id);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {

        Employee savedEmployee = entityManager.merge(employee);

        return savedEmployee;
    }

    @Override
    public void deleteById(int id) {

        Employee employee = entityManager.find(Employee.class,id);
        entityManager.remove(employee);
    }


}

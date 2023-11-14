package com.luvcode.springboot.cruddemo.dao;

import com.luvcode.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    //define field for entitymanager
    private EntityManager entityManager;


    //set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }


    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee", Employee.class);

        List<Employee> employee = theQuery.getResultList();

        //return results;
        return employee;
    }

    @Override
    public Employee findById(int theId) {

        Employee theEmployee=entityManager.find(Employee.class,theId);


        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        Employee dbEmployee=entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {

        //find employee by id;

        Employee theEmployee=entityManager.find(Employee.class, theId);

        //remove employee

        entityManager.remove(theEmployee);

    }
}

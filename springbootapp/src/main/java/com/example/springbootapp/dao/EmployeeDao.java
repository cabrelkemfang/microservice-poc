package com.example.springbootapp.dao;

import com.example.springbootapp.model.Employee;
import com.example.springbootapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDao {

    @Autowired
    EmployeeRepository employeeRepository;

    //save an employee

    public Employee save(Employee emp){
        return employeeRepository.save(emp);
    }

    //search all eployees

    public List<Employee> findAll(){
        return  employeeRepository.findAll();
    }

    //get an employee

    public Employee findOne(Long empid){
        return employeeRepository.getOne(empid);
    }

    //delete employee by id

    public void delete(Employee emp){
        employeeRepository.delete(emp);
    }
}

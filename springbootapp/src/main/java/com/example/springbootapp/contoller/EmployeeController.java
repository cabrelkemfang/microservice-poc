package com.example.springbootapp.contoller;

import com.example.springbootapp.dao.EmployeeDao;
import com.example.springbootapp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company")
public class EmployeeController {


    @Autowired
    EmployeeDao employeeDao;

    //to save an employee

    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee emp){
        return employeeDao.save(emp);
    }

    //get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return  employeeDao.findAll();
    }

    //get employee by id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long empid){
        Employee emp= employeeDao.findOne(empid);

        if(emp == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(emp);
    }

    //update Employee
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long empid, @RequestBody Employee empDetails){
        Employee emp = employeeDao.findOne(empid);

        if(emp == null){
            return ResponseEntity.notFound().build();
        }

        emp.setName(empDetails.getName());
        emp.setDesignation(empDetails.getDesignation());
        emp.setExpertise(empDetails.getExpertise());

        Employee updateEmployee = employeeDao.save(emp);

        return  ResponseEntity.ok().body(updateEmployee);
    }

    //delete an employee
    @DeleteMapping("employees/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empid){
        Employee emp = employeeDao.findOne(empid);

        if(emp == null){
            return ResponseEntity.notFound().build();
        }
        employeeDao.delete(emp);
        return  ResponseEntity.ok().build();
    }
}

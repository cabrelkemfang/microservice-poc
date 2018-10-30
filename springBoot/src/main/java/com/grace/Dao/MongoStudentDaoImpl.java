package com.grace.Dao;

import com.grace.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;

@Repository
@Qualifier("mongoData")
public class MongoStudentDaoImpl implements StudentDao{

    @Override
   public  Collection<Student> getAllStudents(){
        return new ArrayList<Student>(){
            {
                add(new Student(1, "Mario","biology"));
            }
        };
   }

   @Override
  public Student getStudentById(int id){
        return null;
  }
    @Override
    public void removeStudentById(int id){

    }
    @Override
    public void updateStudent(Student student){}

  @Override
   public void createStudent(Student student){}


}

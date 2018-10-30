package com.grace.Service;

import com.grace.Dao.FakeStudentDaoImpl;
import com.grace.Dao.StudentDao;
import com.grace.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {

  @Autowired
  @Qualifier("mongoData")
  private StudentDao studentDao;

    public Collection<Student> getAllStudents(){
        return studentDao.getAllStudents();
    }

    public Student getStudentById(int id){
        return studentDao.getStudentById(id);
    }

    public void removeStudentById(int id) {
        studentDao.removeStudentById(id);
    }

    public void updateStudent(Student student){
        this.studentDao.updateStudent(student);
    }

    public void createStudent(Student student) {
        this.studentDao.createStudent(student);
    }
}


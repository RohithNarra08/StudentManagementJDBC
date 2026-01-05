package com.service;

import java.util.List;

import com.exception.StudentNotFoundException;
import com.model.Student;

public interface StudentService {
public void addStudent(Student student)throws StudentNotFoundException;
public List<Student> getAllStudent(int id)throws StudentNotFoundException;
public Student getStudentById(int id )throws StudentNotFoundException;
public void updateStudent(Student student)throws StudentNotFoundException;
public void deleteStudent(int id)throws StudentNotFoundException;
}

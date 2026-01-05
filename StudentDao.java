package com.dao;

import java.util.List;

import com.exception.StudentNotFoundException;
import com.model.Student;

public interface StudentDao {
	public void save(Student student);
	public List<Student>findAll();
	public Student findBy(int id)throws StudentNotFoundException;
	public void update(Student student)throws StudentNotFoundException;
	public void deleteBy(int id)throws StudentNotFoundException;

}

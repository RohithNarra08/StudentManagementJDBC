package com.service;

import java.util.List;

import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.exception.StudentNotFoundException;
import com.model.Student;

public class StudentServiceImpl implements StudentService {
StudentDao dao=new StudentDaoImpl();

	@Override
	public void addStudent(Student student) throws StudentNotFoundException {
		dao.save(student);		
	}

	@Override
	public List<Student> getAllStudent(int id) throws StudentNotFoundException {
		
		return dao.findAll();
	}

	@Override
	public Student getStudentById(int id) throws StudentNotFoundException {
		
		return dao.findBy(id);
	}

	@Override
	public void updateStudent(Student student) throws StudentNotFoundException {
		dao.update(student);		
	}

	@Override
	public void deleteStudent(int id) throws StudentNotFoundException {
		dao.deleteBy(id);		
	}

}

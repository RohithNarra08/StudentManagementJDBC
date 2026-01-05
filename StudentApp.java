package com.controller;

import java.util.List;
import java.util.Scanner;

import com.exception.StudentNotFoundException;
import com.model.Student;
import com.service.StudentService;
import com.service.StudentServiceImpl;

public class StudentApp {

	public static void main(String[] args){
		StudentService service=new StudentServiceImpl();
		service.addStudent(new Student(1,"rohith","cse"));
		service.addStudent(new Student(2,"pavan","mech"));
		service.addStudent(new Student(3,"nandu","mech"));
		System.out.println("inserted successfully");
		
		/*System.out.println("id\tname\tdept");
		List<Student>list=service.getAllStudent(0);
		for(Student s:list) {
			System.out.println(s);
		}*/
		
		
		
		
	}

}



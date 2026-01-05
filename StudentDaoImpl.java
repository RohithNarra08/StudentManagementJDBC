package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.exception.StudentNotFoundException;
import com.factory.ConnectionFactory;
import com.model.Student;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void save(Student student) {
		String sql="insert into student(id,name,dept)values(?,?,?)";
		try(Connection con=ConnectionFactory.getConnection();PreparedStatement pst=con.prepareStatement(sql)){
			
			pst.setInt(1, student.getId());
			pst.setString(2, student.getName());
			pst.setString(3, student.getDept());
			int rows=pst.executeUpdate();
			if(rows==1) {
				System.out.println("Inserted Records Sucessfully");
			}else {
				System.out.println("records insertion failed");
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Student> findAll() {
		List<Student>list=new ArrayList<>();
		
		String sql="select * from student";
		
		try(Connection con=ConnectionFactory.getConnection();PreparedStatement pst=con.prepareStatement(sql);ResultSet rs=pst.executeQuery();){
			while(rs.next()) {
				list.add(new Student(rs.getInt(1),rs.getString(2),rs.getString(3)));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
				return list;
	}

	@Override
	public Student findBy(int id) throws StudentNotFoundException {
		String sql="Select * from student where id=?";
			try(Connection con=ConnectionFactory.getConnection();PreparedStatement pst=con.prepareStatement(sql)){
				pst.setInt(1,id);
				ResultSet rs=pst.executeQuery();
				if(rs.next()) {
					return new Student(rs.getInt(1),rs.getString(2),rs.getString(3));
				}else {
					throw new StudentNotFoundException("id not found"+id);
				}
				
			}catch (SQLException  e) {
				throw new StudentNotFoundException("DataBase error: "+e.getMessage());
			}	
	}

	@Override
	public void update(Student student) throws StudentNotFoundException {
		String sql="Update student set name=?,dept=? where id=?";
		try(Connection con=ConnectionFactory.getConnection();PreparedStatement pst=con.prepareStatement(sql);){
			pst.setInt(1, student.getId());
			pst.setString(1, student.getName());
			pst.setString(3, student.getDept());
			int rows=pst.executeUpdate();
			if(rows==1) {
				throw new StudentNotFoundException("update failed");
			}else {
				throw new StudentNotFoundException("updated employee details sucessfully");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
	}

	@Override
	public void deleteBy(int id) throws StudentNotFoundException {
		String sql= "delete from student where id=?";
		try(Connection con=ConnectionFactory.getConnection();PreparedStatement pst=con.prepareStatement(sql)){
			pst.setInt(1, id);
			int rows=pst.executeUpdate();
			if(rows==0) {
				throw new StudentNotFoundException("records not deleted");
				
			}else {
				System.out.println("records Deleted"+id);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}

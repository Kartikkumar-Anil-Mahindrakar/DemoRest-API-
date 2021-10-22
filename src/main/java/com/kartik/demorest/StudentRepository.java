package com.kartik.demorest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class StudentRepository {
	
	
	Connection con = null;
	
	public StudentRepository()  {
		// TODO Auto-generated constructor stub
		String url = "jdbc:mysql://localhost:3306/kartikacademy?allowPublicKeyRetrieval=true&useSSL=false";
		String username = "root";
		String password = "admin123";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Student> getStudents(){
		List<Student> students = new LinkedList<Student>();
		String sql = "select * from students";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setPoints(rs.getInt(3));
				students.add(s);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return students;
	}

	public Student getStudent(int id) {
		String sql = "select * from students where id = "+id;
		Student s = new Student();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setPoints(rs.getInt(3));
				return s;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return s;
	}
	
	public void createStudent(Student s) {
		
		String sql = "insert into students values(?,?,?)";
	
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,s.getId());
			st.setString(2, s.getName());
			st.setInt(3, s.getPoints());
			st.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	public void updateStudent(Student s) {

		String sql = "update students set name = ?, points = ? where id = ?";
	
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(3,s.getId());
			st.setString(1, s.getName());
			st.setInt(2, s.getPoints());
			st.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void deleteStudent(Student s) {
		
		String sql = "delete from students where id = ?";
		
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,s.getId());
			
			st.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}

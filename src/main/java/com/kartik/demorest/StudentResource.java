package com.kartik.demorest;

import java.util.Arrays;
import java.util.List;

import org.json.JSONObject;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("students")
public class StudentResource {
	StudentRepository studentRepository = new StudentRepository();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudent() {
//		JSONObject json = new JSONObject();
		
		return studentRepository.getStudents();
	}
	
	@GET
	@Path("getstudent/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudent(@PathParam("id")int id) {
		
		return studentRepository.getStudent(id);
	}
	
	@POST
	@Path("addstudent")
	@Produces(MediaType.APPLICATION_JSON)
	public Student createStudent(Student student) {
		
		studentRepository.createStudent(student);
		System.out.println(student);
		return student;
	}
	
	@PUT
	@Path("updatestudent")
	@Produces(MediaType.APPLICATION_JSON)
	public Student updateStudent(Student student) {
		
		if (studentRepository.getStudent(student.getId()).getId() == 0) {
			studentRepository.createStudent(student);
		}else {
			studentRepository.updateStudent(student);
		}
		
		System.out.println(student);
		return student;
	}
	@DELETE
	@Path("deletestudent/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student deleteStudent(@PathParam("id")int id) {
			
		Student st = studentRepository.getStudent(id);
		if (st.getId() != 0) {
			studentRepository.deleteStudent(st);
		}
		
		System.out.println(st);
		return st;
	}
}



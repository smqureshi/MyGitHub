package com.philips.atna.services;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.philips.atna.beans.Student;
import com.philips.atna.dao.StudentDAO;


@Path("/students")
public class StudentDetailsImpl implements StudentDetails {

	@Override
	@GET	
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@Path("{studentId}")
	public Student getStudentDetails(@PathParam("studentId") String studentId) {
		
		StudentDAO studentDao = new StudentDAO();
	       Student student = null;
	       try {
	            student = studentDao.getStudentDetails(studentId);
	       } catch (SQLException e) {
	           e.printStackTrace();
	       }

	       return student;
	}
}

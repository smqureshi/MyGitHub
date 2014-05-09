package com.philips.atna.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.philips.atna.beans.Student;


public class StudentDAO {

    Connection connection = null;
    Statement statement = null;
    ResultSet rs = null;

    public Student getStudentDetails(String studentID) throws SQLException {
        String studentName = null;
        String studentAddress = null;
        String studentTelNo = null;

        connection = getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
        }

        String sqlStatement = "select * from StudentDetails where studentID = " + studentID + "";
        rs = statement.executeQuery(sqlStatement);

        Student student = null;
        while (rs.next()) {
            student = new Student();
            studentName = rs.getString("studentName");
            studentAddress = rs.getString("studentAddress");
            studentTelNo = rs.getString("studentTelNo");

            student.setStudentName(studentName);
            student.setStudentAddress(studentAddress);
            student.setStudentTelNo(studentTelNo);
        }
        
        statement.close();
        connection.close();

        return student;
    }

    public List<Student> getStudents() throws SQLException {
        String studentName = null;
        String studentAddress = null;
        String studentTelNo = null;
        int studentID = 0;

        connection = getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
        }

        String sqlStatement = "Select * from StudentDetails";
        rs = statement.executeQuery(sqlStatement);

        List<Student> students= new ArrayList<Student>();
        
        while (rs.next()) {
            Student student = new Student();
            
            studentID = rs.getInt("studentID");
            studentName = rs.getString("studentName");
            studentAddress = rs.getString("studentAddress");
            studentTelNo = rs.getString("studentTelNo");

            student.setStudentID(studentID);
            student.setStudentName(studentName);
            student.setStudentAddress(studentAddress);
            student.setStudentTelNo(studentTelNo);
            
            students.add(student);
        }
        
        statement.close();
        connection.close();

        return students;
    }
    
    private Connection getConnection() {
    
    	String driverName = "org.postgresql.Driver";
        String conectionURI = "jdbc:postgresql://localhost:5432/StudentDB";
        String userName = "postgres";
        String password = "p0s7gre";

        try {
            Class.forName(driverName);

            try {
                connection = DriverManager.getConnection(conectionURI, userName, password);
            } catch (SQLException e) {
                e.printStackTrace();  
            }
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();  
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  
        }

        return connection;
    }   
}
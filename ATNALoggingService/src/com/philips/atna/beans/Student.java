package com.philips.atna.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	
    private int studentID;
	private String studentName;
    private String studentAddress;
    private String studentTelNo;
	
	public Student() {}
	
	public Student(int id, String name, String address, String telno) {
		this.studentID = id;
		this.studentName = name;
		this.studentAddress = address;
		this.studentTelNo = telno;
	}

    public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getStudentTelNo() {
		return studentTelNo;
	}

	public void setStudentTelNo(String studentTelNo) {
		this.studentTelNo = studentTelNo;
	}


 
}

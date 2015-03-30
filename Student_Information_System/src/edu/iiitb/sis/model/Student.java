package edu.iiitb.sis.model;

import java.io.File;

public class Student 
{
	private String studentName;
	private String studentRollNo;
	private String dateOfBirth;
	private String phoneNumber;
	private String email;
	private String address;
	
	private File image;
	private String imageFileName;
	private String imageContentType;
	private String imagePath;
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public String getPhoneNumber() 
	{
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public File getImage() 
	{
		return image;
	}
	public void setImage(File image) 
	{
		this.image = image;
	}
	public String getImageFileName() 
	{
		return imageFileName;
	}
	public void setImageFileName(String imageFileName)
	{
		this.imageFileName = imageFileName;
	}
	public String getImageContentType() 
	{
		return imageContentType;
	}
	public void setImageContentType(String imageContentType)
	{
		this.imageContentType = imageContentType;
	}
	public String getStudentName() 
	{
		return studentName;
	}
	public void setStudentName(String studentName) 
	{
		this.studentName = studentName;
	}
	public String getStudentRollNo() 
	{
		return studentRollNo;
	}
	public void setStudentRollNo(String studentRollNo) 
	{
		this.studentRollNo = studentRollNo;
	}
}

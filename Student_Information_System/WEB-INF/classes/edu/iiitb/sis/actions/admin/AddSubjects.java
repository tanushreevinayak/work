package edu.iiitb.sis.actions.admin;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ModelDrivenInterceptor;

import edu.iiitb.sis.dao.AddSubjectsAdmin;
import edu.iiitb.sis.model.Course;
import edu.iiitb.sis.model.Login;
public class AddSubjects implements ModelDriven<Course>{
	private Course course=new Course();
	private String message;
	private String course_id;
		private String course_name;
		
		private String course_syllabus;
		private String course_credits;
		AddSubjectsAdmin data=new AddSubjectsAdmin();
		
		
		public String execute()
		{
			message=data.AddSubjects(course);
			return message;
		}
		
		
		
		public Course getCourse() {
			return course;
		}



		public void setCourse(Course course) {
			this.course = course;
		}



		@Override
		public Course getModel() {
			// TODO Auto-generated method stub
			return course;
		}
	
		
}

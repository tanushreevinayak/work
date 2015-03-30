package edu.iiitb.sis.model;

import java.util.ArrayList;


public class Course {
		private String message;
		private String course_id;
		private String course_name;
		private String course_syllabus;
		private String course_credits;
		private String flag;
		private ArrayList<String> subjects;
		
		public String getCourse_id() {
			return course_id;
		}
		public void setCourse_id(String course_id) {
			this.course_id = course_id;
		}
		public String getCourse_name() {
			return course_name;
		}
		public void setCourse_name(String course_name) {
			System.out.println("in setter");
			this.course_name = course_name;
		}
		public String getCourse_syllabus() {
			return course_syllabus;
		}
		public void setCourse_syllabus(String course_syllabus) {
			this.course_syllabus = course_syllabus;
		}
		public String getCourse_credits() {
			return course_credits;
		}
		public void setCourse_credits(String course_credits) {
			this.course_credits = course_credits;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getFlag() {
			return flag;
		}
		public void setFlag(String flag) {
			this.flag = flag;
		}
		public ArrayList<String> getSubjects() {
			return subjects;
		}
		public void setSubjects(ArrayList<String> subjects) {
			this.subjects = subjects;
		}
		
	
		
}

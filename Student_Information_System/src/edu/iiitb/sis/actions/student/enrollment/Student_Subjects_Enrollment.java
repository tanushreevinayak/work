package edu.iiitb.sis.actions.student.enrollment;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.student.enrollment.Enrollmentdao;
import edu.iiitb.sis.model.Course;
public class Student_Subjects_Enrollment extends ActionSupport implements ModelDriven<Course>,SessionAware
{

	
	private static final long serialVersionUID = 1L;
	private Course course=new Course();
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	ArrayList <String>subjects=new ArrayList<String>();
	Enrollmentdao enroll=new Enrollmentdao();
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private String message;
	private SessionBean sessionBean;
	
	
	public String execute()
	{
		course.setSubjects(enroll.enrollSubjects(course));
		for(int i=0;i<subjects.size();i++)
		{
		System.out.println(subjects.get(i));
		}
		return "success";
		
	}
	
	public Course getModel() 
	{
		return course;
	}
	
	public void setSession(Map<String, Object> map)
	{
		this.sessionMap=map;
		this.sessionBean=(SessionBean) sessionMap.get("Session");
		setSessionValues();
	}
	//The following function sets the values with session values.
	private void setSessionValues()
	{
		this.announcementList=sessionBean.getAnnouncementList();
		this.newsList=sessionBean.getNewsList();
		this.loginName=sessionBean.getUserName();
		this.loggedInUser=sessionBean.getName();
	}
	private String loggedInUser;
	public String getLoggedInUser() 
	{
		return loggedInUser;
	}
	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}	

	public ArrayList<String> getAnnouncementList() {
		return announcementList;
	}

	public void setAnnouncementList(ArrayList<String> announcementList) {
		this.announcementList = announcementList;
	}

	public ArrayList<String> getNewsList() {
		return newsList;
	}

	public void setNewsList(ArrayList<String> newsList) {
		this.newsList = newsList;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
	
}

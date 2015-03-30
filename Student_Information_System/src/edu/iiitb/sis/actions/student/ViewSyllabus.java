package edu.iiitb.sis.actions.student;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.student.ViewCoursesDao;
import edu.iiitb.sis.model.CourseModel;

public class ViewSyllabus extends ActionSupport implements SessionAware,ModelDriven<CourseModel> 
{
	private CourseModel course=new CourseModel();
	
	private ArrayList<String> courseList=new ArrayList<String>();
	
	private static final long serialVersionUID = 1L;	
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private String message;
	private SessionBean sessionBean;
	
	private ViewCoursesDao viewCourses=new ViewCoursesDao();
	
	public String execute()
	{
		courseList=viewCourses.getCourses();
		course=viewCourses.getSyllabus(course);
		message="success";
		return "success";
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
	public CourseModel getModel() 
	{
		return course;
	}
	private String loggedInUser;
	public String getLoggedInUser() 
	{
		return loggedInUser;
	}
	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}	
	
	public ArrayList<String> getCourseList() {
		return courseList;
	}
	public void setCourseList(ArrayList<String> courseList) {
		this.courseList = courseList;
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

	public CourseModel getCourse() {
		return course;
	}

	public void setCourse(CourseModel course) {
		this.course = course;
	}

	
	
	
}

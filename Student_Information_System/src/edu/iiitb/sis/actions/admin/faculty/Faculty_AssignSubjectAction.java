package edu.iiitb.sis.actions.admin.faculty;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.admin.AssignCourseDao;
import edu.iiitb.sis.model.Admin_Assign_Course2F;

public class Faculty_AssignSubjectAction extends ActionSupport implements SessionAware,ModelDriven<Admin_Assign_Course2F> {
	
	private static final long serialVersionUID = 1L;
	private Admin_Assign_Course2F  AACF = new Admin_Assign_Course2F();
	// AACF mODEL class Object
	 AssignCourseDao assignCourse;
	 
	private String facultyname;
	private String course_names;
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private SessionBean sessionBean;
	private String loggedInUser;
	private String message;

	public String execute()
	{
		
		
		assignCourse = new AssignCourseDao();
		assignCourse.Retrieve_facultyname_coursename_function(AACF);
	   				
		return "addedcourse";
		

	}
	
	public void setSession(Map<String, Object> map)
	{
		this.sessionMap=map;
		this.sessionBean=(SessionBean) sessionMap.get("Session");
		setSessionValues();
	}
	private void setSessionValues()
	{
		this.announcementList=sessionBean.getAnnouncementList();
		this.newsList=sessionBean.getNewsList();
		this.loginName=sessionBean.getName();
	}

	 
	 
	public String getFacultyname() {
		return facultyname;
	}

	public void setFacultyname(String facultyname) {
		this.facultyname = facultyname;
	}

	public String getCourse_names() {
		return course_names;
	}

	public void setCourse_names(String course_names) {
		this.course_names = course_names;
	}
	public String getLoggedInUser() 
	{
		return loggedInUser;
	}
	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}	

	public Admin_Assign_Course2F getModel() 
	{
		return AACF;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	

	
	
	
}

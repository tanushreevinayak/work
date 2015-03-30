package edu.iiitb.sis.actions.admin.courses;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.model.CourseModel;
import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.admin.courses.CourseDao;
public class AddCourseAction extends ActionSupport implements SessionAware,ModelDriven<CourseModel> 
{

	private static final long serialVersionUID = 1L;
	private CourseModel course=new CourseModel();
	private CourseDao courseDao=new CourseDao();
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private String message;
	private SessionBean sessionBean;
		
	public String execute()
	{
		System.out.println(course.getCourseCredits());
		System.out.println(course.getCourseName());
		message=courseDao.addCourse(course);
		return "success";
	}
	public CourseModel getModel() 
	{
		return course;
	}
	//The following will sets the Session Values
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
	public ArrayList<String> getAnnouncementList() 
	{
		return announcementList;
	}
	public void setAnnouncementList(ArrayList<String> announcementList) 
	{
		this.announcementList = announcementList;
	}
	public ArrayList<String> getNewsList()
	{
		return newsList;
	}
	public void setNewsList(ArrayList<String> newsList)
	{
		this.newsList = newsList;
	}
	public String getLoginName()
	{
		return loginName;
	}
	public void setLoginName(String loginName)
	{
		this.loginName = loginName;
	}
	public CourseModel getCourse() {
		return course;
	}
	public void setCourse(CourseModel course) {
		this.course = course;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	
}

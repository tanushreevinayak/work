package edu.iiitb.sis.actions.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.student.ViewCoursesDao;
import edu.iiitb.sis.dao.student.ViewSemesterCoursesDao;
import edu.iiitb.sis.model.CourseModel;
import edu.iiitb.sis.model.ViewSemesterCourseModel;

public class ViewSemesterCourses extends ActionSupport implements SessionAware,ModelDriven<ViewSemesterCourseModel>
{
	private ViewSemesterCourseModel obj=new ViewSemesterCourseModel();
	
//	private ArrayList<String> courseList=new ArrayList<String>();
	
	public ViewSemesterCourseModel getObj() {
		return obj;
	}

	public void setObj(ViewSemesterCourseModel obj) {
		this.obj = obj;
	}
	private static final long serialVersionUID = 1L;	
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private String message;
	private SessionBean sessionBean;
	private List<String> CourseList=new ArrayList<String>();
	
	private ViewSemesterCoursesDao  viewSemesterCourses=new ViewSemesterCoursesDao ();
	
	public String execute()
	{
		System.out.println("going to dddddddddaaaaaooooooo classssssssss");
//		courseList=viewCourses.getCourses();
//		course=viewCourses.getSyllabus(course);
//		message="success";
		viewSemesterCourses.getSemesterCourses(obj);
		 setCourseList(obj.getCoursename());
		 System.out.println("success");
		 System.out.println(obj.getCoursename());
			System.out.println("return ffffffffrrrrrrommmmm ddddddaaaoooo class"+getCourseList());
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


	@Override
	public ViewSemesterCourseModel getModel() {

		return obj;
	}

	public List<String> getCourseList() {
		return CourseList;
	}

	public void setCourseList(List<String> courseList) {
		CourseList = courseList;
	}
	
}

package edu.iiitb.sis.actions.admin.courses;

import edu.iiitb.sis.dao.admin.courses.AddSemesterDao;
import edu.iiitb.sis.dao.admin.courses.DeleteSemesterPageDao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.dao.admin.courses.AddSemesterDao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.student.ViewSemesterCoursesDao;
import edu.iiitb.sis.model.DeleteSemesterCourseModel;

public class AdminDeleteSemesterAction extends ActionSupport implements SessionAware,ModelDriven<DeleteSemesterCourseModel>
{
	DeleteSemesterCourseModel obj = new DeleteSemesterCourseModel();
	
	private static final long serialVersionUID = 1L;
	private ArrayList<String> semesterList=new ArrayList<String>();
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private String message;
	private SessionBean sessionBean;
	private DeleteSemesterPageDao DeleteSemesterDao=new DeleteSemesterPageDao();
	
	public String execute()
	{
		System.out.println("rrrrrrraaaaaaaa");
		message = DeleteSemesterDao.DeleteSemesterCourses(obj);
//		message="Failure";
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
	public ArrayList<String> getAnnouncementList() {
		return announcementList;
	}
	public void setAnnouncementList(ArrayList<String> announcementList) {
		this.announcementList = announcementList;
	}
	public ArrayList<String> getNewsList() {
		return newsList;
	}
	private String loggedInUser;
	public String getLoggedInUser() 
	{
		return loggedInUser;
	}
	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
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
	public ArrayList<String> getSemesterList() {
		return semesterList;
	}
	public void setSemesterList(ArrayList<String> semesterList) {
		this.semesterList = semesterList;
	}
	public DeleteSemesterCourseModel getObj() {
		return obj;
	}
	public void setObj(DeleteSemesterCourseModel obj) {
		this.obj = obj;
	}
@Override
	public DeleteSemesterCourseModel getModel() {
		// TODO Auto-generated method stub
		return obj;
	}
	
}

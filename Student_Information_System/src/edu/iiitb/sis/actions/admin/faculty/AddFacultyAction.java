package edu.iiitb.sis.actions.admin.faculty;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.admin.faculty.facultyDao;
import edu.iiitb.sis.model.Faculty;

public class AddFacultyAction extends ActionSupport implements ModelDriven<Faculty>,SessionAware
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Faculty facultyModelObj=new Faculty();
	private String message;
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private SessionBean sessionBean;


	public String execute()
	{
		 facultyDao facultyDaoObj=new facultyDao();
		message=facultyDaoObj.addFaculty(facultyModelObj);
		
		if(!message.equalsIgnoreCase("success"))
			return "success";
		else
			return "failure";
		
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
		this.loginName=sessionBean.getUserName();
		this.loggedInUser=sessionBean.getName();
	}
	
	public Faculty getFacultyModelObj() {
		return facultyModelObj;
	}


	public void setFacultyModelObj(Faculty facultyModelObj) {
		this.facultyModelObj = facultyModelObj;
	}

	private String loggedInUser;
	public String getLoggedInUser() 
	{
		return loggedInUser;
	}
	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}	

	public Faculty getModel() 
	{
		return facultyModelObj;
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

package edu.iiitb.sis.actions.faculty;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.sis.actions.authentication.SessionBean;

public class FacultyEditProfilePage extends ActionSupport implements SessionAware
{

	
	private static final long serialVersionUID = 1L;
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private SessionBean sessionBean;
	
	public String execute()
	{
		
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

	public void setNewsList(ArrayList<String> newsList) {
		this.newsList = newsList;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	private String loggedInUser;
	public String getLoggedInUser() 
	{
		return loggedInUser;
	}
	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}	


}

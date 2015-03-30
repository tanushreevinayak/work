package edu.iiitb.sis.actions.admin.interest;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.admin.Interest_RetrieveDao;
import edu.iiitb.sis.model.Interest_Retrieve;

public class Interest_RetrieveAction extends ActionSupport implements ModelDriven<Interest_Retrieve>,SessionAware
{
	
	
	private static final long serialVersionUID = 1L;
	private Interest_Retrieve interest = new Interest_Retrieve(); 
	Interest_RetrieveDao interests_name = new Interest_RetrieveDao();
	public String success;
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private String message;
	private SessionBean sessionBean;
	
	
	public String execute()
	{
		interest.setInterests(interests_name.retrieveInterest(interest));
		System.out.println(interest.getInterests().get(0));
		
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
	public Interest_Retrieve getInterest()
	{
		return interest;
	}
	private String loggedInUser;
	public String getLoggedInUser() 
	{
		return loggedInUser;
	}
	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}	

	public void setInterest(Interest_Retrieve interest)
	{
		this.interest = interest;
	}

	public Interest_Retrieve getModel()
	{
		return interest;
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

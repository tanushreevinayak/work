package edu.iiitb.sis.actions.admin.interest;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.admin.interest.Admin_Add_Interest_Dao;
import edu.iiitb.sis.model.Admin_Add_Interest_Model;

public class Admin_Add_Interest_Action extends ActionSupport implements SessionAware,ModelDriven<Admin_Add_Interest_Model>
{

	
	private static final long serialVersionUID = 1L;
	Admin_Add_Interest_Model obj = new Admin_Add_Interest_Model();
	Admin_Add_Interest_Dao service = new Admin_Add_Interest_Dao();

	private SessionBean sessionBean=new SessionBean();
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private String loggedInUser;
	private String message;
	
	public String execute()
	{
		
		if(service.interest(obj))
		{	
			message="success";
			return "success";
		}
		else
		{
			message="Interest Already Exists";
			return "failure";
		}	
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
	//Getters and Setters
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
	public String getLoggedInUser() {
		return loggedInUser;
	}
	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}
	public Admin_Add_Interest_Model getModel() 
	{
		return obj;
	}
	public Admin_Add_Interest_Model getObj() 
	{
		return obj;
	}

	public void setObj(Admin_Add_Interest_Model obj)
	{
		this.obj = obj;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

			
}

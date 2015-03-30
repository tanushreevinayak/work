package edu.iiitb.sis.actions.admin.student;
import edu.iiitb.sis.actions.authentication.SessionBean;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddStudentPage extends ActionSupport implements SessionAware,ModelDriven<SessionBean>
{

	private static final long serialVersionUID = 1L;
	
	
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private SessionBean sessionBean;

	public String execute()
	{
		System.out.println(sessionBean.getName());
		return "success";
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
	public ArrayList<String> getAnnouncementList()
	{
		return announcementList;
	}
	private String loggedInUser;
	public String getLoggedInUser() 
	{
		return loggedInUser;
	}
	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
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

	public SessionBean getModel()
	{
		return sessionBean;
	}
	public SessionBean getSessionBean()
	{
		return sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) 
	{
		this.sessionBean = sessionBean;
	}

}

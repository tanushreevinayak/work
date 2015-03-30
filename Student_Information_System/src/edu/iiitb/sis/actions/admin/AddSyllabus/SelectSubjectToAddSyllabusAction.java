package edu.iiitb.sis.actions.admin.AddSyllabus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.admin.AddSyllabus.*;

public class SelectSubjectToAddSyllabusAction extends ActionSupport implements SessionAware
{

	
	private static final long serialVersionUID = 1L;
	private List<String> courselist=new ArrayList<String>();
	private  AddSyllabusDao AddSyllabusDaoObj=new AddSyllabusDao();
	
	
	
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private SessionBean sessionBean;
	private String loggedInUser;

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
	
	
	public String execute()
	{
		
		courselist=AddSyllabusDaoObj.SelectSubjectToAddSyllabus();
		
		return "success";
	}
	public List<String> getCourselist() {
		return courselist;
	}
	public void setCourselist(List<String> courselist) {
		this.courselist = courselist;
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
	public String getLoggedInUser() {
		return loggedInUser;
	}
	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}
	
	
	
	
	
}

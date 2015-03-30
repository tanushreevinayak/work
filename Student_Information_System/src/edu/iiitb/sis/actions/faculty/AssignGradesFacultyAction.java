package edu.iiitb.sis.actions.faculty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.faculty.AssignGradesDao;

public class AssignGradesFacultyAction extends ActionSupport implements SessionAware
{
	
	private static final long serialVersionUID = 1L;

	private AssignGradesDao AssignGradesDaoObj=new AssignGradesDao();
	
	private List<String> courselist=new ArrayList<String>();
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private SessionBean sessionBean;
	
	
	public String execute()
	{
	
		courselist=AssignGradesDaoObj.assignGradesFunction(loginName);
		if(!courselist.isEmpty())
		
		return "success";
		else
			return "failure";
	}
	public List<String> getCourselist() 
	{
		return courselist;
	}
	public void setCourselist(List<String> courselist) 
	{
		this.courselist = courselist;
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
	
	

}

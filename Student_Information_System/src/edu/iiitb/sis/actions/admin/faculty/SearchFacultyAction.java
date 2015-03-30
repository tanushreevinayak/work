package edu.iiitb.sis.actions.admin.faculty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.admin.faculty.facultySelectDao;

public class SearchFacultyAction extends ActionSupport implements SessionAware,ModelDriven<SessionBean>
{
	
	
	private static final long serialVersionUID = 1L;
	private String message;
	private List<String> facultynamelist=new ArrayList<String>();
	
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private SessionBean sessionBean;
	
	public SessionBean getSessionBean() {
		return sessionBean;
	}
	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}
	public String execute()
	{
		facultySelectDao facultySelectDaoObj=new facultySelectDao();
		facultynamelist=facultySelectDaoObj.getFacutyNames();
		System.out.println(facultynamelist.get(0));
		
		return "success";
		
	}
	public String getMessage()
	{
		return message;
	}
	private String loggedInUser;
	public String getLoggedInUser() 
	{
		return loggedInUser;
	}
	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}	
	
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getFacultynamelist() {
		return facultynamelist;
	}
	public void setFacultynamelist(List<String> facultynamelist) {
		this.facultynamelist = facultynamelist;
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
	public SessionBean getModel()
	{
		return sessionBean;
	}

}

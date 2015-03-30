package edu.iiitb.sis.actions.admin.faculty;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.admin.faculty.GetFacultyDetailsDao;
import edu.iiitb.sis.model.Faculty;

public class GetFacultyDetailsAction extends ActionSupport implements ModelDriven<Faculty>,SessionAware 
{

	
	private static final long serialVersionUID = 1L;
	Faculty facultyModelObj=new Faculty();
	private String message;
	private String searchKey;
	GetFacultyDetailsDao facultyDetailsGetDao=new GetFacultyDetailsDao();
	//Setting Session Values
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;

	private SessionBean sessionBean;
	
	public String execute()
	{
		facultyDetailsGetDao.getFacutyDetails(facultyModelObj,searchKey);
		 System.out.println(facultyModelObj.getFacultyUserName());
		 System.out.println("Status :"+facultyModelObj.getStatus());
		 return "success";
	}
	
	public Faculty getFacultyModelObj() {
		return facultyModelObj;
	}


	public void setFacultyModelObj(Faculty facultyModelObj) {
		this.facultyModelObj = facultyModelObj;
	}


	public Faculty getModel() {
		// TODO Auto-generated method stub
		return facultyModelObj;
	}

	public String getMessage() {
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

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
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

	public SessionBean getSessionBean() {
		return sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
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
	
	
	
}

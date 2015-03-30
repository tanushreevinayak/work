package edu.iiitb.sis.actions.admin.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.admin.student.StudentDao;

public class SearchStudentAction extends ActionSupport implements SessionAware
{

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
	private String loggedInUser;
	public String getLoggedInUser() 
	{
		return loggedInUser;
	}
	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}	
	
	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	private static final long serialVersionUID = 1L;
	private List<String> listOfRollNumbers;
	private StudentDao studentDao;
	private String searchKey;
	private String message;
	
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private SessionBean sessionBean;
	
	public String execute()
	{
		System.out.println("Inside Search Student");
		studentDao=new StudentDao();
		listOfRollNumbers=new ArrayList<String>();
		listOfRollNumbers=studentDao.getStudentRollNumbers();
			
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
	
	public String getMessage() 
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}

	
	public List<String> getListOfRollNumbers() 
	{
		return listOfRollNumbers;
	}
	public void setListOfRollNumbers(List<String> listOfRollNumbers) 
	{
		this.listOfRollNumbers = listOfRollNumbers;
	}
	
	public String getSearchKey()
	{
		return searchKey;
	}

	public void setSearchKey(String searchKey)
	{
		this.searchKey = searchKey;
	}
	

	
}

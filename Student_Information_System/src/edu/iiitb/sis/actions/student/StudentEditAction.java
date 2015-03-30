package edu.iiitb.sis.actions.student;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.admin.news.NewsDao;
import edu.iiitb.sis.dao.student.StudentEditDao;
import edu.iiitb.sis.model.StudentEdit;

public class StudentEditAction extends ActionSupport implements ModelDriven<StudentEdit>,SessionAware
{
	
	private static final long serialVersionUID = 1L;
	private StudentEdit edit = new StudentEdit();
	private StudentEditDao edited = new StudentEditDao();
	private NewsDao newsDao=new NewsDao();
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private ArrayList<String> newsListByInterest=new ArrayList<String>();
	private String loginName;
	private String message;
	private SessionBean sessionBean;
	
	
	public String execute()
	{
		edit.setStudentRollNo(loginName);
		
		System.out.println(loginName);
		message = edited.EditDetails(edit);
		if(message.equalsIgnoreCase("success"))
		{
			newsListByInterest=newsDao.getNewsByInterest(loginName);
			sessionBean.setAnnouncementList(announcementList);
			if(newsListByInterest.isEmpty())
			{
				sessionBean.setNewsList(newsList);
			}
			else
			{
				sessionBean.setNewsList(newsListByInterest);
				newsList=newsListByInterest;
			}
			sessionMap.remove("Session");
			sessionMap.put("Session", sessionBean);
			message="Profile Updated Successfully";
			return "success";
		}
		else
		{
			message="Failes to Update Profile";
			return "failure";
		}
			
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

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public StudentEdit getEdit() {
		return edit;
	}

	public void setEdit(StudentEdit edit) {
		this.edit = edit;
	}

	public StudentEdit getModel() 
	{
		return edit;
	}

	
	
}

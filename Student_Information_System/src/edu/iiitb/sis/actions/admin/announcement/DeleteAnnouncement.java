package edu.iiitb.sis.actions.admin.announcement;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.admin.announcement.AnnouncementDao;

public class DeleteAnnouncement extends ActionSupport implements SessionAware
{

	private static final long serialVersionUID = 1L;
	private String message;
	private String id;
	private AnnouncementDao announcementDao=new AnnouncementDao();

	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private SessionBean sessionBean;
	
	public String execute()
	{
		message=announcementDao.deleteAnnouncement(id);
		if(message.equalsIgnoreCase("success"))
		{
			announcementList=announcementDao.getAnnouncements();
			sessionBean.setAnnouncementList(announcementList);
			sessionMap.remove("Session");
			sessionMap.put("Session", sessionBean);
			return "success";

		}
		else
		{
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
		this.announcementList=announcementDao.getAnnouncements();
		this.newsList=sessionBean.getNewsList();
		this.loginName=sessionBean.getUserName();
		this.loggedInUser=sessionBean.getName();
	}
	private String loggedInUser;
	
	
	public String getLoggedInUser() {
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



	public SessionBean getSessionBean() {
		return sessionBean;
	}



	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}



	public String getMessage() 
	{
		return message;
	}
	public void setMessage(String message) 
	{
		this.message = message;
	}
	public String getId() 
	{
		return id;
	}
	public void setId(String id) 
	{
		this.id = id;
	}
}

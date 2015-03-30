package edu.iiitb.sis.actions.admin.announcement;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.admin.announcement.AnnouncementDao;
import edu.iiitb.sis.model.Announcement;;
public class AddAnnouncementAction extends ActionSupport implements ModelDriven<Announcement>,SessionAware
{
	
	private static final long serialVersionUID = 1L;
	private Announcement announcement=new Announcement();
	private String message;
	private AnnouncementDao announcementDao=new AnnouncementDao();
	
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private SessionBean sessionBean;
	
	public String execute()
	{
		message=announcementDao.addAnnouncement(announcement);
		
		if(message.equalsIgnoreCase("success"))
		{
			announcementList=announcementDao.getAnnouncements();
			sessionBean.setAnnouncementList(announcementList);
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
		announcementList=announcementDao.getAnnouncements();
		newsList=sessionBean.getNewsList();
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
	public String getMessage() 
	{
		return message;
	}


	public void setMessage(String message)
	{
		this.message = message;
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

	public Announcement getModel() 
	{
		return announcement;
	}

}

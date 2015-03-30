package edu.iiitb.sis.actions.admin.news;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.admin.Interest_RetrieveDao;
import edu.iiitb.sis.dao.admin.announcement.AnnouncementDao;
import edu.iiitb.sis.dao.admin.news.NewsDao;

public class AddNewsPage extends ActionSupport implements SessionAware
{

	private static final long serialVersionUID = 1L;
	
	private AnnouncementDao announcementDao=new AnnouncementDao();
	private NewsDao newsDao=new NewsDao();
	private Interest_RetrieveDao interests_name = new Interest_RetrieveDao();

	private ArrayList<String> categoryList=new ArrayList<String>();
	
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private SessionBean sessionBean;
	
	
	public String execute()
	{
		sessionBean=(SessionBean)sessionMap.get("Session");
		categoryList=interests_name.getInterests();
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
		this.announcementList=announcementDao.getAnnouncements();
		this.newsList=newsDao.getNews();
		this.loginName=sessionBean.getUserName();
		this.loggedInUser=sessionBean.getName();
	}

	
	public ArrayList<String> getAnnouncementList() {
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
	public ArrayList<String> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(ArrayList<String> categoryList) {
		this.categoryList = categoryList;
	}


}

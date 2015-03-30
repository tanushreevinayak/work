package edu.iiitb.sis.actions.authentication;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import edu.iiitb.sis.dao.AuthenticationDao;
import edu.iiitb.sis.dao.admin.announcement.AnnouncementDao;
import edu.iiitb.sis.dao.admin.news.NewsDao;

import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.model.Login;

public class LoginAction implements ModelDriven<Login>,SessionAware
{
	private Login login=new Login();
	private String message;
	
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();

	private AnnouncementDao announcementDao=new AnnouncementDao();
	private NewsDao newsDao=new NewsDao();
	
	AuthenticationDao authenticate=new AuthenticationDao();
	private Map<String,Object> sessionMap=null;  
	private SessionBean sessionBean=new SessionBean();
	

	public String execute()
	{
		message=authenticate.checkLogin(login);
		announcementList=announcementDao.getAnnouncements();
		newsList=newsDao.getNews();
		
		for(String str:announcementList)
		{
			System.out.println(str);
		}
		if(message.equalsIgnoreCase("Admin"))
		{
			sessionBean.setName("Admin");
			sessionBean.setUserName("admin");
			sessionBean.setAnnouncementList(announcementList);
			sessionBean.setNewsList(newsList);
			sessionMap.put("Session", sessionBean);
			return "Admin";
			
		}
		else if(message.equalsIgnoreCase("Faculty"))
		{
			sessionBean.setName(authenticate.getFacultyName(login.getUserName()));
			sessionBean.setUserName(login.getUserName());
			sessionBean.setAnnouncementList(announcementList);
			sessionBean.setNewsList(newsList);

			sessionMap.put("Session", sessionBean);

			return "Faculty";
		}
		else if(message.equalsIgnoreCase("Student"))
		{
			ArrayList< String> newsListByInterest=new ArrayList<String>();
			sessionBean.setName(authenticate.getStudentName(login.getUserName()));
			sessionBean.setUserName(login.getUserName());
			newsListByInterest=newsDao.getNewsByInterest(login.getUserName());
			sessionBean.setAnnouncementList(announcementList);
			if(newsListByInterest.isEmpty())
			{
				
				sessionBean.setNewsList(newsList);
			}
			else
			{
				sessionBean.setNewsList(newsListByInterest);
			}
			sessionMap.put("Session", sessionBean);
			return "Student";
		}
		else
		{
			
			return "failure";
		}
		
	}
	public Map<String, Object> getSessionMap()
	{
		return sessionMap;
	}
	public void setSession(Map<String, Object> sessionMap) 
	{
			this.sessionMap=sessionMap;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	public Login getLogin() 
	{
		return login;
	}

	public void setLogin(Login login)
	{
		this.login = login;
	}

	public Login getModel()
	{
		return login;
	}
	public ArrayList<String> getAnnouncementList()
	{
		return announcementList;
	}
	public void setAnnouncementList(ArrayList<String> announcementList)
	{
		this.announcementList = announcementList;
	}
	


}

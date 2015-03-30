package edu.iiitb.sis.actions.admin.announcement;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.sis.dao.admin.announcement.AnnouncementDao;

public class GetAnnouncements extends ActionSupport
{
	
	private static final long serialVersionUID = 1L;
	private AnnouncementDao announcementDao=new AnnouncementDao();
	private ArrayList<String> announcementList=new ArrayList<String>();
	
	public String execute()
	{
		announcementList=announcementDao.getAnnouncements();
		if(announcementList.isEmpty())
		{
			return "failure";
		}
		else
		{
			return "success";
		}
	}
	
	public ArrayList<String> getAnnouncementList()
	{
		return announcementList;
	}
	public void setAnnouncementList(ArrayList<String> announcementList)
	{
		this.announcementList = announcementList;
	}
	private String loggedInUser;
	
	
	public String getLoggedInUser() {
		return loggedInUser;
	}
	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}
	
}

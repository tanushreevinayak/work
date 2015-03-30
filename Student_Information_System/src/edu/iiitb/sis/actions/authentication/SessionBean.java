package edu.iiitb.sis.actions.authentication;

import java.util.ArrayList;

public class SessionBean 
{
	private String userName;
	private String name;
	private ArrayList<String> announcementList;
	private ArrayList<String> newsList;
	public ArrayList<String> getNewsList() 
	{
		return newsList;
	}
	public void setNewsList(ArrayList<String> newsList) 
	{
		this.newsList = newsList;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
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

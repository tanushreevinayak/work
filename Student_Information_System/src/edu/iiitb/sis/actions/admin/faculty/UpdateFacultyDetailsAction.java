package edu.iiitb.sis.actions.admin.faculty;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.admin.faculty.UpdateFacultyDao;
import edu.iiitb.sis.model.Faculty;

public class UpdateFacultyDetailsAction extends ActionSupport implements ModelDriven<Faculty>
{
	private static final long serialVersionUID = 1L;
	Faculty facultyModelObj=new Faculty();
	private String message;
	UpdateFacultyDao updataFacultyDaoObj=new UpdateFacultyDao();
	
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private Map<String,Object> sessionMap=null;
	private SessionBean sessionBean;
	
	public String execute()
	{
		System.out.println(facultyModelObj.getStatus());
		message=updataFacultyDaoObj.updateFaculty(facultyModelObj);
		if(message.equalsIgnoreCase("success"))
		{
			message="Faculty Details Updated Successfully";
			return "success";	

		}
		else
		{
			message="Failed to Update Faculty Details";
			return "failure";
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
	public ArrayList<String> getNewsList() 
	{
		return newsList;
	}
	public void setNewsList(ArrayList<String> newsList)
	{
		this.newsList = newsList;
	}
	private String loggedInUser;
	public String getLoggedInUser() 
	{
		return loggedInUser;
	}
	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}	

	public String getLoginName()
	{
		return loginName;
	}
	public void setLoginName(String loginName) 
	{
		this.loginName = loginName;
	}
	public Faculty getModel()
	{
		return facultyModelObj;
	}
	public String getMessage() 
	{
		return message;
	}
	public void setMessage(String message) 
	{
		this.message = message;
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

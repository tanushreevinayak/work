package edu.iiitb.sis.actions.faculty;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.faculty.FacultyEditDao;
import edu.iiitb.sis.model.FacultyEdit;

public class FacultyEditAction extends ActionSupport implements SessionAware,ModelDriven<FacultyEdit>{
	
	private static final long serialVersionUID = 1L;
	private FacultyEdit faculty = new FacultyEdit();
	private String result,message;
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	FacultyEditDao editfaculty = new FacultyEditDao();
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private SessionBean sessionBean;
	
	public String execute()
	{
		System.out.println(faculty.getPhone());
		System.out.println(faculty.getQualification());
		faculty.setFacultyId(sessionBean.getUserName());
		System.out.println(faculty.getFacultyId());
		faculty.setFacultyId(loginName);
		faculty.setFacultyUserName(loginName);
		result = editfaculty.EditDetails(faculty);
		if(faculty.getPhone()!=null)
		{	
			if(result.equalsIgnoreCase("success"))
			{
				message="Details Updated Successfully";
			}
			else
			{
				message="Failed to Update";
			}
		}	
		return "success";

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
	private String loggedInUser;
	public String getLoggedInUser() 
	{
		return loggedInUser;
	}
	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}	

	public FacultyEdit getFaculty() {
		return faculty;
	}

	public void setFaculty(FacultyEdit faculty) {
		this.faculty = faculty;
	}

	public FacultyEdit getModel()
	{
		return faculty;
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



	

}

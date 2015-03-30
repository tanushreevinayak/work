package edu.iiitb.sis.actions.student;



import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.student.Student_Search_Dao;
import edu.iiitb.sis.model.Student_Search_Model;

public class StudentSearchAction extends ActionSupport implements SessionAware,ModelDriven<Student_Search_Model> 
{

	
	
	private static final long serialVersionUID = 1L;
	Student_Search_Model obj = new Student_Search_Model();	
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private String message;
	private SessionBean sessionBean;
	
	public Student_Search_Model getObj() {
		return obj;
	}

	public void setObj(Student_Search_Model obj) 
	{
		this.obj = obj;
	}
	
	
	Student_Search_Dao service = new Student_Search_Dao();
		
		public String execute()
		{
			System.out.println(obj.getStudent_rollno());
			if(service.search(obj))
			{
				System.out.println(obj.getStudent_name());
				return "success";
			}	
			else
				return "failure";
		}
		//The following will sets the Session Values
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

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		private String loggedInUser;
		public String getLoggedInUser() 
		{
			return loggedInUser;
		}
		public void setLoggedInUser(String loggedInUser) {
			this.loggedInUser = loggedInUser;
		}	

		public Student_Search_Model getModel()
		{
			return obj;
		}

		
				
}



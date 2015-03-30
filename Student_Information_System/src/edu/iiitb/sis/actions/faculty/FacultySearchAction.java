package edu.iiitb.sis.actions.faculty;



import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.faculty.Faculty_Search_Dao;
import edu.iiitb.sis.model.Faculty_Search_Model;


public class FacultySearchAction extends ActionSupport implements SessionAware,ModelDriven<Faculty_Search_Model> {

	
	private static final long serialVersionUID = 1L;
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private SessionBean sessionBean;
	Faculty_Search_Model obj = new Faculty_Search_Model();	
	
	
	public Faculty_Search_Model getObj() {
		return obj;
	}

	public void setObj(Faculty_Search_Model obj) {
		this.obj = obj;
	}
	
	private String loggedInUser;
	public String getLoggedInUser() 
	{
		return loggedInUser;
	}
	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}	


	Faculty_Search_Dao service = new Faculty_Search_Dao();
		
		public String execute()
		{			
			if(service.search(obj /*, "images/"+myFileFileName*/)){
				System.out.println("hul");
				return "success";
			}	else
				return "failure";
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
		public Faculty_Search_Model getModel() {
			return obj;
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



package edu.iiitb.sis.actions.student;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.student.ResultDAO;
import edu.iiitb.sis.model.Result_Model;
	public class Result extends ActionSupport implements SessionAware,ModelDriven<Result_Model>
	{
		
		private static final long serialVersionUID = 1L;
		Result_Model obj = new Result_Model();
		ResultDAO service = new ResultDAO();
		private Map<String,Object> sessionMap=null;
		private ArrayList<String> announcementList=new ArrayList<String>();
		private ArrayList<String> newsList=new ArrayList<String>();
		private String loginName;
		private SessionBean sessionBean;
		private String loggedInUser;

		public String execute()
		{
			System.out.println("Inside Result Function");
			if(service.check(obj,loginName))
			{	
				return "success";
			}
			else
			{	
				return "failure";
			}	
		}

		public Result_Model getModel() 
		{
			return obj;
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

		public String getLoginName() 
		{
			return loginName;
		}

		public void setLoginName(String loginName)
		{
			this.loginName = loginName;
		}

		public String getLoggedInUser() 
		{
			return loggedInUser;
		}

		public void setLoggedInUser(String loggedInUser)
		{
			this.loggedInUser = loggedInUser;
		}

		public Result_Model getObj() {
			return obj;
		}

		public void setObj(Result_Model obj) {
			this.obj = obj;
		}	
		
		
		
	}
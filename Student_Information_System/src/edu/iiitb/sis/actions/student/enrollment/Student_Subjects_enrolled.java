package edu.iiitb.sis.actions.student.enrollment;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.student.enrollment.Enrollmentdao;
import edu.iiitb.sis.model.Course;
import edu.iiitb.sis.model.Enroll;


public class Student_Subjects_enrolled extends ActionSupport implements ModelDriven<Enroll>,SessionAware
{
	
	private static final long serialVersionUID = 1L;
	int i=0;
	private Enroll en=new Enroll();
	private Course cs=new Course();

	
	public Course getCs() {
		return cs;
	}

	public void setCs(Course cs) {
		this.cs = cs;
	}

	public Enroll getEn() {
		return en;
	}

	public void setEn(Enroll en) {
		this.en = en;
	}

	Enrollmentdao enroll=new Enrollmentdao();
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private String result;
	private SessionBean sessionBean;
	
	
	
	public String execute()
	{
		result=enroll.enrolledSubjects(en,cs,loginName);
		if(result.equalsIgnoreCase("failure"))
		{
			result="failure";
			System.out.println(result);
			return "failure";
		}
		else
		{
			result="success";
			System.out.println(result);
			return "success";
		}
		
		
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

	
	
	public Enroll getModel() 
	{
		return en;
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

	public String getResult() 
	{
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	
	
	
}

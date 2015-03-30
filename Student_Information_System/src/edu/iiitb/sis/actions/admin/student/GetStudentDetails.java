package edu.iiitb.sis.actions.admin.student;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.admin.student.StudentDao;
import edu.iiitb.sis.model.Student;

public class GetStudentDetails extends ActionSupport implements ModelDriven<Student>,SessionAware
{
	
	private static final long serialVersionUID = 1L;
	
	private StudentDao studentDao;
	private String name;
	private String number;
	
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private SessionBean sessionBean;
	private String searchKey;
	private Student student=new Student();
	private String message;
	
	public String execute()
	{
		studentDao=new StudentDao();
		System.out.println("search key : "+searchKey);
		student=studentDao.getStudentDetails(searchKey);
		name=student.getStudentName();
		System.out.println(name);

		number=student.getStudentRollNo();
		if(student!=null)
		{
			return "success";
		}
		else
		{
			return "failure";	

		}
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

	private String loggedInUser;
	public String getLoggedInUser() 
	{
		return loggedInUser;
	}
	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}	
	
	public String getSearchKey()
	{
		return searchKey;
	}
	public void setSearchKey(String searchKey)
	{
		this.searchKey = searchKey;
	}
	public Student getStudent() 
	{
		return student;
	}
	public void setStudent(Student student) 
	{
		this.student = student;
	}
	public String getMessage() 
	{
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Student getModel() 
	{
		return student;
	}
	public Map<String, Object> getSessionMap()
	{
		return sessionMap;
	}
	public ArrayList<String> getAnnouncementList() 
	{
		return announcementList;
	}

	public void setAnnouncementList(ArrayList<String> announcementList) {
		this.announcementList = announcementList;
	}


	public String getName()
	{
		return name;
	}


	public void setName(String name) 
	{
		this.name = name;
	}

	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
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



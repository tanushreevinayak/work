package edu.iiitb.sis.actions.faculty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.faculty.AssignGradesDao;

public class AssignFacultyMainAction extends ActionSupport implements SessionAware
{
	
	private static final long serialVersionUID = 1L;
	private String coursename;
	private String studentKey;
	private String marks;
	private List<String> courselist=new ArrayList<String>();
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private SessionBean sessionBean;
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	private AssignGradesDao AssignGradesDaoObj=new AssignGradesDao();
	// info on main page
		private String Info;
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getStudentKey() {
		return studentKey;
	}
	public void setStudentKey(String studentKey) {
		this.studentKey = studentKey;
	}
	public String execute()
	{
		String returnn= AssignGradesDaoObj.insertmarkstodatabase(marks,coursename,studentKey);
		
		
		if(returnn.equalsIgnoreCase("success"))
		{
			setInfo("markssuccess");
			return "success";
		}
		else
		{
			setInfo("marksfail");
			return "success";
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
	
	public String getInfo() {
		return Info;
	}
	public void setInfo(String info) {
		Info = info;
	}
	public List<String> getCourselist() {
		return courselist;
	}
	public void setCourselist(List<String> courselist) {
		this.courselist = courselist;
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

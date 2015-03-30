package edu.iiitb.sis.actions.faculty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.faculty.AssignGradesDao;

public class AssignGradesGetStudentsAction extends ActionSupport implements SessionAware
{
	
	private static final long serialVersionUID = 1L;
	private String searchKey;
	private String coursenameforsecondpart;
	private String message;
	private List<String> courselist=new ArrayList<String>();
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private SessionBean sessionBean;
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
	private String loggedInUser;
	public String getLoggedInUser() 
	{
		return loggedInUser;
	}
	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
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

	/* author: monic
	 *    method for getiing student details when a courase is enters for assigning grades or when "click for student details " is clicked
	 */
	private List<String> studentlist=new ArrayList<String>();
	private AssignGradesDao AssignGradesDaoObj=new AssignGradesDao();
	public String execute()
	{
		studentlist=AssignGradesDaoObj.getstudentFunction(searchKey);
		setCoursenameforsecondpart(searchKey);
		if(!studentlist.isEmpty())
		{setMessage("studentlistsuccess");
			return "success";}
		else
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
	public List<String> getStudentlist() {
		return studentlist;
	}

	public void setStudentlist(List<String> studentlist) {
		this.studentlist = studentlist;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public String getCoursenameforsecondpart() {
		return coursenameforsecondpart;
	}

	public void setCoursenameforsecondpart(String coursenameforsecondpart) {
		this.coursenameforsecondpart = coursenameforsecondpart;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	
}

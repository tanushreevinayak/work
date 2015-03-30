package edu.iiitb.sis.actions.faculty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.faculty.AssignGradesDao;

public class AssignFacultyAction extends ActionSupport implements SessionAware
{
	
	private static final long serialVersionUID = 1L;
	private String message;
	private String searchKey;
	private String coursenameforsecondpart;
	private String marks;
	private String coursename;
	private String studentKey;
	
	// info on main page
	private String Info;
	
	
private AssignGradesDao AssignGradesDaoObj=new AssignGradesDao();
	private List<String> courselist=new ArrayList<String>();
	private List<String> studentlist=new ArrayList<String>();
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private SessionBean sessionBean;
	
	public String trail()
	{
		return "success";
	}
	
	// execute method coming from the click of the assign grades button othe click for course list button
	public String execute()
	{
	
		courselist=AssignGradesDaoObj.assignGradesFunction(loginName);
		if(!courselist.isEmpty())
		
		return "success";
		else
			return "failure";
	}
	/* author: monic
	 *    method for getiing student details when a courase is enters for assigning grades or when "click for student details " is clicked
	 */
	
	public String getStudentDetails()
	{
		studentlist=AssignGradesDaoObj.getstudentFunction(searchKey);
		coursenameforsecondpart=searchKey;
		if(!studentlist.isEmpty())
		{message="studentlistsuccess";
			return "success";}
		else
			return "failure";
	}
	/* author: monic
	 * method for giving marks
	 */
	public String markstodatabase()
	{
		String returnn= AssignGradesDaoObj.insertmarkstodatabase(marks,coursename,studentKey);
		System.out.println("segyhui");
		System.out.println(coursename);
		System.out.println(studentKey);
		System.out.println("afdgafg");
		
		if(returnn.equalsIgnoreCase("success"))
		{Info="markssuccess";
		return "success";}
		else
		{
			Info="marksfail";
			return "success";
		}
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
	public List<String> getCourselist() {
		return courselist;
	}
	public void setCourselist(List<String> courselist) {
		this.courselist = courselist;
	}
	private String loggedInUser;
	public String getLoggedInUser() 
	{
		return loggedInUser;
	}
	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
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

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

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

	public String getInfo() {
		return Info;
	}

	public void setInfo(String info) {
		Info = info;
	}

	

}

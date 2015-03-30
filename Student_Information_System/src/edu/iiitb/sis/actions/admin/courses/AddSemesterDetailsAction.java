package edu.iiitb.sis.actions.admin.courses;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.model.AddSemesterDetailsModel;
import edu.iiitb.sis.model.CourseModel;
import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.admin.courses.AddSemesterDetailsDao;
import edu.iiitb.sis.dao.admin.courses.CourseDao;
public class AddSemesterDetailsAction extends ActionSupport implements SessionAware,ModelDriven<AddSemesterDetailsModel> 
{

	private static final long serialVersionUID = 1L;
	private AddSemesterDetailsModel course=new AddSemesterDetailsModel();
	private AddSemesterDetailsDao addSemesterDao=new AddSemesterDetailsDao();
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private String message;
	private SessionBean sessionBean;
		
	public String execute()
	{
		System.out.println(course.getCourseId());
		System.out.println(course.getSemesterName());
		message=addSemesterDao.addsemester(course);
		return "success";
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
	private String loggedInUser;
	public String getLoggedInUser() 
	{
		return loggedInUser;
	}
	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	public AddSemesterDetailsModel getCourse() {
		return course;
	}
	public void setCourse(AddSemesterDetailsModel course) {
		this.course = course;
	}
	@Override
	public AddSemesterDetailsModel getModel() {
		// TODO Auto-generated method stub
		return course;
	}
	
	
}

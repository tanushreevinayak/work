package edu.iiitb.sis.actions.admin.student;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.actions.authentication.SendEmail;
import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dao.admin.student.StudentDao;
import edu.iiitb.sis.model.Student;
import edu.iiitb.sis.model.UserDetails;

public class AddStudentAction extends ActionSupport implements SessionAware,ServletRequestAware,ModelDriven<Student>
{
	
	private static final long serialVersionUID = 1L;
	private HttpServletRequest servletRequest;
	private Student studentObj=new Student();
	private StudentDao studentDao;
	private String message;
	private UserDetails user=new UserDetails();
	private SendEmail sendEmail=new SendEmail();
	
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private SessionBean sessionBean;
	public String execute()
	{
		studentDao=new StudentDao();
		String destpath = servletRequest.getSession().getServletContext().getRealPath("/");
		studentObj.setImagePath(destpath);
		message=studentDao.addStudent(studentObj);
		setSessionValues();
		
		if(message.equalsIgnoreCase("success"))
		{
			user.setName(studentObj.getStudentName());
			user.setEmail(studentObj.getEmail());
			user.setPassword("password");
			user.setLoginId(studentObj.getStudentRollNo());
			message=sendEmail.sendUserDetailsToMail(user);
			return "success";
		}
		else
		{
			return "failure";
		}
		
	}
	
	public String pageRedirect()
	{
		System.out.println(sessionBean.getUserName());
		System.out.println(sessionBean.getName());
		setSessionValues();
		return "success";
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
	
		
	public String getMessage() 
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public Student getModel() 
	{
			return studentObj;
	}
	
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Student getStudentObj()
	{
		return studentObj;
	}

	public void setStudentObj(Student studentObj) 
	{
		this.studentObj = studentObj;
	}

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
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

}

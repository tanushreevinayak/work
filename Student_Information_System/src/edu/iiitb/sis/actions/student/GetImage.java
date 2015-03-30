package edu.iiitb.sis.actions.student;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.sis.actions.authentication.SessionBean;
import edu.iiitb.sis.dbUtil.ConnectionPool;

public class GetImage extends ActionSupport implements SessionAware
{
	
	private static final long serialVersionUID = 7900918441882265255L;
	private ArrayList<InputStream> inputStream;
	private String sid;
	private Map<String,Object> sessionMap=null;
	private ArrayList<String> announcementList=new ArrayList<String>();
	private ArrayList<String> newsList=new ArrayList<String>();
	private String loginName;
	private SessionBean sessionBean;
	private String loggedInUser;
	
	public  String getSid() {
		return this.sid;
	}


	public void setSid(String sid) {
		this.sid = sid;
	}


	public String execute() throws Exception 
	{
		 Connection c;
		 c=ConnectionPool.getConnection();
	    PreparedStatement pstmt = c.prepareStatement("select student_image from student where student_rollno=?");
	    System.out.println("Studentt Id : "+sid);
	    pstmt.setString(1, sid);
	    ResultSet rs = pstmt.executeQuery();
	    if(rs.next()){
	      //setInputStream(rs.getBinaryStream(1));
	    	HttpServletResponse res=ServletActionContext.getResponse();
	    	res.setContentType("image/jpeg");
	    	InputStream in=rs.getBinaryStream(1);
	    	OutputStream out=res.getOutputStream();
	    	byte[] buffer=new byte[1024];
	    	int len;
	    	while((len=in.read(buffer))!=-1)
	    	{
	    		out.write(buffer,0,len);
	    	}
	    }
	    return NONE;
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


	public String getLoggedInUser() {
		return loggedInUser;
	}


	public void setLoggedInUser(String loggedInUser) {
		this.loggedInUser = loggedInUser;
	}


	public ArrayList<InputStream> getInputStream() {
		return inputStream;
	}


	public void setInputStream(InputStream stream) {
		inputStream.add(stream);
	}
}

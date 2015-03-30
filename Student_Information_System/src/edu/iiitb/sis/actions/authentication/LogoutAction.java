package edu.iiitb.sis.actions.authentication;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware
{
	
	private static final long serialVersionUID = 1L;
	private String message;
	private Map<String,Object> sessionMap=null;  
	
	public String execute()
	{
		sessionMap.remove("Session");
		sessionMap.clear();
		message="Logged Out Successfully.";
		return "success";
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setSession(Map<String, Object> map)
	{
		this.sessionMap=map;
	}

}

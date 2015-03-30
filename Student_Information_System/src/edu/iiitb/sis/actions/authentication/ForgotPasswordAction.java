package edu.iiitb.sis.actions.authentication;
import edu.iiitb.sis.actions.authentication.SendEmail;

import com.opensymphony.xwork2.ActionSupport;

import edu.iiitb.sis.dao.AuthenticationDao;
import edu.iiitb.sis.model.UserDetails;

public class ForgotPasswordAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDetails user=new UserDetails();	
	private String rollNumber;
	private String message;
	private AuthenticationDao authenticationDao=new AuthenticationDao();
	private SendEmail sendMail=new SendEmail();
	public String execute()
	{
		user=authenticationDao.getUserDetails(rollNumber);
		if(user==null)
		{
			message="Invalid User Name";
			return "failure";
		}
		if(sendMail.sendPasswordDetails(user).equalsIgnoreCase("success"))
		{
			message="Password has been sent to your Mail.";
			return "success";

		}
		else
		{
			return "failure";

		}
	}
	
	public String getRollNumber()
	{
		return rollNumber;
	}
	public void setRollNumber(String rollNumber)
	{
		this.rollNumber = rollNumber;
	}
	public String getMessage() 
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	
}

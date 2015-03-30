package edu.iiitb.sis.actions.authentication;
import edu.iiitb.sis.dao.AuthenticationDao;
import com.opensymphony.xwork2.ModelDriven;

import edu.iiitb.sis.model.Login;

public class LoginAction implements ModelDriven<Login>
{
	private Login login=new Login();
	private String message;
	AuthenticationDao authenticate=new AuthenticationDao();
	
	public String execute()
	{
		message=authenticate.checkLogin(login);
		//System.out.println(message);
		if(message.equalsIgnoreCase("Admin"))
		{
			return "Admin";
		}
		else if(message.equalsIgnoreCase("Faculty"))
		{
			return "Faculty";
		}
		else if(message.equalsIgnoreCase("Student"))
		{
			return "Student";
		}
		else
		{
			return "failure";
		}
		
	}
	
	public Login getLogin() 
	{
		return login;
	}

	public void setLogin(Login login)
	{
		this.login = login;
	}

	public Login getModel()
	{
		return login;
	}

}

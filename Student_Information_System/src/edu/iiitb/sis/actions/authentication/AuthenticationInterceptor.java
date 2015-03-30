package edu.iiitb.sis.actions.authentication;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthenticationInterceptor implements Interceptor
{

	private static final long serialVersionUID = 1L;

	public void destroy() 
	{
		
	}

	public void init()
	{
		
	}

	public String intercept(ActionInvocation actionInvocation) throws Exception 
	{
		Map<String,Object> sessionMap=actionInvocation.getInvocationContext().getSession();
		SessionBean sessionBean=(SessionBean) sessionMap.get("Session");
		if(sessionBean==null)
		{
			 return "login";
		}
		else
		{
			    Action action = (Action) actionInvocation.getAction();
	            if(action instanceof UserAware)
	            {
	            	((UserAware)action).setSession(sessionBean);
	            }
	                
	           
	            return actionInvocation.invoke();
		}
	}

}

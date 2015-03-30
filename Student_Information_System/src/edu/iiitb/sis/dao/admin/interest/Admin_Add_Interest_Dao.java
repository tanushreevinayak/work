package edu.iiitb.sis.dao.admin.interest;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.Admin_Add_Interest_Model;



public class Admin_Add_Interest_Dao {

	public boolean interest(Admin_Add_Interest_Model obj)
	{
		try
		{
			Connection connection = ConnectionPool.getConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into interest(interest_name) values ('"+obj.getInterest_name()+"')");
			System.out.println(obj.getInterest_name());

			return true;
		}
		catch (SQLException e) 
		{
			System.out.println(e.getLocalizedMessage());
		}
		return false;
	}

}

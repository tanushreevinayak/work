package edu.iiitb.sis.dao.admin.faculty;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





import java.util.ArrayList;
import java.util.List;

import edu.iiitb.sis.dbUtil.ConnectionPool;

public class facultySelectDao {

	public List<String> getFacutyNames() {
		// TODO Auto-generated method stub
		
		List<String> facultyNamesList=new ArrayList<String>();
		Connection con=ConnectionPool.getConnection();
		Statement stmt=null;
		String queryToGetFacultyNames="select faculty_name from faculty";
		try {
			stmt=con.createStatement();
			ResultSet facultyNameResutSet=stmt.executeQuery(queryToGetFacultyNames);
			while(facultyNameResutSet.next())
			{
				System.out.println("hereee");
			   	facultyNamesList.add(facultyNameResutSet.getString("faculty_name"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.printStackTrace();
		}
		if(!facultyNamesList.isEmpty())
		return facultyNamesList;
		else
			return null;
	}

}

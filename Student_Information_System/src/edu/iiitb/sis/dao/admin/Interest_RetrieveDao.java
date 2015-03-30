package edu.iiitb.sis.dao.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.Interest_Retrieve;


import java.util.ArrayList;

public class Interest_RetrieveDao {
	private String interestQuery;
	
	private ArrayList<String> interests;
	public ArrayList<String> retrieveInterest(Interest_Retrieve interest)
	{
		interests= new ArrayList<String>();
		try{
			Connection con=ConnectionPool.getConnection();
			Statement interestStmt = con.createStatement();
			
			interestQuery = "select * from interest";
			ResultSet rs=interestStmt.executeQuery(interestQuery);
			while(rs.next())
			{
				 
				String inter = rs.getString("interest_name");
				
				interests.add(inter);
				System.out.println(inter);
			}
			
		}
		
		 catch (Exception e) 
		 {
			e.printStackTrace();
		}
		return interests;
	}
	public ArrayList<String> getInterests()
	{
		interests= new ArrayList<String>();
		try{
			Connection con=ConnectionPool.getConnection();
			Statement interestStmt = con.createStatement();
			
			interestQuery = "select * from interest";
			ResultSet rs=interestStmt.executeQuery(interestQuery);
			while(rs.next())
			{
				 
				String inter = rs.getString("interest_name");
				interests.add(inter);
			
			}
			
		}
		
		 catch (Exception e) 
		 {
			e.printStackTrace();
		}
		return interests;
	}
}
	
	
	






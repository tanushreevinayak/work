package edu.iiitb.sis.dao.admin.news;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import edu.iiitb.sis.dbUtil.ConnectionPool;
import edu.iiitb.sis.model.News;

public class NewsDao
{

	public String addNews(News news)
	{
		Connection con=ConnectionPool.getConnection();
		PreparedStatement addNewsStmt=null;
		String query;
		try
		{
			query="insert into news(news_id,news_info,news_type) values(?,?,?) ";
			addNewsStmt=con.prepareStatement(query);
			addNewsStmt.setString(1,news.getNewsId());
			addNewsStmt.setString(2, news.getNewsText());
			addNewsStmt.setString(3, news.getCategory());
			addNewsStmt.executeUpdate();
			addNewsStmt.close();
			con.close();
			return "success";	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "failure";
		}
			
	}
	public String deleteNews(String news_Id)
	{
		Connection con=ConnectionPool.getConnection();
		PreparedStatement deleteNewsStmt=null;
		String query;
		try
		{
			query="delete from news where news_id=?";
			deleteNewsStmt=con.prepareStatement(query);
			deleteNewsStmt.setString(1, news_Id);
			
			if(deleteNewsStmt.executeUpdate()>0)
			{
				return "success";
			}
			else
			{
				return "News ID doesn't Exist.";
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "failure";
		}
	}
	public ArrayList<String> getNews()
	{
		ArrayList<String> newsList=new ArrayList<String>();
		Connection con=ConnectionPool.getConnection();
		Statement newsStmt=null;
		String query;
		ResultSet rs=null;
		try
		{
			query="select news_info from news ";
			newsStmt=con.createStatement();
			rs=newsStmt.executeQuery(query);
			while(rs.next())
			{
				newsList.add(rs.getString("news_info"));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return newsList; 
	}
	public ArrayList<String> getNewsByInterest(String loginId)
	{
		ArrayList<String> newsList=new ArrayList<String>();
		Connection con=ConnectionPool.getConnection();
		Statement newsStmt=null;
		String query;
		ResultSet rs=null;
		try
		{
			query="select news_info from news where news_type in (select interest_name from student_interest where student_rollno='"+loginId+"')";
			newsStmt=con.createStatement();
			rs=newsStmt.executeQuery(query);
			while(rs.next())
			{
				newsList.add(rs.getString("news_info"));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return newsList; 
	}
}

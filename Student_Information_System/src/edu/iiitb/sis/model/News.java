package edu.iiitb.sis.model;

public class News 
{
	private String newsId;
	private String newsText;
	private String category;
	public String getNewsId() 
	{
		return newsId;
	}
	public void setNewsId(String newsId)
	{
		this.newsId = newsId;
	}
	public String getNewsText()
	{
		return newsText;
	}
	public void setNewsText(String newsText) 
	{
		this.newsText = newsText;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}


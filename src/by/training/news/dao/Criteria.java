package by.training.news.dao;

import javax.xml.datatype.XMLGregorianCalendar;

public enum Criteria {
	FIND_BY_NAME,FIND_BY_DATE;
	private XMLGregorianCalendar date;
	private String newsName;
	public XMLGregorianCalendar getDate() {
		return date;
	}
	public void setDate(XMLGregorianCalendar date) {
		this.date = date;
	}
	public String getNewsName() {
		return newsName;
	}
	public void setNewsName(String newsName) {
		this.newsName = newsName;
	}
	
}

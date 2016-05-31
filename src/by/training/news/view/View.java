package by.training.news.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import by.training.news.entity.Name;
import by.training.news.entity.Request;
import by.training.news.entity.Response;

public class View {
	
	public void printAnswer(Response response)
	{	
		System.out.println(response.getMessage());
		if(response.isStatus())
		{
			if(response.getNews()!=null)
			{
			    System.out.println(response.getNews().toString());	
			}
		}
	}
	
	public List<Request> doUserAction()
	{
		List<Request> requestList = new ArrayList<Request>();
		requestList.add(findByDate());
		requestList.add(findByName());
		requestList.add(addBookNews());
		requestList.add(addDiskNews());
		return requestList;
	}
	
	private Request addBookNews()
	{
		GregorianCalendar cl = new GregorianCalendar();
      	cl.setTime(new Date());
      	XMLGregorianCalendar date;
      	Request rq = null;
		try {
			date = DatatypeFactory.newInstance().newXMLGregorianCalendar(cl);
			rq = new Request();
	      	rq.setCommandName("SAVE_NEWS");
	      	rq.setCatName(Name.BOOKS);
	      	rq.setSubcName("adventures");
	      	rq.setNewsName("New book was written by Troelsen");
	      	List<String> l = new ArrayList<String>();
	      	l.add("Lobach I.P.");
	      	l.add("Miheev L.P");
	      	rq.setAuthors(l);
	      	rq.setDateOfIsssue(date);
	        rq.setNewsBody("In near future Tolkin might write some book about elves.");
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rq;
	}
	
	private Request addDiskNews()
	{
		GregorianCalendar cl = new GregorianCalendar();
      	cl.setTime(new Date());
      	XMLGregorianCalendar date;
      	Request rq = null;
		try {
			date = DatatypeFactory.newInstance().newXMLGregorianCalendar(cl);
			rq = new Request();
	      	rq.setCommandName("SAVE_NEWS");
	      	rq.setCatName(Name.DISKS);
	      	rq.setSubcName("programm");
	      	rq.setNewsName("New programm was created for Linux");
	      	List<String> l = new ArrayList<String>();
	      	l.add("Lobach I.P.");
	      	l.add("Miheev L.P");
	      	rq.setAuthors(l);
	      	rq.setDateOfIsssue(date);
	        rq.setNewsBody("We can use some program for working in Linux.");
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rq;
	}
	
	private Request findByName()
	{
		Request rq = new Request();
		String nameCommand = "FIND_NEWS";
		String criteriaName = "FIND_BY_NAME";
		String newsName = "Lara Croft";
		rq.setCommandName(nameCommand);
		rq.setCriteriaName(criteriaName);
		rq.setNewsName(newsName);
		return rq;
	}
	
	private Request findByDate()
	{
		Request rq = null;
		GregorianCalendar cl = new GregorianCalendar();
		XMLGregorianCalendar date;
		try {
			date = DatatypeFactory.newInstance().newXMLGregorianCalendar(cl);
			cl.setTime(new Date());
			date.setYear(2016);
			date.setMonth(5);
			date.setDay(28);
			rq = new Request();
			rq.setCommandName("FIND_NEWS");
			rq.setCriteriaName("FIND_BY_DATE");
			rq.setDateOfIsssue(date);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rq;
	}
}

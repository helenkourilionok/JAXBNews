package by.training.news.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import by.training.news.dao.Criteria;
import by.training.news.dao.INewsDAO;
import by.training.news.dao.NewsDAOFactory;
import by.training.news.dao.exception.NewsDAOException;
import by.training.news.entity.Name;
import by.training.news.entity.News;
import by.training.news.service.INewsService;
import by.training.news.service.exception.NewsServiceException;

public class NewsServiceImpl implements INewsService {

	@Override
	public void saveNews(Name catName, String subcName, String newsName, List<String> authors,
			XMLGregorianCalendar dateOfIsssue, String newsBody) {
		NewsDAOFactory nsDAO = new NewsDAOFactory();
		INewsDAO daoFactory = nsDAO.getInstance();
		List<Boolean> listErr = new ArrayList<Boolean>(); 
		try
		{
			listErr.add(checkDataOfIssue(dateOfIsssue));
			listErr.add(checkDigit(newsName));
			for(String a:authors)
			{
				listErr.add(checkDigit(a));
			}
			if(!isCorrect(listErr))
			{
				throw new NewsServiceException("Invalid data!");
			}
			daoFactory.saveNews(catName, subcName, newsName, authors, dateOfIsssue, newsBody);
		}
		catch(NewsServiceException e)
		{
			System.out.println(e.getMessage());
		}
		catch(NewsDAOException e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Override
	public News findNews(Criteria criteria) {
		NewsDAOFactory nsDAO = new NewsDAOFactory();
		INewsDAO daoFactory = nsDAO.getInstance();
		News n = null;
		boolean flag = false;
		try
		{
			switch(criteria)
			{
				case FIND_BY_NAME:
				{
					flag = checkDigit(criteria.getNewsName());
					if(!flag) throw new NewsServiceException("Invalid data!");
					n = daoFactory.findNews(criteria);
				}break;
				case FIND_BY_DATE:
				{
					flag = checkDataOfIssue(criteria.getDate());
					if(!flag) throw new NewsServiceException("Invalid data!");
					n = daoFactory.findNews(criteria);
				}break;
				default:
					break;
			}
		}
		catch(NewsServiceException e)
		{
			System.out.println(e.getMessage());
		}
		catch(NewsDAOException e)
		{
			System.out.println(e.getMessage());
		}
		return n;
	}
	
	private boolean isCorrect(List<Boolean> listErr)
	{
		boolean flag = false;
		int count = 0;
		for(Boolean b:listErr)
		{
			if(b) count++;
		}
		if(listErr.size()==count) flag = true;
		return flag;
	}
	
	private boolean checkDigit(String newsName)
	{
		boolean flag = false;
		Pattern p = Pattern.compile("([\\d]+)",Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(newsName);
		if(!m.find())
		{
			flag = true;
		}
		return flag;
	}
	
	private boolean checkDataOfIssue(XMLGregorianCalendar dateOfIsssue)
	{
		GregorianCalendar cl = new GregorianCalendar();
		cl.setTime(new Date());
		boolean flag = false;
		XMLGregorianCalendar date;
		try {
			date = DatatypeFactory.newInstance().newXMLGregorianCalendar(cl);
			if((dateOfIsssue.getYear()==date.getYear())&&
				(dateOfIsssue.getMonth()==date.getMonth()))
			{
				flag = true;
			}
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return flag;
	}
}

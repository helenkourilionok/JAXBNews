package by.training.news.dao.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.XMLGregorianCalendar;

import by.training.news.dao.Criteria;
import by.training.news.dao.INewsDAO;
import by.training.news.entity.Category;
import by.training.news.entity.Name;
import by.training.news.entity.News;
import by.training.news.entity.Provider;
import by.training.news.entity.Subcategory;
import by.training.news.entity.Website;


public class NewsDAOImpl implements INewsDAO {

	private static final String filePath;
	static
	{
		String str = new File(".").getAbsolutePath();
		String path = str.replace(".","");
		filePath = path+"\\resources\\news.xml";
	}
	
	
	@Override
	public void saveNews(Name catName, String subcName, String newsName, List<String> authors,
			XMLGregorianCalendar dateOfIsssue, String newsBody) {
		// TODO Auto-generated method stub
		try{
			
			File file = new File(filePath);
			
		    JAXBContext jc = JAXBContext.newInstance("by.training.news.entity");   
			Unmarshaller jaxbUnmarshaller = jc.createUnmarshaller();
			
		    Website w = (Website)jaxbUnmarshaller.unmarshal(file);
		    Category c = null;
		    Subcategory s = new Subcategory();
		    News n = new News();
		    Provider p = new Provider();
		    List<Category> clist = w.getCategory();
		    for(Category c1:clist)
		    {
		    	if(c1.getName().value().equals(catName.value()))
		    	{
		    		c = c1;
		    	}
		    }
		    if(c==null)
		    {
		    	c = new Category();
		        c.setName(catName);
	    		w.getCategory().add(c);
		    }
		    c.getSubcategory().add(s);
		    s.setName(subcName);
		    //news
		    p.getAuthor().addAll(authors);
		    n.setNewsBody(newsBody);
		    n.setNewsName(newsName);
		    n.setProvider(p);
		    n.setDataOfIssue(dateOfIsssue);
		    //news
		    s.getNews().add(n);
			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			m.marshal(w, file);
			//m.marshal(w, System.out);
		}
		catch(JAXBException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public News findNews(Criteria criteria) {
		// TODO Auto-generated method stub
		News n = null;
		try
		{
			File file = new File(filePath);
			JAXBContext jc = JAXBContext.newInstance("by.training.news.entity");
			Unmarshaller jaxbUnmarshaller = jc.createUnmarshaller();
		    Website w = (Website)jaxbUnmarshaller.unmarshal(file);
		    List<News> listNews = findAllNews(w);
			switch(criteria)
			{
				case FIND_BY_NAME:
				{
					String newsName = criteria.getNewsName();
					n = findByName(listNews, newsName);
				}
				break;
				case FIND_BY_DATE:
				{
					XMLGregorianCalendar date = criteria.getDate();
					n = findByDate(listNews, date);
				}
				default:
					break;
			}
		}
		catch(JAXBException e)
		{
			e.printStackTrace();
		}
		return n;
	}

	List<News> findAllNews(Website w)
	{
		List<Category> listCat = w.getCategory();
	    List<Subcategory> listSub = new ArrayList<Subcategory>();
	    List<News> listNews = new ArrayList<News>();
	    for(Category c:listCat)
	    {
	    	listSub.addAll(c.getSubcategory());
	    }
	    for(Subcategory s:listSub)
	    {
	    	listNews.addAll(s.getNews());
	    }
		return listNews;
	}
	
	private News findByName(List<News> listNews,String newsName)
	{
		News nResult = null;
		for(News n:listNews)
		{
			if(n.getNewsName().equals(newsName))
			{
				nResult = n;
			}
		}
		return nResult;
	}
	
	private News findByDate(List<News> listNews,XMLGregorianCalendar date)
	{
		News nResult = null;
		XMLGregorianCalendar xc = null;
		for(News n:listNews)
		{
			xc = n.getDataOfIssue();
			if((xc.getYear()==date.getYear())&&
				(xc.getMonth()==date.getMonth())&&
				(xc.getDay()==xc.getDay()))
			{
				nResult = n;
			}
		}
		return nResult;
	}
}

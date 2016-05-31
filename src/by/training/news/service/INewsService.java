package by.training.news.service;

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import by.training.news.dao.Criteria;
import by.training.news.entity.Name;
import by.training.news.entity.News;
import by.training.news.service.exception.NewsServiceException;

public interface INewsService {
	void saveNews(Name catName,String subcName,
			String newsName,List<String> authors,
			XMLGregorianCalendar dateOfIsssue,String newsBody) throws NewsServiceException;
	News findNews(Criteria criteria)throws NewsServiceException;
}

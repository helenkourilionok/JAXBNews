package by.training.news.dao;

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import by.training.news.dao.exception.NewsDAOException;
import by.training.news.entity.Name;
import by.training.news.entity.News;

public interface INewsDAO {
	void saveNews(Name catName,String subcName,
					String newsName,List<String> authors,
					XMLGregorianCalendar dateOfIsssue,String newsBody) throws NewsDAOException;
	News findNews(Criteria criteria)throws NewsDAOException;
}

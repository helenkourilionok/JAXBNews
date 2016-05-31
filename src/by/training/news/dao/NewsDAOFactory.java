package by.training.news.dao;

import by.training.news.dao.impl.NewsDAOImpl;

public class NewsDAOFactory {
	private INewsDAO newsDAO;
	public INewsDAO getInstance()
	{
		if(newsDAO == null)
		{
			newsDAO = new NewsDAOImpl();
		}
		return newsDAO;
	}
}

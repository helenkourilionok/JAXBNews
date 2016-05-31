package by.training.news.service;

import by.training.news.service.impl.NewsServiceImpl;

public class NewsServiceFactory {
	private INewsService newsService;
	public INewsService getInstance()
	{
		if(newsService==null){
			newsService = new NewsServiceImpl();
		}
		return newsService;
	}
}

package by.training.news.command.impl;

import by.training.news.command.ICommand;
import by.training.news.dao.Criteria;
import by.training.news.entity.News;
import by.training.news.entity.Request;
import by.training.news.entity.Response;
import by.training.news.service.INewsService;
import by.training.news.service.NewsServiceFactory;
import by.training.news.service.exception.NewsServiceException;

public class FindNewsCommandImpl implements ICommand {

	@Override
	public Response execute(Request request) {
		NewsServiceFactory serviceFactory = new NewsServiceFactory();
		INewsService newsService = serviceFactory.getInstance();
		Response response = new Response();
		News n = null;
		Criteria criteria = Criteria.valueOf(request.getCriteriaName()); 
		try
		{
			switch(criteria)
			{
				case FIND_BY_NAME:
				{
					criteria.setNewsName(request.getNewsName());
					n = newsService.findNews(criteria);
				}break;
				case FIND_BY_DATE:
				{
					criteria.setDate(request.getDateOfIsssue());
					n = newsService.findNews(criteria);
				}break;
				default:
					break;
			}
			if(n!=null)
			{
				response.setNews(n);
				response.setStatus(true);
				response.setMessage("Operation ended successfuly!");
			}
			else
			{	
				response.setStatus(false);
				response.setMessage("News wasn't found!");
			}
		}
		catch(NewsServiceException e)
		{
			System.out.println(e.getMessage());
			response.setStatus(false);
			response.setMessage("Operation failed!");
		}
		return response;
	}

}

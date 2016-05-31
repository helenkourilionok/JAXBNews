package by.training.news.command.impl;

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import by.training.news.command.ICommand;
import by.training.news.entity.Name;
import by.training.news.entity.Request;
import by.training.news.entity.Response;
import by.training.news.service.INewsService;
import by.training.news.service.NewsServiceFactory;
import by.training.news.service.exception.NewsServiceException;

public class SaveNewsCommandImpl implements ICommand {

	@Override
	public Response execute(Request request) {
		Name catName = request.getCatName();
		String subcName = request.getSubcName();
		String newsName = request.getNewsName();
		List<String> authors = request.getAuthors();
		XMLGregorianCalendar dateOfIsssue = request.getDateOfIsssue();
		String newsBody = request.getNewsBody();
		NewsServiceFactory serviceFactory = new NewsServiceFactory();
		INewsService newsService = serviceFactory.getInstance();
		Response response = new Response();
		try
		{
			newsService.saveNews(catName, subcName, newsName, authors, dateOfIsssue, newsBody);
			response.setMessage("Operation ended successfuly!");
			response.setStatus(true);
		}
		catch(NewsServiceException e)
		{
			System.out.println(e.getMessage());
			response.setMessage("Operation failed!");
			response.setStatus(false);
		}
		return response;
	}

}

package by.training.news.controller;


import by.training.news.command.ICommand;
import by.training.news.entity.Request;
import by.training.news.entity.Response;

public class Controller {
	private CommandHelper ch = new CommandHelper();
	public Response doAction(Request request)
	{
		ICommand command = ch.getCommand(request.getCommandName());
		Response response = command.execute(request);
		return response;
	}
}

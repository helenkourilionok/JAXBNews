package by.training.news.command;

import by.training.news.entity.Request;
import by.training.news.entity.Response;

public interface ICommand {
	Response execute(Request request);
}

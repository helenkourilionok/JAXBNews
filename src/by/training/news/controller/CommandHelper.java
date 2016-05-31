package by.training.news.controller;

import java.util.HashMap;
import java.util.Map;

import by.training.news.command.ICommand;
import by.training.news.command.impl.FindNewsCommandImpl;
import by.training.news.command.impl.SaveNewsCommandImpl;

public class CommandHelper {
	private Map<CommandName,ICommand> commands = new HashMap<>();
	public CommandHelper() {
		commands.put(CommandName.SAVE_NEWS, new SaveNewsCommandImpl());
		commands.put(CommandName.FIND_NEWS, new FindNewsCommandImpl());
	}
	public ICommand getCommand(String nameCommand)
	{
		CommandName cm = CommandName.valueOf(nameCommand);
		ICommand ic = commands.get(cm);
		return ic;
	}
}

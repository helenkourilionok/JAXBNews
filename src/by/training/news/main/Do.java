package by.training.news.main;

import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import by.training.news.controller.Controller;
import by.training.news.entity.Request;
import by.training.news.entity.Response;
import by.training.news.view.View;

public class Do {

	public static void main(String[] args) throws DatatypeConfigurationException {
		// TODO Auto-generated method stub
		View view = new View();
		List<Request> rqList = view.doUserAction();
		Controller controller = new Controller();
		Response response = null;
		for(Request r:rqList)
		{
			response = controller.doAction(r);
			view.printAnswer(response);
		}
	}

}

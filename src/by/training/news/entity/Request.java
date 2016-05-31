package by.training.news.entity;

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

public class Request {
	private Name catName;
	private String subcName;
	private String newsName;
	private List<String> authors;
	private XMLGregorianCalendar dateOfIsssue;
	private String newsBody;
	private boolean status; 
	private String message;
	private String commandName;
	private String criteriaName;
	public Name getCatName() {
		return catName;
	}
	public void setCatName(Name catName) {
		this.catName = catName;
	}
	public String getSubcName() {
		return subcName;
	}
	public void setSubcName(String subcName) {
		this.subcName = subcName;
	}
	public String getNewsName() {
		return newsName;
	}
	public void setNewsName(String newsName) {
		this.newsName = newsName;
	}
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public XMLGregorianCalendar getDateOfIsssue() {
		return dateOfIsssue;
	}
	public void setDateOfIsssue(XMLGregorianCalendar dateOfIsssue) {
		this.dateOfIsssue = dateOfIsssue;
	}
	public String getNewsBody() {
		return newsBody;
	}
	public void setNewsBody(String newsBody) {
		this.newsBody = newsBody;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCommandName() {
		return commandName;
	}
	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}
	public String getCriteriaName() {
		return criteriaName;
	}
	public void setCriteriaName(String criteriaName) {
		this.criteriaName = criteriaName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + ((catName == null) ? 0 : catName.hashCode());
		result = prime * result + ((commandName == null) ? 0 : commandName.hashCode());
		result = prime * result + ((criteriaName == null) ? 0 : criteriaName.hashCode());
		result = prime * result + ((dateOfIsssue == null) ? 0 : dateOfIsssue.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((newsBody == null) ? 0 : newsBody.hashCode());
		result = prime * result + ((newsName == null) ? 0 : newsName.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + ((subcName == null) ? 0 : subcName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (catName != other.catName)
			return false;
		if (commandName == null) {
			if (other.commandName != null)
				return false;
		} else if (!commandName.equals(other.commandName))
			return false;
		if (criteriaName == null) {
			if (other.criteriaName != null)
				return false;
		} else if (!criteriaName.equals(other.criteriaName))
			return false;
		if (dateOfIsssue == null) {
			if (other.dateOfIsssue != null)
				return false;
		} else if (!dateOfIsssue.equals(other.dateOfIsssue))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (newsBody == null) {
			if (other.newsBody != null)
				return false;
		} else if (!newsBody.equals(other.newsBody))
			return false;
		if (newsName == null) {
			if (other.newsName != null)
				return false;
		} else if (!newsName.equals(other.newsName))
			return false;
		if (status != other.status)
			return false;
		if (subcName == null) {
			if (other.subcName != null)
				return false;
		} else if (!subcName.equals(other.subcName))
			return false;
		return true;
	}
	
}

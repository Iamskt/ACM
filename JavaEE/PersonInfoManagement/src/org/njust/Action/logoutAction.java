package org.njust.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.*;

public class logoutAction extends ActionSupport {
	private String jsonData;
	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest(); 
		HttpSession session = request.getSession();
		session.removeAttribute("status");
		session.removeAttribute("user");
		session.removeAttribute("root");
		session.removeAttribute("userId");
		return SUCCESS;
	}
	
	public void setJsonData(String JsonData) {
		this.jsonData = JsonData;
	}
	
	public String getJsonData() {
		return this.jsonData;
	}
	
}
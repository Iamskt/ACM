package org.njust.Action;

import org.njust.Handle.UserHandle;

import com.opensymphony.xwork2.ActionSupport;

public class DelUserAction extends ActionSupport {
	private String userid;
	private String jsonData;
	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		UserHandle user = new UserHandle();
		Integer id = Integer.parseInt(userid);
		user.DeleteUser(id);
		return SUCCESS;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getJsonData() {
		return jsonData;
	}
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
}
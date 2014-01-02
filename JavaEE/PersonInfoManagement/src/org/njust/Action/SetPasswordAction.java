package org.njust.Action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.njust.Handle.*;

public class SetPasswordAction extends ActionSupport {
	private String username;
	
	private String oldpsw;
	
	private String newpsw;
	
	private String newpswConfirm;
	
	private String jsonData;
	

	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		UserHandle handle = new UserHandle();
		Integer id = handle.findUserID(username);
		boolean flag = handle.PasswordIsRight(id, oldpsw) == UserHandle.RIGHT_PASSWORD;
		Map<String, Object> map = new HashMap<String, Object>();
		if (flag) {
			handle.UpdatePasswordById(id, newpsw);
		}
		map.put("status", flag);
		JSONArray json = JSONArray.fromObject(map);
		jsonData = json.toString();
		return SUCCESS;
	}
	
	public String getJsonData() {
		return jsonData;
	}
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getOldpsw() {
		return oldpsw;
	}
	public void setOldpsw(String oldpsw) {
		this.oldpsw = oldpsw;
	}
	public String getNewpsw() {
		return newpsw;
	}
	public void setNewpsw(String newpsw) {
		this.newpsw = newpsw;
	}
	public String getNewpswConfirm() {
		return newpswConfirm;
	}
	public void setNewpswConfirm(String newpswConfirm) {
		this.newpswConfirm = newpswConfirm;
	}
}
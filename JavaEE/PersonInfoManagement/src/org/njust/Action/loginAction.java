package org.njust.Action;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.*;
import org.apache.struts2.ServletActionContext;
import org.njust.Handle.AdminUserHandle;
import org.njust.Handle.TeacherHandle;
import org.njust.Handle.UserHandle;
import net.sf.json.JSONArray;


import com.opensymphony.xwork2.ActionSupport;

public class loginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	private String jsonData;

	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest(); 
		HttpSession session = request.getSession();
		Map<String, Object> map = new HashMap<String, Object>();
		UserHandle handle = new UserHandle();
		Integer id = handle.findUserID(username);
		Integer Auth = handle.CheckUserType(id);
		boolean flag = handle.PasswordIsRight(id, password) == UserHandle.RIGHT_PASSWORD;
		String user = "";
		String name = "";
		if (Auth == UserHandle.ADMINUSER) {
			name = new AdminUserHandle().findAdminuserByID(id).getUsername();
		} else {
			name = new TeacherHandle().findTeacherById(id).getUserName();
		}
		if (flag) user = this.username;
		map.put("status", flag);
		map.put("user", user);
		map.put("root", Auth);
		map.put("name", name);
		session.setAttribute("status", flag);
		session.setAttribute("user", user);
		session.setAttribute("root", Auth);
		session.setAttribute("name", name);
		JSONArray array = JSONArray.fromObject(map);
		jsonData = array.toString();
		return SUCCESS;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}
	
	public String getJsonData() {
		return jsonData;
	}
	
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

}
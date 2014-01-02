package org.njust.Action;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.*;
import org.apache.struts2.ServletActionContext;
import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONArray;

public class VerifyAction extends ActionSupport {
	private String jsonData;
	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest(); 
		HttpSession session = request.getSession();
		Object StatusObject = session.getAttribute("status");
		Object UserObject = session.getAttribute("user");
		Object UserIdObject = session.getAttribute("name");
		Object RootObject = session.getAttribute("root");
		boolean flag = false;
		String user = "";
		String name = "";
		int Auth = 0;
		if (StatusObject != null) {
			String tmp = StatusObject.toString();
			if (tmp == "true") {
				flag = true;
			}
		}
		
		if (UserObject != null) {
			user = (String)UserObject.toString();
			name = (String)UserIdObject;
		}
		if (RootObject != null) {
			String tmp = RootObject.toString();
			Auth = Integer.parseInt(tmp);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", flag);
		map.put("user", user);
		map.put("name", name);
		map.put("root", Auth);
		JSONArray json = JSONArray.fromObject(map);
		jsonData = json.toString();
		return SUCCESS;
	}

	public void setJsonData(String jsondata) {
		this.jsonData = jsondata;
	}
	
	public String getJsonData() {
		return this.jsonData;
	}
}
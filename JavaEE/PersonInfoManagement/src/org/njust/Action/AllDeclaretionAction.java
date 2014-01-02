package org.njust.Action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.njust.Handle.UserHandle;
import org.njust.bean.Declaretion;
import org.njust.dao.DeclaretionDAO;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

public class AllDeclaretionAction extends ActionSupport {
	private String jsonData;
	private List<Declaretion> declaretions;
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
		Integer id = 0; 
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
			id = new UserHandle().findUserID(user);
		}
		if (RootObject != null) {
			String tmp = RootObject.toString();
			Auth = Integer.parseInt(tmp);
		}
		
		DeclaretionDAO dao = new DeclaretionDAO();
		List<Declaretion> l1 = dao.findAll();
		this.declaretions = new ArrayList<Declaretion>();
		for (int i = 0; i < l1.size(); i ++) {
			Declaretion declaretion = l1.get(i).Clone();
			this.declaretions.add(declaretion);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", flag);
		map.put("user", user);
		map.put("name", name);
		map.put("root", Auth);
		map.put("declaretion", declaretions);
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
	public List<Declaretion> getDeclaretions() {
		return declaretions;
	}
	public void setDeclaretions(List<Declaretion> declaretions) {
		this.declaretions = declaretions;
	}
}
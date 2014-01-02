package org.njust.Action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.njust.Handle.AdminUserHandle;
import org.njust.Handle.DeclareauthorHandle;
import org.njust.Handle.DeclaretionHandle;
import org.njust.Handle.TeacherHandle;
import org.njust.Handle.UserHandle;
import org.njust.bean.*;
import com.opensymphony.xwork2.ActionSupport;

public class gainDeclaretionAction extends ActionSupport {
	private String pid;
	private String jsonData;
	private Declaretion declaretion;
	private List<Declareauthor> declareauthors;
	private User user;
	private String name;
	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(pid);
		Declaretion tmp = new DeclaretionHandle().GetDeclaretionByID(id);
		this.user = tmp.getUser().Clone();
		Integer userid = user.getId();
		if (new UserHandle().CheckUserType(userid) == UserHandle.ADMINUSER) {
			name = new AdminUserHandle().findAdminuserByID(userid).getUsername();
		} else {
			name = new TeacherHandle().findTeacherById(userid).getUserName();
		}
		declaretion = tmp.Clone();
		List<Declareauthor> l1 = new DeclareauthorHandle().GetDeclareauthorsByPaperID(id);
		this.declareauthors = new ArrayList<Declareauthor>();
		for (int i = 0; i < l1.size(); i ++) {
			this.declareauthors.add(l1.get(i).Clone());
		}
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("user", user);
		map.put("declaretion", declaretion);
		map.put("declareauthor", declareauthors);
		JSONArray json = JSONArray.fromObject(map);
		jsonData = json.toString();
		return SUCCESS;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getJsonData() {
		return jsonData;
	}
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
	public Declaretion getDeclaretion() {
		return declaretion;
	}
	public void setDeclaretion(Declaretion declaretion) {
		this.declaretion = declaretion;
	}
	public List<Declareauthor> getDeclareauthors() {
		return declareauthors;
	}
	public void setDeclareauthors(List<Declareauthor> declareauthors) {
		this.declareauthors = declareauthors;
	}
}
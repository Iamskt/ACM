package org.njust.Action;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.*;
import org.apache.struts2.ServletActionContext;
import java.util.HashMap;
import org.njust.bean.*;
import java.util.*;
import org.njust.Handle.*;
import net.sf.json.JSONArray;

public class UserAction extends ActionSupport {
	private String jsonData;

	private List<Node> teachers;
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
		boolean flag = false;
		String user = "";
		String name = "";
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
		UserHandle handle = new UserHandle();
		Integer id = handle.findUserID(user);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", flag);
		map.put("user", user);
		map.put("name", name);
		if (id != 0) {
			Adminuser admin = new AdminUserHandle().findAdminuserByID(id);
			Integer collegeid = admin.getCollegeId();
			TeacherHandle teacherHandle = new TeacherHandle();
			List<Teacher> l1 = teacherHandle.findTeacherByCollege(collegeid);
			this.teachers = new ArrayList<Node>();
			for (int i = 0; i < l1.size(); i ++) {
				Node node = new Node();
				Teacher tmp = l1.get(i);
				node.setCollegeName(new CollegeHandle().getCollegeByCollegeID(tmp.getCollegeId()).getCollegeName());
				node.setDepartment(tmp.getDepartment());
				node.setSalaryid(new UserHandle().findUserByID(tmp.getId()).getUsername());
				node.setUsername(tmp.getUserName());
				node.setId(tmp.getId());
				this.teachers.add(node);
			}
		}
		map.put("teacher", teachers);
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
	public List<Node> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Node> teachers) {
		this.teachers = teachers;
	}
}
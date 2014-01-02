package org.njust.Action;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.njust.bean.*;
import org.njust.Handle.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class TempUserAction extends ActionSupport {
	private String jsonData;
	private List<Node> teachers;
	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest(); 
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("user");
		Integer id = new UserHandle().findUserID(name);
		
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
		Map<String, Object> map = new HashMap<String, Object>();
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
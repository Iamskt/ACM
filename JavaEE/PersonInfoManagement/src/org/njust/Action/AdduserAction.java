package org.njust.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.njust.bean.*;
import org.apache.struts2.ServletActionContext;
import org.njust.Handle.*;
import com.opensymphony.xwork2.ActionSupport;

public class AdduserAction extends ActionSupport {
	private String name;
	private String teacherId;
	private String department;
	private String jsonData;
	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		UserHandle userHandle = new UserHandle();
		HttpServletRequest request = ServletActionContext.getRequest(); 
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("user");
		Integer id = userHandle.findUserID(username);
		TeacherHandle handle = new TeacherHandle();
		User user = userHandle.findUserByID(id);
		userHandle.AddUser(teacherId, "111111");
		Integer now = userHandle.findUserID(teacherId);
		User newuser = userHandle.findUserByID(now);
		handle.AddTeacher(newuser);
		handle.UpdateTeacher(now, name, new AdminUserHandle().findAdminuserByID(id).getCollegeId(), department);
		return SUCCESS;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getJsonData() {
		return jsonData;
	}
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
}
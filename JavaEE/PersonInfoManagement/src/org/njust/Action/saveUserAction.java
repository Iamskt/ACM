package org.njust.Action;

import org.njust.Handle.TeacherHandle;
import org.njust.Handle.UserHandle;

import com.opensymphony.xwork2.ActionSupport;

public class saveUserAction extends ActionSupport {
	private String name;
	private String userid;
	private String department;
	private String jsonData;
	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		TeacherHandle handle = new TeacherHandle();	
		UserHandle userHandle = new UserHandle();
		Integer id = userHandle.findUserID(userid);
		handle.UpdateTeacher(id, name, handle.findTeacherById(id).getCollegeId(), department);
		return SUCCESS;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
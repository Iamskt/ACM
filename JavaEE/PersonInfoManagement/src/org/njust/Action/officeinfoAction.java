package org.njust.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.njust.bean.*;
import org.apache.struts2.ServletActionContext;
import org.njust.Handle.AdminUserHandle;
import org.njust.Handle.TeacherHandle;
import org.njust.Handle.TeacherInfomationHandle;
import org.njust.Handle.UserHandle;

import com.opensymphony.xwork2.ActionSupport;

public class officeinfoAction extends ActionSupport {
	private String duty;
	private String title;
	private String institute;
	private String department;
	private String telAdd;
	private String area;
	private String workAdd;
	private String phone;
	private String mobile;
	private String mail1;
	private String mail2;
	private String mail3;
	private String jsonData;
	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest(); 
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("user");
		Integer id = new UserHandle().findUserID(name);
		TeacherInfomationHandle handle = new TeacherInfomationHandle();
		TeacherHandle th = new TeacherHandle();
		Teacher teacher = th.findTeacherById(id);
		if (teacher != null) {
			teacher.setDepartment(department);
			th.UpdateTeacher(id, teacher.getUserName(), teacher.getCollegeId(), teacher.getDepartment());
		}
		if (mail2 == null) mail2 = "";
		if (mail3 == null) mail3 = "";
		handle.UpdateTeacherInfomation(id, duty, title, workAdd, mobile, mail1, mail2, mail3, phone, telAdd, area);
		return SUCCESS;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInstitute() {
		return institute;
	}
	
	public String getJsonData() {
		return jsonData;
	}
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getTelAdd() {
		return telAdd;
	}
	public void setTelAdd(String telAdd) {
		this.telAdd = telAdd;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getWorkAdd() {
		return workAdd;
	}
	public void setWorkAdd(String workAdd) {
		this.workAdd = workAdd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMail1() {
		return mail1;
	}
	public void setMail1(String mail1) {
		this.mail1 = mail1;
	}
	public String getMail2() {
		return mail2;
	}
	public void setMail2(String mail2) {
		this.mail2 = mail2;
	}
	public String getMail3() {
		return mail3;
	}
	public void setMail3(String mail3) {
		this.mail3 = mail3;
	}
}
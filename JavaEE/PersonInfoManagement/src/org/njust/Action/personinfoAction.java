package org.njust.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.njust.Handle.TeacherInfomationHandle;
import org.njust.Handle.UserHandle;
import org.njust.bean.Teacherinfomation;
import org.njust.dao.TeacherinfomationDAO;
import org.apache.struts2.ServletActionContext;
import org.hibernate.*;
import com.opensymphony.xwork2.ActionSupport;

public class personinfoAction extends ActionSupport {
	private String username;
	private String teacherId;
	private String shenfenzheng;
	private String birthday;
	private String zhengzhi;
	private String mingzu;
	private String jiguan;
	private String jsonDate;
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
		Teacherinfomation teacherinfomation = handle.findTeacherinfomationById(id);
		if (teacherinfomation == null) {
			handle.AddTeacherInfomation(new UserHandle().findUserByID(id));
		}
		handle.UpdateTeacherInfomation(id, birthday, zhengzhi, jiguan, mingzu, shenfenzheng);
		return SUCCESS;
	}
	
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getShenfenzheng() {
		return shenfenzheng;
	}
	public void setShenfenzheng(String shenfenzheng) {
		this.shenfenzheng = shenfenzheng;
	}
	public String getZhengzhi() {
		return zhengzhi;
	}
	public void setZhengzhi(String zhengzhi) {
		this.zhengzhi = zhengzhi;
	}
	public String getMingzu() {
		return mingzu;
	}
	public void setMingzu(String mingzu) {
		this.mingzu = mingzu;
	}
	public String getJiguan() {
		return jiguan;
	}
	public void setJiguan(String jiguan) {
		this.jiguan = jiguan;
	}

	public String getJsonDate() {
		return jsonDate;
	}

	public void setJsonDate(String jsonDate) {
		this.jsonDate = jsonDate;
	}
	
	
}
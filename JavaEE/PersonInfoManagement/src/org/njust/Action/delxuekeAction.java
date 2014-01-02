package org.njust.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.njust.Handle.SubjectHandle;
import org.njust.Handle.UserHandle;
import com.opensymphony.xwork2.ActionSupport;

public class delxuekeAction extends ActionSupport {
	private String tid;
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
		SubjectHandle handle = new SubjectHandle();
		Integer subjectid = Integer.parseInt(tid);
		handle.DeleteTeachertoSubject(subjectid, id);
		return SUCCESS;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getJsonData() {
		return jsonData;
	}
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
}
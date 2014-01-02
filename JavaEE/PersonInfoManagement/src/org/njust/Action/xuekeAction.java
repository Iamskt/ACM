package org.njust.Action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.http.*;

import net.sf.json.JSONArray;

import org.njust.Handle.*;
import org.njust.bean.*;
import org.apache.struts2.ServletActionContext;

public class xuekeAction extends ActionSupport {
	private String xuekename;
	private String xuekelevel;
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
		Subject subject = handle.findSubjectByname(xuekename);
		if (subject == null) {
			Integer tmp = handle.AddSubject(xuekename, xuekelevel);
			subject = handle.findSubjectById(tmp);
		}
		Integer subjectid = subject.getSubjectId();
		handle.AddTeachertoSubject(subjectid, id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tid", subjectid);
		JSONArray array = JSONArray.fromObject(map);
		jsonData = array.toString();
		return SUCCESS;
	}
	public String getXuekename() {
		return xuekename;
	}
	public void setXuekename(String xuekename) {
		this.xuekename = xuekename;
	}
	public String getXuekelevel() {
		return xuekelevel;
	}
	public void setXuekelevel(String xuekelevel) {
		this.xuekelevel = xuekelevel;
	}
	public String getJsonData() {
		return jsonData;
	}
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
}
package org.njust.Action;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONArray;
import org.njust.Handle.*;
import org.apache.struts2.ServletActionContext;
import org.njust.bean.*;
import com.opensymphony.xwork2.ActionSupport;

public class WorkexpAction extends ActionSupport {
	private String workSituation;
	private String department;
	private String startTime;
	private String endTime;
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
		Integer workexpId = 0;
		WorkExperienceHandle handle = new WorkExperienceHandle();
		if (tid == null) {
			workexpId = handle.AddWorkexperience(new UserHandle().findUserByID(id));
		} else {
			workexpId = Integer.parseInt(tid);
		}
		handle.SetWorkexperience(workexpId, startTime, endTime, department, workSituation);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tid", workexpId);
		JSONArray array = JSONArray.fromObject(map);
		jsonData = array.toString();
		return SUCCESS;
	}
	public String getWorkSituation() {
		return workSituation;
	}
	public void setWorkSituation(String workSituation) {
		this.workSituation = workSituation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
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
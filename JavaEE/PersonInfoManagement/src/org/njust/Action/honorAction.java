package org.njust.Action;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONArray;
import org.njust.bean.*;
import org.apache.struts2.ServletActionContext;
import org.njust.Handle.*;
import com.opensymphony.xwork2.ActionSupport;

public class honorAction extends ActionSupport {
	private String honorName;
	private String achieveTime;
	private String batch;
	private String level;
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
		Integer honorid = 0;
		HonorHandle handle = new HonorHandle();
		if (tid == null) {
			honorid = handle.AddHonor(new UserHandle().findUserByID(id));
		} else {
			honorid = Integer.parseInt(tid);
		}
		handle.SetHonor(honorid, honorName, achieveTime, batch, level);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tid", honorid);
		JSONArray array = JSONArray.fromObject(map);
		jsonData = array.toString();
		return SUCCESS;
	}
	public String getHonorName() {
		return honorName;
	}
	public void setHonorName(String honorName) {
		this.honorName = honorName;
	}
	public String getAchieveTime() {
		return achieveTime;
	}
	public void setAchieveTime(String achieveTime) {
		this.achieveTime = achieveTime;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
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
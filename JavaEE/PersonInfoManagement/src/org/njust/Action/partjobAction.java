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

public class partjobAction extends ActionSupport {
	private String partJobName;
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
		Integer partjobId = 0;
		PartJobHandle handle = new PartJobHandle();
		if (tid == null) {
			partjobId = handle.AddPartJob(new UserHandle().findUserByID(id));
		} else {
			partjobId = Integer.parseInt(tid);
		}
		handle.UpdatePartJob(partjobId, partJobName, startTime, endTime);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tid", partjobId);
		JSONArray array = JSONArray.fromObject(map);
		jsonData = array.toString();
		return SUCCESS;
	}
	public String getPartJobName() {
		return partJobName;
	}
	public void setPartJobName(String partJobName) {
		this.partJobName = partJobName;
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
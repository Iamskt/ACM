package org.njust.Action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.commons.collections.map.HashedMap;
import org.apache.struts2.ServletActionContext;
import org.njust.Handle.DegreeHandle;
import org.njust.Handle.UserHandle;
import org.njust.bean.Degree;

import com.opensymphony.xwork2.ActionSupport;

public class xueweiAction extends ActionSupport {
	private String xuewei;
	private String readtime;
	private String endtime;
	private String graduatedschool;
	private String schoollevel;
	private String area;
	private String highest;
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
		
		Integer degreeid = 0;
		DegreeHandle handle = new DegreeHandle();
		if (tid == null) {
			degreeid = handle.AddDegree(new UserHandle().findUserByID(id));
		} else {
			degreeid = Integer.parseInt(tid);
		}
		boolean thehigh = false;
		if (highest.compareTo("0") != 0) {
			thehigh = true;
		} else {
			thehigh = false;
		}
		handle.UpdateDegree(degreeid, xuewei, graduatedschool, area, readtime, endtime, schoollevel, thehigh);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tid", degreeid);
		JSONArray array = JSONArray.fromObject(map);
		jsonData = array.toString();
		return SUCCESS;
	}
	public String getXuewei() {
		return xuewei;
	}
	public void setXuewei(String xuewei) {
		this.xuewei = xuewei;
	}
	public String getReadtime() {
		return readtime;
	}
	public void setReadtime(String readtime) {
		this.readtime = readtime;
	}
	public String getGraduatedschool() {
		return graduatedschool;
	}
	public void setGraduatedschool(String graduatedschool) {
		this.graduatedschool = graduatedschool;
	}
	public String getSchoollevel() {
		return schoollevel;
	}
	public void setSchoollevel(String schoollevel) {
		this.schoollevel = schoollevel;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getHighest() {
		return highest;
	}
	public void setHighest(String highest) {
		this.highest = highest;
	}
	public String getJsonData() {
		return jsonData;
	}
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	
}
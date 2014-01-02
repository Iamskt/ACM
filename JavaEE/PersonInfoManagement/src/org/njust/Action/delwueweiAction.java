package org.njust.Action;

import org.njust.Handle.DegreeHandle;
import org.njust.bean.Degree;

import com.opensymphony.xwork2.ActionSupport;

public class delwueweiAction extends ActionSupport {
	private String tid;
	private String jsonData;
	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(tid);
		DegreeHandle handle = new DegreeHandle();
		handle.Delete(handle.findDegreeByID(id));
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
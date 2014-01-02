package org.njust.Action;

import org.njust.Handle.WorkExperienceHandle;

import com.opensymphony.xwork2.ActionSupport;

public class delworkexpAction extends ActionSupport {
	private String tid;
	private String jsonData;
	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(tid);
		WorkExperienceHandle handle = new WorkExperienceHandle();
		handle.Delete(handle.findWorkexperienceByID(id));
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
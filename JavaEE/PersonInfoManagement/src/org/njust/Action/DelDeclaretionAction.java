package org.njust.Action;

import org.njust.Handle.DeclaretionHandle;

import com.opensymphony.xwork2.ActionSupport;

public class DelDeclaretionAction extends ActionSupport {
	private String jsonData;
	private String declaretionid;
	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		DeclaretionHandle handle = new DeclaretionHandle();
		Integer id = Integer.parseInt(declaretionid);
		handle.Delete(handle.GetDeclaretionByID(id));
		return SUCCESS;
	}
	public String getJsonData() {
		return jsonData;
	}
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
	public String getDeclaretionid() {
		return declaretionid;
	}
	public void setDeclaretionid(String declaretionid) {
		this.declaretionid = declaretionid;
	}
}
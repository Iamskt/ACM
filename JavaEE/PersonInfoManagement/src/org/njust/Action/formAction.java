package org.njust.Action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.njust.Handle.DeclareauthorHandle;
import org.njust.Handle.DeclaretionHandle;
import org.njust.Handle.UserHandle;
import org.njust.bean.*;
import org.apache.commons.digester.plugins.Declaration;
import org.apache.struts2.ServletActionContext;

public class formAction extends ActionSupport {
	private String username;
	private String teacherId;
	private String department;
	private String telephone;
	private String CName;
	private String EName;
	private String PaperID;
	private String CCName;
	private String ECName;
	private String CLevel;
	private String ConCName;
	private String ConEName;
	private String ConLevel;	
	private String date;
	private Integer Volume;
	private Integer Period;
	private String StPage;
	private String EnPage;
	private String Authors;
	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		DeclaretionHandle handle = new DeclaretionHandle();
		HttpServletRequest request = ServletActionContext.getRequest(); 
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("user");
		Integer id = new UserHandle().findUserID(name);
		int index = handle.AddDeclaretion(new UserHandle().findUserByID(id));
		handle.UpdateDeclaretion(index, PaperID, department, telephone, CName, EName, CLevel, CCName, ECName, ConLevel, ConCName, ConEName, Volume, Period, StPage, EnPage, date);		
		String author[] = Authors.split("&");
		for (int i = 0; i < author.length; i ++) {
			String declareauthor[] = author[i].split("#");
			DeclareauthorHandle handle1 = new DeclareauthorHandle();
			int index1 = handle1.AddDeclareauthor(handle.GetDeclaretionByID(index));
			handle1.SetDeclareauthor(index1, declareauthor[0], declareauthor[1], declareauthor[2]);
		}
		return SUCCESS;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCName() {
		return CName;
	}
	public void setCName(String cName) {
		CName = cName;
	}
	public String getConLevel() {
		return ConLevel;
	}
	public void setConLevel(String conLevel) {
		ConLevel = conLevel;
	}
	public String getEName() {
		return EName;
	}
	public void setEName(String eName) {
		EName = eName;
	}
	public String getPaperID() {
		return PaperID;
	}
	public void setPaperID(String PaperID) {
		this.PaperID = PaperID;
	}
	public String getCCName() {
		return CCName;
	}
	public void setCCName(String cCName) {
		CCName = cCName;
	}
	public String getECName() {
		return ECName;
	}
	public void setECName(String eCName) {
		ECName = eCName;
	}
	public String getCLevel() {
		return CLevel;
	}
	public void setCLevel(String cLevel) {
		CLevel = cLevel;
	}
	public String getConEName() {
		return ConEName;
	}
	public void setConEName(String conEName) {
		ConEName = conEName;
	}
	public String getConCName() {
		return ConCName;
	}
	public void setConCName(String conCName) {
		ConCName = conCName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getVolume() {
		return Volume;
	}
	public void setVolume(Integer volume) {
		Volume = volume;
	}
	public Integer getPeriod() {
		return Period;
	}
	public void setPeriod(Integer period) {
		Period = period;
	}
	public String getStPage() {
		return StPage;
	}
	public void setStPage(String stPage) {
		StPage = stPage;
	}
	public String getEnPage() {
		return EnPage;
	}
	public void setEnPage(String enPage) {
		EnPage = enPage;
	}
	public String getAuthors() {
		return Authors;
	}
	public void setAuthors(String authors) {
		Authors = authors;
	}
	
	
}
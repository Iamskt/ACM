package org.njust.bean;

public class Node {
	private Integer id;
	private String username;
	private String CollegeName;
	private String department;
	private String salaryid;
	
	public Node() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCollegeName() {
		return CollegeName;
	}
	public void setCollegeName(String collegeName) {
		CollegeName = collegeName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getSalaryid() {
		return salaryid;
	}
	public void setSalaryid(String salaryid) {
		this.salaryid = salaryid;
	}
}

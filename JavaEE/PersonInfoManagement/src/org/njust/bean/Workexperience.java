package org.njust.bean;

/**
 * Workexperience entity. @author MyEclipse Persistence Tools
 */

public class Workexperience implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String startTime;
	private String endTime;
	private String department;
	private String workSituation;

	// Constructors

	/** default constructor */
	public Workexperience() {
	}

	/** full constructor */
	public Workexperience(User user, String startTime, String endTime,
			String department, String workSituation) {
		this.user = user;
		this.startTime = startTime;
		this.endTime = endTime;
		this.department = department;
		this.workSituation = workSituation;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getWorkSituation() {
		return this.workSituation;
	}

	public void setWorkSituation(String workSituation) {
		this.workSituation = workSituation;
	}
	
	public Workexperience Clone() {
        Workexperience workexperience = new Workexperience();
        workexperience.setId(this.getId());
        workexperience.setStartTime(this.getStartTime());
        workexperience.setEndTime(this.getEndTime());
        workexperience.setDepartment(this.getDepartment());
        workexperience.setWorkSituation(this.getWorkSituation());
        return workexperience;
    }
}
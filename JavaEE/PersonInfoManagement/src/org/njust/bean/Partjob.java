package org.njust.bean;

/**
 * Partjob entity. @author MyEclipse Persistence Tools
 */

public class Partjob implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String partJobName;
	private String startTime;
	private String endTime;

	// Constructors

	/** default constructor */
	public Partjob() {
	}

	/** full constructor */
	public Partjob(User user, String partJobName, String startTime,
			String endTime) {
		this.user = user;
		this.partJobName = partJobName;
		this.startTime = startTime;
		this.endTime = endTime;
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

	public String getPartJobName() {
		return this.partJobName;
	}

	public void setPartJobName(String partJobName) {
		this.partJobName = partJobName;
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
	public Partjob Clone() {
        Partjob partjob = new Partjob();
        partjob.setId(this.getId());
        partjob.setPartJobName(this.getPartJobName());
        partjob.setStartTime(this.getStartTime());
        partjob.setEndTime(this.getEndTime());
        return partjob;
    }
}
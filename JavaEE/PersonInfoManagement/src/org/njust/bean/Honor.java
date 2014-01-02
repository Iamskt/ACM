package org.njust.bean;

/**
 * Honor entity. @author MyEclipse Persistence Tools
 */

public class Honor implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String honorName;
	private String achieveTime;
	private String batch;
	private String level;

	// Constructors

	/** default constructor */
	public Honor() {
	}

	/** full constructor */
	public Honor(User user, String honorName, String achieveTime, String batch,
			String level) {
		this.user = user;
		this.honorName = honorName;
		this.achieveTime = achieveTime;
		this.batch = batch;
		this.level = level;
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

	public String getHonorName() {
		return this.honorName;
	}

	public void setHonorName(String honorName) {
		this.honorName = honorName;
	}

	public String getAchieveTime() {
		return this.achieveTime;
	}

	public void setAchieveTime(String achieveTime) {
		this.achieveTime = achieveTime;
	}

	public String getBatch() {
		return this.batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	public Honor Clone() {
        Honor honor = new Honor();
        honor.setId(this.getId());
        honor.setHonorName(this.getHonorName());
        honor.setAchieveTime(this.getAchieveTime());
        honor.setBatch(this.getBatch());
        honor.setLevel(this.getLevel());
        return honor;
    }
}
package org.njust.bean;

/**
 * Adminuser entity. @author MyEclipse Persistence Tools
 */

public class Adminuser implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String username;
	private Integer collegeId;

	// Constructors

	/** default constructor */
	public Adminuser() {
	}

	/** minimal constructor */
	public Adminuser(Integer id, User user) {
		this.id = id;
		this.user = user;
	}

	/** full constructor */
	public Adminuser(Integer id, User user, String username, Integer collegeId) {
		this.id = id;
		this.user = user;
		this.username = username;
		this.collegeId = collegeId;
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getCollegeId() {
		return this.collegeId;
	}

	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}
	public Adminuser Clone() {
        Adminuser adminuser = new Adminuser();
        adminuser.setId(this.getId());
        adminuser.setUsername(this.getUsername());
        adminuser.setCollegeId(this.getCollegeId());
        return adminuser;
    }
}
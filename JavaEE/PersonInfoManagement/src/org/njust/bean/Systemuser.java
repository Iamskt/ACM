package org.njust.bean;

/**
 * Systemuser entity. @author MyEclipse Persistence Tools
 */

public class Systemuser implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;

	// Constructors

	/** default constructor */
	public Systemuser() {
	}

	/** full constructor */
	public Systemuser(Integer id, User user) {
		this.id = id;
		this.user = user;
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

}
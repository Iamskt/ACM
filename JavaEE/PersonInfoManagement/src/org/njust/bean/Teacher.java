package org.njust.bean;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String userName;
	private Integer collegeId;
	private String department;

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(Integer id, User user) {
		this.id = id;
		this.user = user;
	}

	/** full constructor */
	public Teacher(Integer id, User user, String userName, Integer collegeId,
			String department) {
		this.id = id;
		this.user = user;
		this.userName = userName;
		this.collegeId = collegeId;
		this.department = department;
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

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getCollegeId() {
		return this.collegeId;
	}

	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	public Teacher Clone() {
        Teacher teacher = new Teacher();
        teacher.setId(this.getId());
        teacher.setUserName(this.getUserName());
        teacher.setCollegeId(this.getCollegeId());
        teacher.setDepartment(this.getDepartment());
        return teacher;
    }
}
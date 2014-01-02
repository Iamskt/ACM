package org.njust.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private Systemuser systemuser;
	private Set partjobs = new HashSet(0);
	private Adminuser adminuser;
	private Set workexperiences = new HashSet(0);
	private Teacherinfomation teacherinfomation;
	private Set declaretions = new HashSet(0);
	private Teacher teacher;
	private Set honors = new HashSet(0);
	private Set subjects = new HashSet(0);
	private Set degrees = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String username, String password, Systemuser systemuser,
			Set partjobs, Adminuser adminuser, Set workexperiences,
			Teacherinfomation teacherinfomation, Set declaretions,
			Teacher teacher, Set honors, Set subjects, Set degrees) {
		this.username = username;
		this.password = password;
		this.systemuser = systemuser;
		this.partjobs = partjobs;
		this.adminuser = adminuser;
		this.workexperiences = workexperiences;
		this.teacherinfomation = teacherinfomation;
		this.declaretions = declaretions;
		this.teacher = teacher;
		this.honors = honors;
		this.subjects = subjects;
		this.degrees = degrees;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Systemuser getSystemuser() {
		return this.systemuser;
	}

	public void setSystemuser(Systemuser systemuser) {
		this.systemuser = systemuser;
	}

	public Set getPartjobs() {
		return this.partjobs;
	}

	public void setPartjobs(Set partjobs) {
		this.partjobs = partjobs;
	}

	public Adminuser getAdminuser() {
		return this.adminuser;
	}

	public void setAdminuser(Adminuser adminuser) {
		this.adminuser = adminuser;
	}

	public Set getWorkexperiences() {
		return this.workexperiences;
	}

	public void setWorkexperiences(Set workexperiences) {
		this.workexperiences = workexperiences;
	}

	public Teacherinfomation getTeacherinfomation() {
		return this.teacherinfomation;
	}

	public void setTeacherinfomation(Teacherinfomation teacherinfomation) {
		this.teacherinfomation = teacherinfomation;
	}

	public Set getDeclaretions() {
		return this.declaretions;
	}

	public void setDeclaretions(Set declaretions) {
		this.declaretions = declaretions;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Set getHonors() {
		return this.honors;
	}

	public void setHonors(Set honors) {
		this.honors = honors;
	}

	public Set getSubjects() {
		return this.subjects;
	}

	public void setSubjects(Set subjects) {
		this.subjects = subjects;
	}

	public Set getDegrees() {
		return this.degrees;
	}

	public void setDegrees(Set degrees) {
		this.degrees = degrees;
	}
	
	public User Clone() {
        User user = new User();
        user.setId(this.getId());
        user.setUsername(this.getUsername());
        user.setPassword(this.getPassword());
        return user;
    }
}
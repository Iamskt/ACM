package org.njust.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Subject entity. @author MyEclipse Persistence Tools
 */

public class Subject implements java.io.Serializable {

	// Fields

	private Integer subjectId;
	private String subjectName;
	private String subjection;
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public Subject() {
	}

	/** full constructor */
	public Subject(String subjectName, String subjection, Set users) {
		this.subjectName = subjectName;
		this.subjection = subjection;
		this.users = users;
	}

	// Property accessors

	public Integer getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return this.subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjection() {
		return this.subjection;
	}

	public void setSubjection(String subjection) {
		this.subjection = subjection;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}
	public Subject Clone() {
        Subject subject = new Subject();
        subject.setSubjectId(this.getSubjectId());
        subject.setSubjectName(this.getSubjectName());
        subject.setSubjection(this.getSubjection());
        return subject;
    }
}
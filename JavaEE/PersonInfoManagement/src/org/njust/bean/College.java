package org.njust.bean;

/**
 * College entity. @author MyEclipse Persistence Tools
 */

public class College implements java.io.Serializable {

	// Fields

	private Integer collegeId;
	private String collegeName;

	// Constructors

	/** default constructor */
	public College() {
	}

	/** minimal constructor */
	public College(Integer collegeId) {
		this.collegeId = collegeId;
	}

	/** full constructor */
	public College(Integer collegeId, String collegeName) {
		this.collegeId = collegeId;
		this.collegeName = collegeName;
	}

	// Property accessors

	public Integer getCollegeId() {
		return this.collegeId;
	}

	public void setCollegeId(Integer collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return this.collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public College Clone() {
		College college = new College();
		college.setCollegeId(this.getCollegeId());
		college.setCollegeName(this.getCollegeName());
		return college;
	}
}
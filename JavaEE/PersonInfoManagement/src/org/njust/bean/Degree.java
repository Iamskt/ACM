package org.njust.bean;

/**
 * Degree entity. @author MyEclipse Persistence Tools
 */

public class Degree implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String degreename;
	private String graduationSchool;
	private String specialty;
	private String startTime;
	private String endTime;
	private String schoolLevel;
	private Boolean highestDegree;

	// Constructors

	/** default constructor */
	public Degree() {
	}

	/** full constructor */
	public Degree(User user, String degreename, String graduationSchool,
			String specialty, String startTime, String endTime,
			String schoolLevel, Boolean highestDegree) {
		this.user = user;
		this.degreename = degreename;
		this.graduationSchool = graduationSchool;
		this.specialty = specialty;
		this.startTime = startTime;
		this.endTime = endTime;
		this.schoolLevel = schoolLevel;
		this.highestDegree = highestDegree;
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

	public String getDegreename() {
		return this.degreename;
	}

	public void setDegreename(String degreename) {
		this.degreename = degreename;
	}

	public String getGraduationSchool() {
		return this.graduationSchool;
	}

	public void setGraduationSchool(String graduationSchool) {
		this.graduationSchool = graduationSchool;
	}

	public String getSpecialty() {
		return this.specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
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

	public String getSchoolLevel() {
		return this.schoolLevel;
	}

	public void setSchoolLevel(String schoolLevel) {
		this.schoolLevel = schoolLevel;
	}

	public Boolean getHighestDegree() {
		return this.highestDegree;
	}

	public void setHighestDegree(Boolean highestDegree) {
		this.highestDegree = highestDegree;
	}
	public Degree Clone() {
        Degree degree = new Degree();
        degree.setId(this.getId());
        degree.setDegreename(this.getDegreename());
        degree.setGraduationSchool(this.getGraduationSchool());
        degree.setSpecialty(this.getSpecialty());
        degree.setStartTime(this.getStartTime());
        degree.setEndTime(this.getEndTime());
        degree.setSchoolLevel(this.getSchoolLevel());
        degree.setHighestDegree(this.getHighestDegree());
        return degree;
    }
}
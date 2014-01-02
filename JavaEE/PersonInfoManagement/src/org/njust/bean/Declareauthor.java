package org.njust.bean;

/**
 * Declareauthor entity. @author MyEclipse Persistence Tools
 */

public class Declareauthor implements java.io.Serializable {

	// Fields

	private Integer id;
	private Declaretion declaretion;
	private String authorname;
	private String department;
	private String level;

	// Constructors

	/** default constructor */
	public Declareauthor() {
	}

	/** full constructor */
	public Declareauthor(Declaretion declaretion, String authorname,
			String department, String level) {
		this.declaretion = declaretion;
		this.authorname = authorname;
		this.department = department;
		this.level = level;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Declaretion getDeclaretion() {
		return this.declaretion;
	}

	public void setDeclaretion(Declaretion declaretion) {
		this.declaretion = declaretion;
	}

	public String getAuthorname() {
		return this.authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	public Declareauthor Clone() {
        Declareauthor declareauthor = new Declareauthor();
        declareauthor.setId(this.getId());
        declareauthor.setAuthorname(this.getAuthorname());
        declareauthor.setDepartment(this.getDepartment());
        declareauthor.setLevel(this.getLevel());
        return declareauthor;
    }
}
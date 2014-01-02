package org.njust.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * Declaretion entity. @author MyEclipse Persistence Tools
 */

public class Declaretion implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String paperId;
	private String department;
	private String telephone;
	private String putTime;
	private String cname;
	private String ename;
	private String cjname;
	private String ejname;
	private String jlevel;
	private String ccname;
	private String ecname;
	private String clevel;
	private Integer volume;
	private Integer period;
	private String stPage;
	private String edPage;
	private Set declareauthors = new HashSet(0);

	// Constructors

	/** default constructor */
	public Declaretion() {
	}

	/** full constructor */
	public Declaretion(User user, String paperId, String department,
			String telephone, String putTime, String cname, String ename,
			String cjname, String ejname, String jlevel, String ccname,
			String ecname, String clevel, Integer volume, Integer period,
			String stPage, String edPage, Set declareauthors) {
		this.user = user;
		this.paperId = paperId;
		this.department = department;
		this.telephone = telephone;
		this.putTime = putTime;
		this.cname = cname;
		this.ename = ename;
		this.cjname = cjname;
		this.ejname = ejname;
		this.jlevel = jlevel;
		this.ccname = ccname;
		this.ecname = ecname;
		this.clevel = clevel;
		this.volume = volume;
		this.period = period;
		this.stPage = stPage;
		this.edPage = edPage;
		this.declareauthors = declareauthors;
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

	public String getPaperId() {
		return this.paperId;
	}

	public void setPaperId(String paperId) {
		this.paperId = paperId;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPutTime() {
		return this.putTime;
	}

	public void setPutTime(String putTime) {
		this.putTime = putTime;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEname() {
		return this.ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getCjname() {
		return this.cjname;
	}

	public void setCjname(String cjname) {
		this.cjname = cjname;
	}

	public String getEjname() {
		return this.ejname;
	}

	public void setEjname(String ejname) {
		this.ejname = ejname;
	}

	public String getJlevel() {
		return this.jlevel;
	}

	public void setJlevel(String jlevel) {
		this.jlevel = jlevel;
	}

	public String getCcname() {
		return this.ccname;
	}

	public void setCcname(String ccname) {
		this.ccname = ccname;
	}

	public String getEcname() {
		return this.ecname;
	}

	public void setEcname(String ecname) {
		this.ecname = ecname;
	}

	public String getClevel() {
		return this.clevel;
	}

	public void setClevel(String clevel) {
		this.clevel = clevel;
	}

	public Integer getVolume() {
		return this.volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Integer getPeriod() {
		return this.period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public String getStPage() {
		return this.stPage;
	}

	public void setStPage(String stPage) {
		this.stPage = stPage;
	}

	public String getEdPage() {
		return this.edPage;
	}

	public void setEdPage(String edPage) {
		this.edPage = edPage;
	}

	public Set getDeclareauthors() {
		return this.declareauthors;
	}

	public void setDeclareauthors(Set declareauthors) {
		this.declareauthors = declareauthors;
	}
	public Declaretion Clone() {
        Declaretion declaretion = new Declaretion();
        declaretion.setId(this.getId());
        declaretion.setPaperId(this.getPaperId());
        declaretion.setDepartment(this.getDepartment());
        declaretion.setTelephone(this.getTelephone());
        declaretion.setPutTime(this.getPutTime());
        declaretion.setCname(this.getCname());
        declaretion.setEname(this.getEname());
        declaretion.setCjname(this.getCjname());
        declaretion.setEjname(this.getEjname());
        declaretion.setJlevel(this.getJlevel());
        declaretion.setCcname(this.getCcname());
        declaretion.setEcname(this.getEcname());
        declaretion.setClevel(this.getClevel());
        declaretion.setVolume(this.getVolume());
        declaretion.setPeriod(this.getPeriod());
        declaretion.setStPage(this.getStPage());
        declaretion.setEdPage(this.getEdPage());
        return declaretion;
    }
}
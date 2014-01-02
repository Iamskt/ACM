package org.njust.bean;

/**
 * Teacherinfomation entity. @author MyEclipse Persistence Tools
 */

public class Teacherinfomation implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String birthday;
	private String political;
	private String hometown;
	private String ethnic;
	private String identityId;
	private String administrativeDuty;
	private String title;
	private String officeAddress;
	private String officePhone;
	private String mail1;
	private String mail2;
	private String mail3;
	private String telePhone;
	private String communicationAddress;
	private String researchDirection;

	// Constructors

	/** default constructor */
	public Teacherinfomation() {
	}

	/** minimal constructor */
	public Teacherinfomation(Integer id, User user) {
		this.id = id;
		this.user = user;
	}

	/** full constructor */
	public Teacherinfomation(Integer id, User user, String birthday,
			String political, String hometown, String ethnic,
			String identityId, String administrativeDuty, String title,
			String officeAddress, String officePhone, String mail1,
			String mail2, String mail3, String telePhone,
			String communicationAddress, String researchDirection) {
		this.id = id;
		this.user = user;
		this.birthday = birthday;
		this.political = political;
		this.hometown = hometown;
		this.ethnic = ethnic;
		this.identityId = identityId;
		this.administrativeDuty = administrativeDuty;
		this.title = title;
		this.officeAddress = officeAddress;
		this.officePhone = officePhone;
		this.mail1 = mail1;
		this.mail2 = mail2;
		this.mail3 = mail3;
		this.telePhone = telePhone;
		this.communicationAddress = communicationAddress;
		this.researchDirection = researchDirection;
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

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPolitical() {
		return this.political;
	}

	public void setPolitical(String political) {
		this.political = political;
	}

	public String getHometown() {
		return this.hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getEthnic() {
		return this.ethnic;
	}

	public void setEthnic(String ethnic) {
		this.ethnic = ethnic;
	}

	public String getIdentityId() {
		return this.identityId;
	}

	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}

	public String getAdministrativeDuty() {
		return this.administrativeDuty;
	}

	public void setAdministrativeDuty(String administrativeDuty) {
		this.administrativeDuty = administrativeDuty;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOfficeAddress() {
		return this.officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public String getOfficePhone() {
		return this.officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getMail1() {
		return this.mail1;
	}

	public void setMail1(String mail1) {
		this.mail1 = mail1;
	}

	public String getMail2() {
		return this.mail2;
	}

	public void setMail2(String mail2) {
		this.mail2 = mail2;
	}

	public String getMail3() {
		return this.mail3;
	}

	public void setMail3(String mail3) {
		this.mail3 = mail3;
	}

	public String getTelePhone() {
		return this.telePhone;
	}

	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}

	public String getCommunicationAddress() {
		return this.communicationAddress;
	}

	public void setCommunicationAddress(String communicationAddress) {
		this.communicationAddress = communicationAddress;
	}

	public String getResearchDirection() {
		return this.researchDirection;
	}

	public void setResearchDirection(String researchDirection) {
		this.researchDirection = researchDirection;
	}
	
	public Teacherinfomation Clone() {
        Teacherinfomation teacherinfomation = new Teacherinfomation();
        teacherinfomation.setId(this.getId());
        teacherinfomation.setBirthday(this.getBirthday());
        teacherinfomation.setPolitical(this.getPolitical());
        teacherinfomation.setHometown(this.getHometown());
        teacherinfomation.setEthnic(this.getEthnic());
        teacherinfomation.setIdentityId(this.getIdentityId());
        teacherinfomation.setAdministrativeDuty(this.getAdministrativeDuty());
        teacherinfomation.setTitle(this.getTitle());
        teacherinfomation.setOfficeAddress(this.getOfficeAddress());
        teacherinfomation.setOfficePhone(this.getOfficePhone());
        teacherinfomation.setMail1(this.getMail1());
        teacherinfomation.setMail2(this.getMail2());
        teacherinfomation.setMail3(this.getMail3());
        teacherinfomation.setTelePhone(this.getTelePhone());
        teacherinfomation.setCommunicationAddress(this.getCommunicationAddress());
        teacherinfomation.setResearchDirection(this.getResearchDirection());
        return teacherinfomation;
    }
}
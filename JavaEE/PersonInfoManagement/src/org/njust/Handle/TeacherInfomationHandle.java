package org.njust.Handle;

import org.njust.bean.*;
import org.njust.db.HibernateSessionFactory;
import org.njust.dao.*;
import org.hibernate.*;
import java.text.DateFormat;
import java.util.*;
import javax.ejb.Handle;

public class TeacherInfomationHandle {
	TeacherinfomationDAO dao = null;
	
	public TeacherInfomationHandle() {
		dao = new TeacherinfomationDAO();
	}
	
	public void AddTeacherInfomation(User user) {
		Teacherinfomation teacherinfomation = new Teacherinfomation();
		teacherinfomation.setUser(user);
		teacherinfomation.setId(user.getId());
		teacherinfomation.setBirthday("12/08/13");
		teacherinfomation.setAdministrativeDuty("");
		teacherinfomation.setCommunicationAddress("");
		teacherinfomation.setEthnic("");
		teacherinfomation.setHometown("");
		teacherinfomation.setIdentityId("");
		teacherinfomation.setMail1("");
		teacherinfomation.setMail2("");
		teacherinfomation.setMail3("");
		teacherinfomation.setOfficeAddress("");
		teacherinfomation.setOfficePhone("");
		teacherinfomation.setPolitical("");
		teacherinfomation.setResearchDirection("");
		teacherinfomation.setTelePhone("");
		teacherinfomation.setTitle("");	
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.save(teacherinfomation);
		session.getTransaction().commit();
		session.close();
	}
	
	public void UpdateTeacherInfomation(Integer id, String birthday, String political, String hometown,
		String ethnic, String identityId, String administrativeDuty, String title, String officeAddress,
		String officePhone, String mail1, String mail2, String mail3, String telePhone,
		String communicationAddress, String researchDirection) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		Teacherinfomation teacherinfomation = (Teacherinfomation)dao.getSession().getTransaction();
		teacherinfomation.setBirthday(birthday);
		teacherinfomation.setPolitical(political);
		teacherinfomation.setHometown(hometown);
		teacherinfomation.setEthnic(ethnic);
		teacherinfomation.setIdentityId(identityId);
		teacherinfomation.setAdministrativeDuty(administrativeDuty);
		teacherinfomation.setTelePhone(telePhone);
		teacherinfomation.setTitle(title);
		teacherinfomation.setOfficeAddress(officeAddress);
		teacherinfomation.setOfficePhone(officePhone);
		teacherinfomation.setMail1(mail1);
		teacherinfomation.setMail2(mail2);
		teacherinfomation.setMail3(mail3);
		teacherinfomation.setCommunicationAddress(communicationAddress);
		teacherinfomation.setResearchDirection(researchDirection);	
		dao.getSession().update(teacherinfomation);
		tc.commit();
	}
	
	public void UpdateTeacherInfomation(Integer id, String birthday, String political, String hometown,
			String ethnic, String identityId) {
			Transaction tc = dao.getSession().getTransaction();
			tc.begin();
			Teacherinfomation teacherinfomation = (Teacherinfomation)dao.getSession().get(Teacherinfomation.class, id);
			teacherinfomation.setBirthday(birthday);
			teacherinfomation.setPolitical(political);
			teacherinfomation.setHometown(hometown);
			teacherinfomation.setEthnic(ethnic);
			teacherinfomation.setIdentityId(identityId);	
			dao.getSession().update(teacherinfomation);
			tc.commit();
	}
	
	public void UpdateTeacherInfomation(Integer id, String administrativeDuty, String title, String officeAddress,
			String officePhone, String mail1, String mail2, String mail3, String telePhone,
			String communicationAddress, String researchDirection) {
			Transaction tc = dao.getSession().getTransaction();
			tc.begin();
			Teacherinfomation teacherinfomation = (Teacherinfomation)dao.getSession().get(Teacherinfomation.class, id);
			teacherinfomation.setAdministrativeDuty(administrativeDuty);
			teacherinfomation.setTelePhone(telePhone);
			teacherinfomation.setTitle(title);
			teacherinfomation.setOfficeAddress(officeAddress);
			teacherinfomation.setOfficePhone(officePhone);
			teacherinfomation.setMail1(mail1);
			teacherinfomation.setMail2(mail2);
			teacherinfomation.setMail3(mail3);
			teacherinfomation.setCommunicationAddress(communicationAddress);
			teacherinfomation.setResearchDirection(researchDirection);	
			dao.getSession().update(teacherinfomation);
			tc.commit();
	}
	
	public Teacherinfomation findTeacherinfomationById(Integer id) {
		Teacherinfomation teacherinfomation = this.dao.findById(id);
		return teacherinfomation;
	}
}

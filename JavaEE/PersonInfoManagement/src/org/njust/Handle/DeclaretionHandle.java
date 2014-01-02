package org.njust.Handle;

import org.njust.bean.*;
import org.njust.dao.*;
import org.njust.db.HibernateSessionFactory;
import org.hibernate.*;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.*;

import javax.jws.soap.SOAPBinding.Use;

public class DeclaretionHandle {
	DeclaretionDAO dao = null;
	
	public DeclaretionHandle() {
		dao = new DeclaretionDAO();
	}
	
	public Integer AddDeclaretion(User user) {
		Declaretion declaretion = new Declaretion();
		declaretion.setUser(user);
		declaretion.setPutTime("");
		declaretion.setCcname("");
		declaretion.setCjname("");
		declaretion.setClevel("");
		declaretion.setCname("");
		declaretion.setDepartment("");
		declaretion.setEcname("");
		declaretion.setEdPage("");
		declaretion.setEjname("");
		declaretion.setEname("");
		declaretion.setJlevel("");
		declaretion.setPaperId("");
		declaretion.setPeriod(0);
		declaretion.setStPage("");
		declaretion.setTelephone("");
		declaretion.setVolume(0);
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		dao.save(declaretion);
		tc.commit();
		return declaretion.getId();
	}

	public void UpdateDeclaretion(Integer id, String PaperID, String department, String telephone,
			String CName, String EName, String CLevel, String CJName, String EJName, String JLevel, String CCName, 
			String ECName, int volume, int period, String Stpage, String edpage, String putTime) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		Declaretion declaretion = (Declaretion)dao.getSession().get(Declaretion.class, id);
		declaretion.setPaperId(PaperID);
		declaretion.setDepartment(department);
		declaretion.setTelephone(telephone);
		declaretion.setCname(CName);
		declaretion.setEname(EName);
		declaretion.setCjname(CJName);
		declaretion.setEjname(EJName);
		declaretion.setClevel(CLevel);
		declaretion.setJlevel(JLevel);
		declaretion.setCcname(CCName);
		declaretion.setEcname(ECName);
		declaretion.setVolume(volume);
		declaretion.setPeriod(period);
		declaretion.setStPage(Stpage);
		declaretion.setEdPage(edpage);
		declaretion.setPutTime(putTime);
		dao.getSession().update(declaretion);
		tc.commit();
	}

	public Declaretion GetDeclaretionByID(Integer id) {
		Declaretion declaretion = dao.findById(id);
		return declaretion;
	}
	
	public List<Declaretion> GetDeclaretionByTeacherID(Integer id) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		String hql = "from Declaretion as model where model.user.id = ?";
		Query query = dao.getSession().createQuery(hql);
		query.setParameter(0, id);
		tc.commit();
		List<Declaretion> list = query.list();
		return list;
	}
	
	public void Delete(Declaretion declaretion) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		dao.getSession().delete(declaretion);
		tc.commit();
	}
}

package org.njust.Handle;

import org.njust.bean.*;
import org.njust.dao.*;
import org.njust.db.HibernateSessionFactory;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.*;

public class WorkExperienceHandle {
	WorkexperienceDAO dao = null;

	public WorkExperienceHandle() {
		dao = new WorkexperienceDAO();
	}
	
	public Integer AddWorkexperience(User user) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		Workexperience workexperience = new Workexperience();
		workexperience.setUser(user);
		workexperience.setWorkSituation("");
		workexperience.setDepartment("");
		workexperience.setStartTime("");
		workexperience.setEndTime("");
		dao.save(workexperience);
		tc.commit();
		return workexperience.getId();
	}

	public void SetWorkexperience(Integer id, String StartTime, String EndTime, 
			String Department, String WorkSituation) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		Workexperience wep = (Workexperience)dao.getSession().get(Workexperience.class, id);
		wep.setDepartment(Department);
		wep.setStartTime(StartTime);
		wep.setEndTime(EndTime);
		wep.setWorkSituation(WorkSituation);
		dao.getSession().update(wep);
		tc.commit();
	}
	
	public Workexperience findWorkexperienceByID(Integer id) {
		Workexperience workexperience = dao.findById(id);
		return workexperience;
	}
	
	public List<Workexperience> findAllWorkexperience(Integer teacherId) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		String hql = "from Workexperience as wep where wep.user.id = ?";
		Query query = dao.getSession().createQuery(hql);
		query.setParameter(0, teacherId);
		tc.commit();
		List<Workexperience> list = query.list();
		return list;
	}

	public void Delete(Workexperience workexperience) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		dao.delete(workexperience);
		tc.commit();
	}
}

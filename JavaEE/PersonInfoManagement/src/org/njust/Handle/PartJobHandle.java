package org.njust.Handle;

import org.njust.bean.*;
import org.njust.dao.*;
import org.njust.db.HibernateSessionFactory;
import org.hibernate.*;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.*;

import javax.swing.text.TableView.TableCell;

public class PartJobHandle {
	PartjobDAO dao = null; 
	
	public PartJobHandle() {
		dao = new PartjobDAO();
	}
	
	public Integer AddPartJob(User user) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		Partjob partjob = new Partjob();
		partjob.setUser(user);
		partjob.setPartJobName("");
		partjob.setStartTime("");
		partjob.setEndTime("");
		dao.getSession().save(partjob);
		tc.commit();
		return partjob.getId();
	}

	public void UpdatePartJob(Integer id, String PartJobname, String StartTime, String EndTime) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		Partjob partjob = (Partjob)dao.getSession().get(Partjob.class, id);
		partjob.setPartJobName(PartJobname);
		partjob.setStartTime(StartTime);
		partjob.setEndTime(EndTime);
		dao.getSession().update(partjob);
		tc.commit();
	}

	public Partjob findPartJobById(Integer id) {
		Partjob partjob = dao.findById(id);
		return partjob;
	}
	
	public List<Partjob> findAllPartJob(Integer teacherId) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		String hql = "from Partjob as partjob where partjob.user.id = ?";
		Query query = dao.getSession().createQuery(hql);
		query.setParameter(0, teacherId);
		tc.commit();
		List<Partjob> list = query.list();
		return list;
	}

	public void Delete(Partjob partjob) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		dao.delete(partjob);
		tc.commit();
	}
}

package org.njust.Handle;

import org.njust.bean.*;
import org.njust.dao.*;
import org.njust.db.HibernateSessionFactory;
import org.hibernate.*;
import java.util.*;

public class HonorHandle {
	HonorDAO dao = null;
	
	public HonorHandle() {
		dao = new HonorDAO();
	}
	
	public Integer AddHonor(User user) {
		Honor honor = new Honor();
		honor.setUser(user);
		honor.setLevel("");
		honor.setAchieveTime("");
		honor.setHonorName("");
		honor.setBatch("");
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		dao.getSession().save(honor);
		tc.commit();
		return honor.getId();
	}

	public void SetHonor(Integer id, String honorname, String AchieveTime, String batch, String level) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		Honor honor = (Honor)dao.getSession().get(Honor.class, id);
		honor.setAchieveTime(AchieveTime);
		honor.setBatch(batch);
		honor.setLevel(level);
		honor.setHonorName(honorname);
		dao.getSession().update(honor);
		tc.commit();
	}

	public Honor findHonorByID(Integer id) {
		Honor honor = dao.findById(id);
		return honor;
	}
	
	public List<Honor> findAllHonorById(Integer teacherID) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		String hql = "from Honor as honor where honor.user.id = ?";
		Query query = dao.getSession().createQuery(hql);
		query.setParameter(0, teacherID);
		tc.commit();
		List<Honor> list = query.list();
		return list;
	}

	public void Delete(Honor honor) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		dao.delete(honor);
		tc.commit();
	}
}

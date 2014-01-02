package org.njust.Handle;

import org.njust.bean.*;
import org.njust.dao.*;
import org.njust.db.HibernateSessionFactory;
import org.hibernate.*;

import com.sun.jmx.trace.Trace;

import java.util.*;

public class DegreeHandle {
	DegreeDAO dao = null;
	
	public DegreeHandle() {
		dao = new DegreeDAO();
	}
	
	public Integer AddDegree(User user) {
		Degree degree = new Degree();
		degree.setUser(user);
		degree.setGraduationSchool("");
		degree.setSchoolLevel("");
		degree.setHighestDegree(false);
		degree.setSpecialty("");
		degree.setDegreename("");
		degree.setEndTime("");
		degree.setStartTime("");
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		dao.save(degree);
		tc.commit();
		return degree.getId();
	}

	public void UpdateDegree(Integer id, String degreename, String graduationSchool, String Specialty, String StartTime, 
			String EndTime, String SchoolLevel, boolean HighestDegree) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		Degree degree = (Degree)dao.getSession().get(Degree.class, id);
		degree.setDegreename(degreename);
		degree.setGraduationSchool(graduationSchool);
		degree.setSpecialty(Specialty);
		degree.setStartTime(StartTime);
		degree.setEndTime(EndTime);
		degree.setSchoolLevel(SchoolLevel);
		degree.setHighestDegree(HighestDegree);
		dao.getSession().update(degree);
		tc.commit();
	}

	public List<Degree> findAllDegreeById(Integer userId) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		String hql = "from Degree as degree where degree.user.id = ?";
		Query query = dao.getSession().createQuery(hql);
		query.setParameter(0, userId);
		tc.commit();
		List<Degree> list = query.list();
		return list;
	}
	
	public Degree findDegreeByID(Integer id) {
		Degree degree = dao.findById(id);
		return degree;
	}
	
	public List<Degree> findAllDegree() {
		List<Degree> list = dao.findAll();
		return list;
	}

	public void Delete(Degree degree) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		dao.delete(degree);
		tc.commit();
	}
}

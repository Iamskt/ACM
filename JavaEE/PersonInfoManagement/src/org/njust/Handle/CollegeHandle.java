package org.njust.Handle;

import java.util.*;
import org.njust.bean.*;
import org.njust.dao.CollegeDAO;
import org.njust.db.HibernateSessionFactory;
import org.hibernate.*;
import org.apache.poi.*;

public class CollegeHandle {
	CollegeDAO dao = null;
	public CollegeHandle() {
		dao = new CollegeDAO();
	}
	
	public void AddCollege(Integer CollegeID, String CollegeName) {
		College college = new College();
		college.setCollegeId(CollegeID);
		college.setCollegeName(CollegeName);	
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.save(college);
		session.getTransaction().commit();
		session.close();
	}
	
	public Integer getCollegeByCollegeName(String CollegeName) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		Integer id = 0;
		List<College> list = dao.findByCollegeName(CollegeName);
		if (list.size() > 0) {
			id = list.get(0).getCollegeId();
		}
		tc.commit();
		return id;
	}
	
	public College getCollegeByCollegeID(Integer CollegeID) {
		College college = dao.findById(CollegeID);
		return college;
	}
	
	public List<College> GetAllCollege() {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		List<College> list = this.dao.findAll(); 
		session.getTransaction().commit();
		session.close();
		return list;
	}
	
	public void DeleteCollege(Integer id) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		College college = (College)dao.getSession().get(College.class, id);
		dao.delete(college);
		tc.commit();
	}
	
}

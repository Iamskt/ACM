package org.njust.Handle;

import org.njust.bean.*;
import org.njust.dao.*;
import org.njust.db.HibernateSessionFactory;
import org.hibernate.*;
import java.util.*;

public class DeclareauthorHandle {
	DeclareauthorDAO dao = null;
	
	public DeclareauthorHandle() {
		dao = new DeclareauthorDAO();
	}
	
	public Integer AddDeclareauthor(Declaretion declaretion) {
		Declareauthor declareauthor = new Declareauthor();
		declareauthor.setDeclaretion(declaretion);
		declareauthor.setAuthorname("");
		declareauthor.setDepartment("");
		declareauthor.setLevel("");
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		session.save(declareauthor);
		session.getTransaction().commit();
		session.close();
		return declareauthor.getId();
	}
	
	public void SetDeclareauthor(Integer id, String authorname, String department, String level) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		Declareauthor declareauthor = new Declareauthor();
		session.load(declareauthor, id);
		declareauthor.setAuthorname(authorname);
		declareauthor.setDepartment(department);
		declareauthor.setLevel(level);
		session.update(declareauthor);
		session.getTransaction().commit();
		session.close();
	}
	
	public Declareauthor GetDeclareauthorByID(Integer id) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		Declareauthor declareauthor = dao.findById(id);
		session.getTransaction().commit();
		session.close();
		return declareauthor;
	}
	
	public List<Declareauthor> GetDeclareauthorsByPaperID(Integer paperId) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		String hql = "from Declareauthor as model where model.declaretion.id = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, paperId);
		session.getTransaction().commit();
		List<Declareauthor> list = query.list();
		session.close();
		return list;
		
	}
	
}

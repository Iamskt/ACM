package org.njust.Handle;

import org.njust.bean.*;
import org.njust.dao.*;
import org.njust.db.HibernateSessionFactory;
import org.hibernate.*;

import com.sun.jmx.trace.Trace;

import java.util.*;

public class SubjectHandle {
	SubjectDAO dao = null;
	
	public SubjectHandle() {
		dao = new SubjectDAO();
	}
	
	public Integer AddSubject(String SubjectName, String Subjection) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		Subject subject = new Subject();
		subject.setSubjection(Subjection);
		subject.setSubjectName(SubjectName);
		dao.getSession().save(subject);
		tc.commit();
		return subject.getSubjectId();
	}
	
	public Subject findSubjectById(Integer id) {
		Subject subject = dao.findById(id);
		return subject;
	}
	
	public Subject findSubjectByname(String subjectname) {
		List<Subject> list = dao.findBySubjectName(subjectname);
		Subject subject = null;
		if (list.size() != 0) {
			subject = list.get(0);
		}
		return subject;
	}
	
	public void UpdateSubject(Integer id, String SubjectName, String Subjection) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		Subject subject = (Subject)dao.getSession().get(Subject.class, id);
		subject.setSubjectName(SubjectName);
		subject.setSubjection(Subjection);
		dao.getSession().update(subject);
		tc.commit();
	}

	public void AddTeachertoSubject(Integer SubjectId, Integer Id) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		Subject subject = (Subject)dao.getSession().get(Subject.class, SubjectId);
		User user = (User)dao.getSession().get(User.class, Id);
		Set set1 = user.getSubjects();
		set1.add(subject);
		user.setSubjects(set1);
		Set set2 = subject.getUsers();
		set2.add(user);
		subject.setUsers(set2);
		dao.getSession().update(subject);
		dao.getSession().update(user); 
		tc.commit();
	}
	
	public void DeleteTeachertoSubject(Integer Subjectid, Integer id) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		Subject subject = (Subject)dao.getSession().get(Subject.class, Subjectid);
		User user = (User)dao.getSession().get(User.class, id);
		Set set1 = user.getSubjects();
		set1.remove(subject);
		user.setSubjects(set1);
		Set set2 = subject.getUsers();
		set2.remove(user);
		subject.setUsers(set2);
		dao.getSession().update(user);
		dao.getSession().update(subject);
		tc.commit();
	}
	
	public List<User> findTeacher(Integer Id) {
		Subject subject = this.dao.findById(Id);
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		String hql = "select user from User as user join user.subjects as subject where subject = ?";
		Query query = dao.getSession().createQuery(hql);
		query.setParameter(0, subject);
		tc.commit();
		List<User> list = query.list();
		return list;
	}
}

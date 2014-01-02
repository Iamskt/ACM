package org.njust.Handle;

import org.njust.bean.*;
import org.njust.dao.*;
import org.njust.db.HibernateSessionFactory;
import java.util.*;
import org.hibernate.*;

import com.sun.jmx.trace.Trace;

public class TeacherHandle {
	TeacherDAO dao = null;
	
	public TeacherHandle() {
		dao = new TeacherDAO();
	}
	
	public void AddTeacher(User user) {
		Teacher teacher = new Teacher();
		teacher.setUserName("");
		teacher.setUser(user);
		teacher.setId(user.getId());
		teacher.setCollegeId(1);
		teacher.setDepartment("");	
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		dao.getSession().save(teacher);
		tc.commit();
	}
	
	public Teacher findTeacherById(Integer id) {
		Teacher teacher = this.dao.findById(id);
		return teacher;
	}
	
	public List<Teacher> findTeacherByCollege(Integer collegeID) {
		List<Teacher> list = this.dao.findByCollegeId(collegeID);
		return list;
	}
	
	public List<Teacher> findAllTeacher() {
		List<Teacher> list = this.dao.findAll();
		return list;
	}
	
	public boolean isTeacher(Integer ID) {
		Teacher teacher = this.findTeacherById(ID);
		if (teacher == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public void UpdateTeacher(Integer id, String username, Integer collegeID, String department) {
		Transaction tc = dao.getSession().getTransaction();
		Teacher teacher = (Teacher)dao.getSession().get(Teacher.class, id);
		teacher.setCollegeId(collegeID);
		teacher.setDepartment(department);
		teacher.setUserName(username);
		tc.begin();
		dao.getSession().update(teacher);
		tc.commit();
	}
	
}

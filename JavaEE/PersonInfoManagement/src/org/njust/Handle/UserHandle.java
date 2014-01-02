package org.njust.Handle;

import net.sf.json.JSONArray;

import org.njust.bean.*;
import org.njust.db.HibernateSessionFactory;
import org.hibernate.*;
import org.njust.dao.*;
import java.util.*;

public class UserHandle {
	UserDAO dao = null;
	
	public static int SYSTEMUSER = 1;
	public static int ADMINUSER = 2;
	public static int TEACHER = 3;
	public static int OTHERUSER = 4;
	public static int ILLEGALUSER = 5;	
	public static int WRONG_PASSWORD = 11;
	public static int RIGHT_PASSWORD = 13;
	
	public UserHandle() {
		dao = new UserDAO();
	}
	
	public void AddUser(String Username, String Password) {
		User user = new User();
		user.setUsername(Username);
		user.setPassword(Password);	
		List <User> list = dao.findByUsername(Username);
		if (list.size() > 0) {
			return ;
		}
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		dao.save(user);
		tc.commit();
	}
		
	public User findUserByID(Integer id) {
		User user = dao.findById(id);
		return user;
	}
	
	public List<User> findall() {
		List<User> list = dao.findAll(); 
		return list;
	}
	
	public Integer findUserID(String Username) {
		Integer id = 0;
		List <User> list = dao.findByUsername(Username);
		if (list.size() > 0) {
			id = list.get(0).getId();
		}
		return id;
	}
	
	public void DeleteUser(Integer id) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		User user = (User)dao.getSession().get(User.class, id);
		dao.getSession().delete(user);
		tc.commit();
	}
	
	public void UpdatePasswordById(Integer id, String Password) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		User user = (User)dao.getSession().get(User.class, id);
		user.setPassword(Password);
		dao.getSession().update(user);
		tc.commit();
	}
	
	public int PasswordIsRight(Integer id, String Password) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		User user = (User)dao.getSession().get(User.class, id);
		tc.commit();
		if ((Password.length() > 20) || (Password.compareTo(user.getPassword()) != 0)) {
			return UserHandle.WRONG_PASSWORD;
		} else {
			return UserHandle.RIGHT_PASSWORD;
		}
	}
	
	public List<Subject> findSubject(Integer id) {
		User user = this.dao.findById(id);
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		String hql = "select subject from Subject as subject join subject.users as user where user = ?";
		Query query = dao.getSession().createQuery(hql);
		query.setParameter(0, user);
		tc.commit();
		List<Subject> list = query.list();
		return list;
	}
	
	public int CheckUserType(Integer id) {
		if (new AdminUserHandle().IsAdminuser(id)) {
			return UserHandle.ADMINUSER;
		}
		if (new TeacherHandle().isTeacher(id)) {
			return UserHandle.TEACHER;
		}
		return UserHandle.ILLEGALUSER;
	}
	
}
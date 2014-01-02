package org.njust.Handle;

import org.njust.bean.*;
import org.njust.db.HibernateSessionFactory;
import org.njust.dao.*;
import org.hibernate.*;
import java.util.*;

public class AdminUserHandle {
	AdminuserDAO dao = null;
	
	public AdminUserHandle() {
		this.dao = new AdminuserDAO();
	}
	
	public void AddAdminUser(User user, String Username, Integer CollegeID) {
		Adminuser adminuser = new Adminuser();
		adminuser.setUser(user);
		adminuser.setCollegeId(CollegeID);
		adminuser.setUsername(Username); 
		adminuser.setId(user.getId());
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		dao.save(adminuser);
		tc.commit();
	}
	
	public boolean IsAdminuser(Integer id) {
		Adminuser user = dao.findById(id);
		if (user != null) {
			return true;
		} else {
			return false;
		}	
	}
	
	public List<Adminuser> GetAlladminuser() {
		List<Adminuser> list = dao.findAll();
		return list;
	}
	
	public Adminuser findAdminuserByID(Integer id) {
		Adminuser user = dao.findById(id);
		return user;
	}
	
	public List<Adminuser> getAdminuserByUserName(String Username) {
		List<Adminuser> list =  dao.findByUsername(Username);
		return list;
	}
	
	public List<Adminuser> getAdminuserByCollegeID(Integer CollegeID) {
		List<Adminuser> list = dao.findByCollegeId(CollegeID);
		return list;
	}
	
	public void UpdateAdminuser(Integer ID, String username, Integer CollegeId) {
		Transaction tc = dao.getSession().getTransaction();
		tc.begin();
		Adminuser user = (Adminuser)dao.getSession().load(Adminuser.class, ID);
		user.setCollegeId(CollegeId);
		user.setUsername(username);
		dao.getSession().update(user);
		tc.commit();
	}
	
	public static void main(String[] args) {
		UserHandle handle1 = new UserHandle();
		AdminUserHandle handle = new AdminUserHandle();
		
		handle.AddAdminUser(handle1.findUserByID(1), "Ðì½¨", 1);
	}
}

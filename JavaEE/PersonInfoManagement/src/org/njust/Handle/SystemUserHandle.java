package org.njust.Handle;

import org.njust.bean.*;
import org.njust.dao.SystemuserDAO;
import org.njust.db.HibernateSessionFactory;
import java.util.*;
import org.hibernate.*;

public class SystemUserHandle {
	SystemuserDAO dao = null;
	
	public SystemUserHandle() {
		dao = new SystemuserDAO();
	}
	
	public void AddSystemUser(User user) {
		Systemuser systemuser = new Systemuser();
		systemuser.setUser(user);
		systemuser.setId(user.getId());
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		if (!this.IsSystemUser(user.getId())) {
			session.save(systemuser);
		}
		session.getTransaction().commit();
		session.close();
	}
	
	public Systemuser SelectSystemUser(Integer id) {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		Systemuser systemuser = this.dao.findById(id);
		session.getTransaction().commit();
		session.close();
		return systemuser;
	}
	
	public boolean IsSystemUser(Integer id) {
		Systemuser systemuser = this.SelectSystemUser(id);
		if (systemuser == null) {
			return false;
		} else {
			return true;
		}
	}
	
}

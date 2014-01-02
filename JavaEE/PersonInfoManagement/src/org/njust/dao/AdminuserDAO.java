package org.njust.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.njust.bean.*;
/**
 * A data access object (DAO) providing persistence and search support for
 * Adminuser entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.njust.bean.Adminuser
 * @author MyEclipse Persistence Tools
 */

public class AdminuserDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AdminuserDAO.class);
	// property constants
	public static final String USERNAME = "username";
	public static final String COLLEGE_ID = "collegeId";

	public void save(Adminuser transientInstance) {
		log.debug("saving Adminuser instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Adminuser persistentInstance) {
		log.debug("deleting Adminuser instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Adminuser findById(java.lang.Integer id) {
		log.debug("getting Adminuser instance with id: " + id);
		try {
			Adminuser instance = (Adminuser) getSession().get(
					"org.njust.bean.Adminuser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Adminuser instance) {
		log.debug("finding Adminuser instance by example");
		try {
			List results = getSession()
					.createCriteria("org.njust.bean.Adminuser")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Adminuser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Adminuser as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findByCollegeId(Object collegeId) {
		return findByProperty(COLLEGE_ID, collegeId);
	}

	public List findAll() {
		log.debug("finding all Adminuser instances");
		try {
			String queryString = "from Adminuser";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Adminuser merge(Adminuser detachedInstance) {
		log.debug("merging Adminuser instance");
		try {
			Adminuser result = (Adminuser) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Adminuser instance) {
		log.debug("attaching dirty Adminuser instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Adminuser instance) {
		log.debug("attaching clean Adminuser instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
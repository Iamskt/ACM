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
 * Systemuser entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.njust.bean.Systemuser
 * @author MyEclipse Persistence Tools
 */

public class SystemuserDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SystemuserDAO.class);

	// property constants

	public void save(Systemuser transientInstance) {
		log.debug("saving Systemuser instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Systemuser persistentInstance) {
		log.debug("deleting Systemuser instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Systemuser findById(java.lang.Integer id) {
		log.debug("getting Systemuser instance with id: " + id);
		try {
			Systemuser instance = (Systemuser) getSession().get(
					"org.njust.bean.Systemuser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Systemuser instance) {
		log.debug("finding Systemuser instance by example");
		try {
			List results = getSession()
					.createCriteria("org.njust.bean.Systemuser")
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
		log.debug("finding Systemuser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Systemuser as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Systemuser instances");
		try {
			String queryString = "from Systemuser";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Systemuser merge(Systemuser detachedInstance) {
		log.debug("merging Systemuser instance");
		try {
			Systemuser result = (Systemuser) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Systemuser instance) {
		log.debug("attaching dirty Systemuser instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Systemuser instance) {
		log.debug("attaching clean Systemuser instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
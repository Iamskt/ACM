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
 * Declareauthor entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.njust.bean.Declareauthor
 * @author MyEclipse Persistence Tools
 */

public class DeclareauthorDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DeclareauthorDAO.class);
	// property constants
	public static final String AUTHORNAME = "authorname";
	public static final String DEPARTMENT = "department";
	public static final String LEVEL = "level";

	public void save(Declareauthor transientInstance) {
		log.debug("saving Declareauthor instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Declareauthor persistentInstance) {
		log.debug("deleting Declareauthor instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Declareauthor findById(java.lang.Integer id) {
		log.debug("getting Declareauthor instance with id: " + id);
		try {
			Declareauthor instance = (Declareauthor) getSession().get(
					"org.njust.bean.Declareauthor", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Declareauthor instance) {
		log.debug("finding Declareauthor instance by example");
		try {
			List results = getSession()
					.createCriteria("org.njust.bean.Declareauthor")
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
		log.debug("finding Declareauthor instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Declareauthor as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAuthorname(Object authorname) {
		return findByProperty(AUTHORNAME, authorname);
	}

	public List findByDepartment(Object department) {
		return findByProperty(DEPARTMENT, department);
	}

	public List findByLevel(Object level) {
		return findByProperty(LEVEL, level);
	}

	public List findAll() {
		log.debug("finding all Declareauthor instances");
		try {
			String queryString = "from Declareauthor";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Declareauthor merge(Declareauthor detachedInstance) {
		log.debug("merging Declareauthor instance");
		try {
			Declareauthor result = (Declareauthor) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Declareauthor instance) {
		log.debug("attaching dirty Declareauthor instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Declareauthor instance) {
		log.debug("attaching clean Declareauthor instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
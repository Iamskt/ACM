package org.njust.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.njust.bean.*;

/**
 * A data access object (DAO) providing persistence and search support for Honor
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see org.njust.bean.Honor
 * @author MyEclipse Persistence Tools
 */

public class HonorDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(HonorDAO.class);
	// property constants
	public static final String HONOR_NAME = "honorName";
	public static final String ACHIEVE_TIME = "achieveTime";
	public static final String BATCH = "batch";
	public static final String LEVEL = "level";

	public void save(Honor transientInstance) {
		log.debug("saving Honor instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Honor persistentInstance) {
		log.debug("deleting Honor instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Honor findById(java.lang.Integer id) {
		log.debug("getting Honor instance with id: " + id);
		try {
			Honor instance = (Honor) getSession()
					.get("org.njust.bean.Honor", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Honor instance) {
		log.debug("finding Honor instance by example");
		try {
			List results = getSession().createCriteria("org.njust.bean.Honor")
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
		log.debug("finding Honor instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Honor as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByHonorName(Object honorName) {
		return findByProperty(HONOR_NAME, honorName);
	}

	public List findByAchieveTime(Object achieveTime) {
		return findByProperty(ACHIEVE_TIME, achieveTime);
	}

	public List findByBatch(Object batch) {
		return findByProperty(BATCH, batch);
	}

	public List findByLevel(Object level) {
		return findByProperty(LEVEL, level);
	}

	public List findAll() {
		log.debug("finding all Honor instances");
		try {
			String queryString = "from Honor";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Honor merge(Honor detachedInstance) {
		log.debug("merging Honor instance");
		try {
			Honor result = (Honor) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Honor instance) {
		log.debug("attaching dirty Honor instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Honor instance) {
		log.debug("attaching clean Honor instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
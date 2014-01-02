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
 * Workexperience entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.njust.bean.Workexperience
 * @author MyEclipse Persistence Tools
 */

public class WorkexperienceDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(WorkexperienceDAO.class);
	// property constants
	public static final String START_TIME = "startTime";
	public static final String END_TIME = "endTime";
	public static final String DEPARTMENT = "department";
	public static final String WORK_SITUATION = "workSituation";

	public void save(Workexperience transientInstance) {
		log.debug("saving Workexperience instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Workexperience persistentInstance) {
		log.debug("deleting Workexperience instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Workexperience findById(java.lang.Integer id) {
		log.debug("getting Workexperience instance with id: " + id);
		try {
			Workexperience instance = (Workexperience) getSession().get(
					"org.njust.bean.Workexperience", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Workexperience instance) {
		log.debug("finding Workexperience instance by example");
		try {
			List results = getSession()
					.createCriteria("org.njust.bean.Workexperience")
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
		log.debug("finding Workexperience instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Workexperience as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStartTime(Object startTime) {
		return findByProperty(START_TIME, startTime);
	}

	public List findByEndTime(Object endTime) {
		return findByProperty(END_TIME, endTime);
	}

	public List findByDepartment(Object department) {
		return findByProperty(DEPARTMENT, department);
	}

	public List findByWorkSituation(Object workSituation) {
		return findByProperty(WORK_SITUATION, workSituation);
	}

	public List findAll() {
		log.debug("finding all Workexperience instances");
		try {
			String queryString = "from Workexperience";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Workexperience merge(Workexperience detachedInstance) {
		log.debug("merging Workexperience instance");
		try {
			Workexperience result = (Workexperience) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Workexperience instance) {
		log.debug("attaching dirty Workexperience instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Workexperience instance) {
		log.debug("attaching clean Workexperience instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
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
 * Degree entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see org.njust.bean.Degree
 * @author MyEclipse Persistence Tools
 */

public class DegreeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(DegreeDAO.class);
	// property constants
	public static final String DEGREENAME = "degreename";
	public static final String GRADUATION_SCHOOL = "graduationSchool";
	public static final String SPECIALTY = "specialty";
	public static final String START_TIME = "startTime";
	public static final String END_TIME = "endTime";
	public static final String SCHOOL_LEVEL = "schoolLevel";
	public static final String HIGHEST_DEGREE = "highestDegree";

	public void save(Degree transientInstance) {
		log.debug("saving Degree instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Degree persistentInstance) {
		log.debug("deleting Degree instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Degree findById(java.lang.Integer id) {
		log.debug("getting Degree instance with id: " + id);
		try {
			Degree instance = (Degree) getSession().get("org.njust.bean.Degree",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Degree instance) {
		log.debug("finding Degree instance by example");
		try {
			List results = getSession().createCriteria("org.njust.bean.Degree")
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
		log.debug("finding Degree instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Degree as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDegreename(Object degreename) {
		return findByProperty(DEGREENAME, degreename);
	}

	public List findByGraduationSchool(Object graduationSchool) {
		return findByProperty(GRADUATION_SCHOOL, graduationSchool);
	}

	public List findBySpecialty(Object specialty) {
		return findByProperty(SPECIALTY, specialty);
	}

	public List findByStartTime(Object startTime) {
		return findByProperty(START_TIME, startTime);
	}

	public List findByEndTime(Object endTime) {
		return findByProperty(END_TIME, endTime);
	}

	public List findBySchoolLevel(Object schoolLevel) {
		return findByProperty(SCHOOL_LEVEL, schoolLevel);
	}

	public List findByHighestDegree(Object highestDegree) {
		return findByProperty(HIGHEST_DEGREE, highestDegree);
	}

	public List findAll() {
		log.debug("finding all Degree instances");
		try {
			String queryString = "from Degree";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Degree merge(Degree detachedInstance) {
		log.debug("merging Degree instance");
		try {
			Degree result = (Degree) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Degree instance) {
		log.debug("attaching dirty Degree instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Degree instance) {
		log.debug("attaching clean Degree instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
package org.njust.dao;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.njust.bean.*;

/**
 * A data access object (DAO) providing persistence and search support for
 * Declaretion entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.njust.bean.Declaretion
 * @author MyEclipse Persistence Tools
 */

public class DeclaretionDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DeclaretionDAO.class);
	// property constants
	public static final String PAPER_ID = "paperId";
	public static final String DEPARTMENT = "department";
	public static final String TELEPHONE = "telephone";
	public static final String PUT_TIME = "putTime";
	public static final String CNAME = "cname";
	public static final String ENAME = "ename";
	public static final String CJNAME = "cjname";
	public static final String EJNAME = "ejname";
	public static final String JLEVEL = "jlevel";
	public static final String CCNAME = "ccname";
	public static final String ECNAME = "ecname";
	public static final String CLEVEL = "clevel";
	public static final String VOLUME = "volume";
	public static final String PERIOD = "period";
	public static final String ST_PAGE = "stPage";
	public static final String ED_PAGE = "edPage";

	public void save(Declaretion transientInstance) {
		log.debug("saving Declaretion instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Declaretion persistentInstance) {
		log.debug("deleting Declaretion instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Declaretion findById(java.lang.Integer id) {
		log.debug("getting Declaretion instance with id: " + id);
		try {
			Declaretion instance = (Declaretion) getSession().get(
					"org.njust.bean.Declaretion", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Declaretion instance) {
		log.debug("finding Declaretion instance by example");
		try {
			List results = getSession()
					.createCriteria("org.njust.bean.Declaretion")
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
		log.debug("finding Declaretion instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Declaretion as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPaperId(Object paperId) {
		return findByProperty(PAPER_ID, paperId);
	}

	public List findByDepartment(Object department) {
		return findByProperty(DEPARTMENT, department);
	}

	public List findByTelephone(Object telephone) {
		return findByProperty(TELEPHONE, telephone);
	}

	public List findByPutTime(Object putTime) {
		return findByProperty(PUT_TIME, putTime);
	}

	public List findByCname(Object cname) {
		return findByProperty(CNAME, cname);
	}

	public List findByEname(Object ename) {
		return findByProperty(ENAME, ename);
	}

	public List findByCjname(Object cjname) {
		return findByProperty(CJNAME, cjname);
	}

	public List findByEjname(Object ejname) {
		return findByProperty(EJNAME, ejname);
	}

	public List findByJlevel(Object jlevel) {
		return findByProperty(JLEVEL, jlevel);
	}

	public List findByCcname(Object ccname) {
		return findByProperty(CCNAME, ccname);
	}

	public List findByEcname(Object ecname) {
		return findByProperty(ECNAME, ecname);
	}

	public List findByClevel(Object clevel) {
		return findByProperty(CLEVEL, clevel);
	}

	public List findByVolume(Object volume) {
		return findByProperty(VOLUME, volume);
	}

	public List findByPeriod(Object period) {
		return findByProperty(PERIOD, period);
	}

	public List findByStPage(Object stPage) {
		return findByProperty(ST_PAGE, stPage);
	}

	public List findByEdPage(Object edPage) {
		return findByProperty(ED_PAGE, edPage);
	}

	public List findAll() {
		log.debug("finding all Declaretion instances");
		try {
			String queryString = "from Declaretion";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Declaretion merge(Declaretion detachedInstance) {
		log.debug("merging Declaretion instance");
		try {
			Declaretion result = (Declaretion) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Declaretion instance) {
		log.debug("attaching dirty Declaretion instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Declaretion instance) {
		log.debug("attaching clean Declaretion instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
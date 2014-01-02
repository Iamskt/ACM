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
 * Teacherinfomation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see org.njust.bean.Teacherinfomation
 * @author MyEclipse Persistence Tools
 */

public class TeacherinfomationDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TeacherinfomationDAO.class);
	// property constants
	public static final String BIRTHDAY = "birthday";
	public static final String POLITICAL = "political";
	public static final String HOMETOWN = "hometown";
	public static final String ETHNIC = "ethnic";
	public static final String IDENTITY_ID = "identityId";
	public static final String ADMINISTRATIVE_DUTY = "administrativeDuty";
	public static final String TITLE = "title";
	public static final String OFFICE_ADDRESS = "officeAddress";
	public static final String OFFICE_PHONE = "officePhone";
	public static final String MAIL1 = "mail1";
	public static final String MAIL2 = "mail2";
	public static final String MAIL3 = "mail3";
	public static final String TELE_PHONE = "telePhone";
	public static final String COMMUNICATION_ADDRESS = "communicationAddress";
	public static final String RESEARCH_DIRECTION = "researchDirection";

	public void save(Teacherinfomation transientInstance) {
		log.debug("saving Teacherinfomation instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Teacherinfomation persistentInstance) {
		log.debug("deleting Teacherinfomation instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Teacherinfomation findById(java.lang.Integer id) {
		log.debug("getting Teacherinfomation instance with id: " + id);
		try {
			Teacherinfomation instance = (Teacherinfomation) getSession().get(
					"org.njust.bean.Teacherinfomation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Teacherinfomation instance) {
		log.debug("finding Teacherinfomation instance by example");
		try {
			List results = getSession()
					.createCriteria("org.njust.bean.Teacherinfomation")
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
		log.debug("finding Teacherinfomation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Teacherinfomation as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBirthday(Object birthday) {
		return findByProperty(BIRTHDAY, birthday);
	}

	public List findByPolitical(Object political) {
		return findByProperty(POLITICAL, political);
	}

	public List findByHometown(Object hometown) {
		return findByProperty(HOMETOWN, hometown);
	}

	public List findByEthnic(Object ethnic) {
		return findByProperty(ETHNIC, ethnic);
	}

	public List findByIdentityId(Object identityId) {
		return findByProperty(IDENTITY_ID, identityId);
	}

	public List findByAdministrativeDuty(Object administrativeDuty) {
		return findByProperty(ADMINISTRATIVE_DUTY, administrativeDuty);
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByOfficeAddress(Object officeAddress) {
		return findByProperty(OFFICE_ADDRESS, officeAddress);
	}

	public List findByOfficePhone(Object officePhone) {
		return findByProperty(OFFICE_PHONE, officePhone);
	}

	public List findByMail1(Object mail1) {
		return findByProperty(MAIL1, mail1);
	}

	public List findByMail2(Object mail2) {
		return findByProperty(MAIL2, mail2);
	}

	public List findByMail3(Object mail3) {
		return findByProperty(MAIL3, mail3);
	}

	public List findByTelePhone(Object telePhone) {
		return findByProperty(TELE_PHONE, telePhone);
	}

	public List findByCommunicationAddress(Object communicationAddress) {
		return findByProperty(COMMUNICATION_ADDRESS, communicationAddress);
	}

	public List findByResearchDirection(Object researchDirection) {
		return findByProperty(RESEARCH_DIRECTION, researchDirection);
	}

	public List findAll() {
		log.debug("finding all Teacherinfomation instances");
		try {
			String queryString = "from Teacherinfomation";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Teacherinfomation merge(Teacherinfomation detachedInstance) {
		log.debug("merging Teacherinfomation instance");
		try {
			Teacherinfomation result = (Teacherinfomation) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Teacherinfomation instance) {
		log.debug("attaching dirty Teacherinfomation instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Teacherinfomation instance) {
		log.debug("attaching clean Teacherinfomation instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}
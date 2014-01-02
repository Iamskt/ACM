package org.njust.Action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.*;

import net.sf.json.JSONArray;

import org.njust.bean.*;
import org.njust.Handle.*;

public class Userinfo extends ActionSupport {
	private String pid;
	private String jsonData;
	private Teacherinfomation teacherinfomation;
	private String Department;
	private String CollegeID;
	private List<Degree> degrees;
	private List<Honor> honors;
	private List<Partjob> partjobs;
	private List<Workexperience> workexperiences;
	private List<Subject> subjects;
	private User user;
	private Teacher teacher;
	
	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(pid);
		Map<String, Object> map = new HashMap<String, Object>();
		TeacherHandle handle = new TeacherHandle();
		this.user = new UserHandle().findUserByID(id).Clone();
		this.teacher = handle.findTeacherById(id).Clone();
		this.Department = teacher.getDepartment();
		this.CollegeID = new CollegeHandle().getCollegeByCollegeID(teacher.getCollegeId()).getCollegeName();
		Teacherinfomation tmpTeacherinfomation = new TeacherInfomationHandle().findTeacherinfomationById(id);
		if (tmpTeacherinfomation == null) {
			new TeacherInfomationHandle().AddTeacherInfomation(user);
			tmpTeacherinfomation = new TeacherInfomationHandle().findTeacherinfomationById(id);
		}
		this.teacherinfomation = tmpTeacherinfomation.Clone();
		this.degrees = new ArrayList<Degree>();
		List<Degree> l1 = new DegreeHandle().findAllDegreeById(id);
		for (int i = 0; i < l1.size(); i ++) {
			Degree degree = l1.get(i).Clone();
			this.degrees.add(degree);
		}
		List<Honor> l2 = new HonorHandle().findAllHonorById(id);
		this.honors = new ArrayList<Honor>();
		for (int i = 0; i < l2.size(); i++) {
			Honor honor = l2.get(i).Clone();
			this.honors.add(honor);
		}
		
		List<Partjob> l3 = new PartJobHandle().findAllPartJob(id);
		this.partjobs = new ArrayList<Partjob>();
		for (int i = 0; i < l3.size(); i++) {
			Partjob partjob = l3.get(i).Clone();
			this.partjobs.add(partjob);
		}

		List<Workexperience> l4 = new WorkExperienceHandle().findAllWorkexperience(id);
		this.workexperiences = new ArrayList<Workexperience>();
		for (int i = 0; i < l4.size(); i++) {
			Workexperience workexperience = l4.get(i).Clone();
			this.workexperiences.add(workexperience);
		}
		
		List<Subject> l5 = new UserHandle().findSubject(id);
		this.subjects = new ArrayList<Subject>();
		for (int i = 0; i < l5.size(); i++) {
			Subject subject = l5.get(i).Clone();
			this.subjects.add(subject);
		}
		map.put("user", user);
		map.put("teacher", teacher);
		map.put("Teacherinfomation", teacherinfomation);
		map.put("degree", degrees);
		map.put("honor", honors);
		map.put("partjob", partjobs);
		map.put("subject", subjects);
		map.put("workexperience", workexperiences);
		map.put("college", CollegeID);
		map.put("department", Department);
		JSONArray json = JSONArray.fromObject(map);
		jsonData = json.toString();
		return SUCCESS;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	public Teacherinfomation getTeacherinfomation() {
		return teacherinfomation;
	}

	public void setTeacherinfomation(Teacherinfomation teacherinfomation) {
		this.teacherinfomation = teacherinfomation;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getCollegeID() {
		return CollegeID;
	}

	public void setCollegeID(String collegeID) {
		CollegeID = collegeID;
	}

	public List<Degree> getDegrees() {
		return degrees;
	}

	public void setDegrees(List<Degree> degrees) {
		this.degrees = degrees;
	}

	public List<Honor> getHonors() {
		return honors;
	}

	public void setHonors(List<Honor> honors) {
		this.honors = honors;
	}

	public List<Partjob> getPartjobs() {
		return partjobs;
	}

	public void setPartjobs(List<Partjob> partjobs) {
		this.partjobs = partjobs;
	}

	public List<Workexperience> getWorkexperiences() {
		return workexperiences;
	}

	public void setWorkexperiences(List<Workexperience> workexperiences) {
		this.workexperiences = workexperiences;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
}
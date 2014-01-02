package org.njust.Action;

import java.util.*;

import org.njust.bean.*;
import org.njust.Handle.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class personAction extends ActionSupport {
	private String jsonData;

	private Teacherinfomation teacherinfomation;

	private String Department;

	private String CollegeID;

	private List<Degree> degrees;

	private List<Honor> honors;

	private List<Partjob> partjobs;

	private List<Workexperience> workexperiences;

	private List<Subject> subjects;

	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Object StatusObject = session.getAttribute("status");
		Object UserObject = session.getAttribute("user");
		Object UserIdObject = session.getAttribute("name");
		Object RootObject = session.getAttribute("root");
		boolean flag = false;
		String user = "";
		String name = "";
		int Auth = 0;
		if (StatusObject != null) {
			String tmp = StatusObject.toString();
			if (tmp == "true") {
				flag = true;
			}
		}
		if (UserObject != null) {
			user = (String) UserObject.toString();
			name = (String) UserIdObject;
		}
		if (RootObject != null) {
			String tmp = RootObject.toString();
			Auth = Integer.parseInt(tmp);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		Integer id = new UserHandle().findUserID(user);
		if (flag) {
			Adminuser auser = new AdminUserHandle().findAdminuserByID(id);
			if (auser != null) {
				College college = new CollegeHandle().getCollegeByCollegeID(auser.getCollegeId());
				this.CollegeID = new CollegeHandle().getCollegeByCollegeID(auser.getCollegeId()).getCollegeName();
			} else {
				Teacher teacher = new TeacherHandle().findTeacherById(id);
				this.Department = teacher.getDepartment();
				this.CollegeID = new CollegeHandle().getCollegeByCollegeID(teacher.getCollegeId()).getCollegeName();
			}

			Teacherinfomation tmp = new TeacherInfomationHandle().findTeacherinfomationById(id);
			if (tmp != null) {
				this.teacherinfomation = tmp.Clone();
			} else {
				new TeacherInfomationHandle().AddTeacherInfomation(new UserHandle().findUserByID(id));
			}

			List<Degree> l1 = new DegreeHandle().findAllDegreeById(id);
			this.degrees = new ArrayList<Degree>();
			for (int i = 0; i < l1.size(); i++) {
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
		}
		map.put("status", flag);
		map.put("user", user);
		map.put("name", name);
		map.put("root", Auth);
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

	@JSON
	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	@JSON
	public Teacherinfomation getTeacherinfomation() {
		return teacherinfomation;
	}

	public void setTeacherinfomation(Teacherinfomation teacherinfomation) {
		this.teacherinfomation = teacherinfomation;
	}

	@JSON
	public List<Degree> getDegrees() {
		return degrees;
	}

	public void setDegrees(List<Degree> degrees) {
		this.degrees = degrees;
	}

	@JSON
	public List<Honor> getHonors() {
		return honors;
	}

	public void setHonors(List<Honor> honors) {
		this.honors = honors;
	}

	@JSON
	public List<Partjob> getPartjobs() {
		return partjobs;
	}

	public void setPartjobs(List<Partjob> partjobs) {
		this.partjobs = partjobs;
	}

	@JSON
	public List<Workexperience> getWorkexperiences() {
		return workexperiences;
	}

	public void setWorkexperiences(List<Workexperience> workexperiences) {
		this.workexperiences = workexperiences;
	}

	@JSON
	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
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

}
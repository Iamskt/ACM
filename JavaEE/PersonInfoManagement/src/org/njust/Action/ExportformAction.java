package org.njust.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.njust.Handle.DeclareauthorHandle;
import org.njust.Handle.DeclaretionHandle;
import org.njust.bean.Declareauthor;
import org.njust.bean.Declaretion;
import org.njust.office.ImportExcel;
import org.njust.office.ImportWord;
import org.njust.office.MSWordManager;

import com.opensymphony.xwork2.ActionSupport;

public class ExportformAction extends ActionSupport {
	private String pid;
	private String jsonData;
	private Declaretion declaretion;
	private List<Declareauthor> declareauthors;
	private ImportWord word;
	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(pid);
		this.declareauthors = new DeclareauthorHandle().GetDeclareauthorsByPaperID(id);
		this.declaretion = new DeclaretionHandle().GetDeclaretionByID(id);
		ImportExcel excel = new ImportExcel();
		String path = excel.wordtoForm(declaretion, declareauthors);
		String[] paths = path.split("PersonInfoManagement");
		path = paths[1];
		path = path.substring(1);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("path", path);
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
	public Declaretion getDeclaretion() {
		return declaretion;
	}
	public void setDeclaretion(Declaretion declaretion) {
		this.declaretion = declaretion;
	}
	public List<Declareauthor> getDeclareauthors() {
		return declareauthors;
	}
	public void setDeclareauthors(List<Declareauthor> declareauthors) {
		this.declareauthors = declareauthors;
	}
}
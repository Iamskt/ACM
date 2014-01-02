package org.njust.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.njust.bean.*;
import org.njust.Handle.*;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.njust.office.*;
import com.opensymphony.xwork2.ActionSupport;

public class ExportUserAction extends ActionSupport {
	private File fileupload;
	private String jsonData;
	private String fileuploadFileName;
	private String fileuploadContentType;
	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		String path = ServletActionContext.getRequest().getRealPath("/upload");
		File file = this.getFileupload();
		File target = new File(path + "/" + this.getFileuploadFileName());
		try {
			if (!target.exists()) {
				target.createNewFile();
			}
			FileInputStream inputStream = new FileInputStream(file);
			FileOutputStream outputStream = new FileOutputStream(target);
			int n =inputStream.read();
			while (n != -1) {
				outputStream.write(n);
				n = inputStream.read();
			} 
            inputStream.close();  
            outputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImportExcel excel = new ImportExcel();
		HttpServletRequest request = ServletActionContext.getRequest(); 
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("user");
		Integer id = new UserHandle().findUserID(name);
		AdminUserHandle handle = new AdminUserHandle();
		Adminuser user = handle.findAdminuserByID(id);
		excel.ExcelofUser(target, user.getCollegeId());
		return SUCCESS;
	}
	
	public File getFileupload() {
		return fileupload;
	}

	public void setFileupload(File fileupload) {
		this.fileupload = fileupload;
	}

	public String getFileuploadFileName() {
		return fileuploadFileName;
	}

	public void setFileuploadFileName(String fileuploadFileName) {
		this.fileuploadFileName = fileuploadFileName;
	}

	public String getFileuploadContentType() {
		return fileuploadContentType;
	}

	public void setFileuploadContentType(String fileuploadContentType) {
		this.fileuploadContentType = fileuploadContentType;
	}

	public String getJsonData() {
		return jsonData;
	}

	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
}
package org.njust.office;

import java.util.*;
import java.io.*;

import org.apache.commons.lang.math.Range;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.njust.Handle.*;
import org.njust.bean.*;
import org.apache.poi.hwpf.*;

public class ImportExcel {
	public ImportExcel() {
	}
	
	public void ExcelofCollege(File file) {
		try {
			CollegeHandle collegeHandle = new CollegeHandle();
			InputStream input = new FileInputStream(file);
			POIFSFileSystem fs = new POIFSFileSystem(input);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			Iterator rows = sheet.rowIterator();
			int flag = 0;
			while (rows.hasNext()) {							
				HSSFRow row = (HSSFRow)rows.next();
				if (flag == 0) {
					flag = 1;
					continue;
				}	
				Iterator cells = row.cellIterator();
				Integer integer = null;
				String name = null;
				while (cells.hasNext()) {
					HSSFCell cell = (HSSFCell)cells.next();
					if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
						integer = (int)cell.getNumericCellValue();
					} else {
						name = cell.getStringCellValue();
					}
				}
				collegeHandle.AddCollege(integer, name);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ExcelofUser(File file, Integer collegeID) {
		InputStream input;
		try {
			UserHandle userhandle = new UserHandle();
			TeacherHandle teacherhandle = new TeacherHandle();
			input = new FileInputStream(file);
			POIFSFileSystem fs = new POIFSFileSystem(input);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			HSSFSheet sheet = wb.getSheetAt(0);
			Iterator rows = sheet.rowIterator();
			while (rows.hasNext()) {
				HSSFRow row = (HSSFRow)rows.next();
				Iterator cells = row.cellIterator();
				List<String> users = new ArrayList<String>();
				while (cells.hasNext()) {
					HSSFCell cell = (HSSFCell)cells.next();
					users.add(cell.getStringCellValue());
				}
				userhandle.AddUser(users.get(1), "111111");
				Integer id = userhandle.findUserID(users.get(1));
				User user = userhandle.findUserByID(id);
				teacherhandle.AddTeacher(user);
				teacherhandle.UpdateTeacher(id, users.get(0), collegeID, users.get(2));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String wordtoForm(Declaretion declaretion, List<Declareauthor> declareauthors){
		File file = new File("test");
		String path = file.getAbsolutePath();
		String name = declaretion.getId().toString();
		name = name + ".doc";
		path = path.substring(0, path.length()-8);
		path = "G:\\Workspaces\\MyEclipse 10\\PersonInfoManagement\\WebRoot\\";
		File src = new File(path + "doc\\学术论文.doc");
		File goal = new File("G:\\学习工具\\apache-tomcat-7.0.39\\webapps\\PersonInfoManagement\\" + name);
		try {
			if (!goal.exists()) {
				goal.createNewFile();
			}
			FileInputStream inputStream = new FileInputStream(src);
			FileOutputStream outputStream = new FileOutputStream(goal);
			int n = inputStream.read();
			while (n != -1) {
				outputStream.write(n);
				n = inputStream.read();
			}
			inputStream.close();
			outputStream.close();
			
			User user = declaretion.getUser();
			UserHandle handle = new UserHandle();
			String username = "";
			if (handle.CheckUserType(user.getId()) == UserHandle.ADMINUSER) {
				username = new AdminUserHandle().findAdminuserByID(user.getId()).getUsername();
			} else {
				username = new TeacherHandle().findTeacherById(user.getId()).getUserName();
			}
			FileInputStream fis = new FileInputStream(src);
			FileOutputStream fos = new FileOutputStream(goal);
			HWPFDocument document = new HWPFDocument(fis);
			org.apache.poi.hwpf.usermodel.Range range = document.getRange();
			range.replaceText("${PaperId}", declaretion.getPaperId());
			range.replaceText("${CName}", declaretion.getCname());
			range.replaceText("${EName}", declaretion.getEname());
			range.replaceText("${Name}", username);
			range.replaceText("${department}", declaretion.getDepartment());
			range.replaceText("${telephone}", declaretion.getTelephone());
			range.replaceText("${id}", declaretion.getUser().getUsername());
			range.replaceText("${CCName}", declaretion.getCjname());
			range.replaceText("${CEName}", declaretion.getEjname());
			range.replaceText("${ConCName}", declaretion.getCcname());
			range.replaceText("${ConEName}", declaretion.getEcname());
			range.replaceText("${y}", "20" + declaretion.getPutTime().substring(6, 8));
			range.replaceText("${m}", declaretion.getPutTime().substring(3, 5));
			range.replaceText("${v}", declaretion.getPeriod().toString());
			range.replaceText("{p}", declaretion.getVolume().toString());
			range.replaceText("${S}", declaretion.getStPage());
			range.replaceText("${E}", declaretion.getEdPage());
			if (declaretion.getCjname() == "" && declaretion.getCcname() == "") {
			} else {
				String string = declaretion.getClevel();
				Integer clevel = Integer.parseInt(string);
				if (clevel == 0) {
					range.replaceText("${g2}", "√");
					range.replaceText("${g1}", " ");
				} else {
					range.replaceText("${g2}", " ");
					range.replaceText("${g1}", "√");
				}
			}
			if (declaretion.getCjname() == "" && declaretion.getEjname() == "") {
			} else {
				String string = declaretion.getJlevel();
				Integer jlevel = Integer.parseInt(string);
				if (jlevel == 0) {
					range.replaceText("${g4}", "√");
					range.replaceText("${g3}", " ");
				} else {
					range.replaceText("${g3}", "√");
					range.replaceText("${g4}", " ");
				}
			}
			
			if (declareauthors.get(0) != null) {
				range.replaceText("${f1}", declareauthors.get(0).getAuthorname());
				range.replaceText("${d1}", declareauthors.get(0).getDepartment());
				String string = declareauthors.get(0).getLevel();
				Integer level = Integer.parseInt(string);
				if (level == 0) {
					range.replaceText("${t11}", "√");
					range.replaceText("${t12}", " ");
				} else {
					range.replaceText("${t11}", " ");
					range.replaceText("${t12}", "√");
				}
			}
			if (declareauthors.size() >= 2 && declareauthors.get(1) != null) {
				range.replaceText("${f2}", declareauthors.get(1).getAuthorname());
				range.replaceText("${d2}", declareauthors.get(1).getDepartment());
				String string = declareauthors.get(1).getLevel();
				Integer level = Integer.parseInt(string);
				if (level == 0) {
					range.replaceText("${t21}", "√");
					range.replaceText("${t22}", " ");
				} else {
					range.replaceText("${t21}", " ");
					range.replaceText("${t22}", "√");
				}
			} else {
				range.replaceText("${f2}", "");
				range.replaceText("${d2}", "");
				range.replaceText("${t21}", " ");
				range.replaceText("${t22}", " ");
			}
			if (declareauthors.size() >= 3 && declareauthors.get(2) != null) {
				range.replaceText("${f3}", declareauthors.get(2).getAuthorname());
				range.replaceText("${d3}", declareauthors.get(2).getDepartment());
				String string = declareauthors.get(2).getLevel();
				Integer level = Integer.parseInt(string);
				if (level == 0) {
					range.replaceText("${t31}", "√");
					range.replaceText("${t32}", " ");
				} else {
					range.replaceText("${t31}", " ");
					range.replaceText("${t32}", "√");
				}
			} else {
				range.replaceText("${f3}", "");
				range.replaceText("${d3}", "");
				range.replaceText("${t31}", " ");
				range.replaceText("${t32}", " ");
			}
			if (declareauthors.size() >= 4 && declareauthors.get(3) != null) {
				range.replaceText("${f4}", declareauthors.get(3).getAuthorname());
				range.replaceText("${d4}", declareauthors.get(3).getDepartment());
				String string = declareauthors.get(3).getLevel();
				Integer level = Integer.parseInt(string);
				if (level == 0) {
					range.replaceText("${t41}", "√");
					range.replaceText("${t42}", " ");
				} else {
					range.replaceText("${t41}", " ");
					range.replaceText("${t42}", "√");
				}
			} else {
				range.replaceText("${f4}", "");
				range.replaceText("${d4}", "");
				range.replaceText("${t41}", " ");
				range.replaceText("${t42}", " ");
			}
			document.write(fos);
			fis.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goal.getAbsolutePath();
	}
	public void wordtoForm(){
		File file = new File("src", "学术论文.doc");
		String path = file.getAbsolutePath();
		String name = "test";
		name = name + ".doc";
		path = path.substring(0, path.length()-8);
		path = path + "";
		File src = new File(path + "学术论文.doc");
		File goal = new File(path + name);
		try {
			if (!goal.exists()) {
				goal.createNewFile();
			}
			FileInputStream inputStream = new FileInputStream(src);
			FileOutputStream outputStream = new FileOutputStream(goal);
			int n = inputStream.read();
			while (n != -1) {
				outputStream.write(n);
				n = inputStream.read();
			}
			inputStream.close();
			outputStream.close();
			HWPFDocument document = new HWPFDocument(new FileInputStream(src));
			org.apache.poi.hwpf.usermodel.Range range = document.getRange();
			range.replaceText("${PaperId}", "asdad");
			range.replaceText("${CName}", "asdada");
			document.write(new FileOutputStream(goal));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public static void main(String[] args) {
		ImportExcel excel = new ImportExcel();
		excel.wordtoForm();
	}

}

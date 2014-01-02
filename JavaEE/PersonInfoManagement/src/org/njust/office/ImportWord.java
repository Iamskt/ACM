package org.njust.office;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import java.io.*;
import org.njust.bean.*;
import java.util.*;

public class ImportWord {
	MSWordManager ms;
	
	String filepath;
	
	public ImportWord() {
	}
	
	public void CreateFile(String filename) {
		GetWordFile getWordFile = new GetWordFile();
		File file = getWordFile.GetFile(filename);
		this.filepath = file.getAbsolutePath();
		this.ms.openDocument(this.filepath);
	}
	
	public void WritePaperID(String paperID) {
		this.ms.moveDown(1);
		this.ms.moveRight(5);
		this.ms.insertText(paperID);
		this.ms.moveDown(1);
	}
	
	public void WriteCName(String CName) {
		this.ms.insertText(CName);
		this.ms.moveDown(1);
	}
	
	public void WriteEName(String EName) {
		this.ms.insertText(EName);
		this.ms.moveDown(1);
		this.ms.moveLeft(4);
	}
	
	public void WriteName(String Name) {
		this.ms.insertText(Name);
		this.ms.moveDown(1);
	}
	
	public void WriteDepartment(String Department) {
		this.ms.insertText(Department);
		this.ms.moveRight(5);
	}
	
	public void WriteTelePhone(String telephone) {
		this.ms.insertText(telephone);
		this.ms.moveDown(1);
	}
	
	public void WriteTeacherID(String teacherID) {
		this.ms.insertText(teacherID);
		this.ms.moveDown(2);
		this.ms.moveLeft(1);
	}
	
	public void writeauthor(List<Declareauthor> list) {
		int length = list.size();
		for (int i = 0; i < length; i ++) {
			Declareauthor author = list.get(i);
			this.ms.insertText(author.getAuthorname());
			this.ms.moveRight(1);
			this.ms.insertText(author.getDepartment());
			
		}
		for (int i = length; i < 4; i ++) {
			this.ms.moveDown(1);
		}
	}
	
	public void work(String filename) {
		ActiveXComponent app = new ActiveXComponent("Word.Application");
	}
	
	public void work(Declaretion declaretion, List<Declareauthor> declareauthors) {
		System.out.println("asda");
	}
	
	public static void main(String[] args) {
		ImportWord word = new ImportWord();
		word.work("asd.doc");
	}
}

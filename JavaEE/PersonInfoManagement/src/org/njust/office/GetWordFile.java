package org.njust.office;

import java.io.*;

public class GetWordFile {
	public GetWordFile() {
	}

	public File GetFile(String filename) {
		try {
			File file = new File("doc\\学术论文.doc");
			String filepath = file.getAbsolutePath();
			String str = filepath.substring(0, filepath.length() - 16);
			String str1 = str + "webapps\\PersonInfoManagement\\doc\\" + filename;
			File newFile = new File(str1);
			if (!newFile.exists()) {
				newFile.createNewFile();
			} else {
				newFile.delete();
				newFile.createNewFile();
			}
			File goalFile = new File(str + "webapps\\PersonInfoManagement\\doc\\学术论文.doc");
			FileInputStream fis = new FileInputStream(goalFile);
			FileOutputStream fos = new FileOutputStream(newFile);
			int n = fis.read();
			while (n != -1) {
				fos.write(n);
				n = fis.read();
			}
			fos.close();
			fis.close();
			return newFile;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		new GetWordFile().GetFile("asd.doc");
	}
}

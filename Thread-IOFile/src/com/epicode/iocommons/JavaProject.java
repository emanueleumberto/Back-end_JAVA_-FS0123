package com.epicode.iocommons;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class JavaProject {
	
	static File file = new File("testFile/test.txt");

	public static void main(String[] args) {
		
		try {
			scriviSuFile("Test scrittura!!!");
			String s = leggiDaFile();
			//System.out.println(s);
			//cancellaFile();
			//cancellaDir();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void scriviSuFile(String s) throws IOException {
		FileUtils.writeStringToFile(file, s, "UTF-8", true);
		System.out.println("Testo scritto su file");
	}
	
	public static String leggiDaFile() throws IOException {
		return FileUtils.readFileToString(file, "UTF-8");
	}
	
	public static void cancellaFile() throws IOException {
		FileUtils.deleteQuietly(file);
		System.out.println("File eliminato!!!");
	}
	
	public static void cancellaDir() throws IOException {
		FileUtils.deleteDirectory(new File("testFile/"));
		System.out.println("Directory eliminato!!!");
	}

}

package com.mc646.avaliacao06;

import java.util.ArrayList;
import java.util.List;

public class FileOpeneds {

	private List<File> files;

	public FileOpeneds() {
		super();
		this.setFiles(new ArrayList<File>());
	}
	

	public List<File> getFiles() {
		return files;
	}


	public void setFiles(List<File> files) {
		this.files = files;
	}

	public int getFileCount() {
		return this.files.size();
	}
	
	public void openFile(String string) {
		this.files.add(new File());
		
	}
	
	public class File{

		public String getName() {
			return "files/File01.txt";
		}
		
		
	}

	


	
}

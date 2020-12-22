package com.mc646.avaliacao06;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
	
	public void openFile(String filename) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filename));
			
			this.files.add(new File(filename, reader));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public class File{
		private String name;
		
		private BufferedReader reader;

		public File(String name, BufferedReader reader) {
			super();
			this.name = name;
			this.reader = reader;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public BufferedReader getReader() {
			return reader;
		}

		public void setReader(BufferedReader reader) {
			this.reader = reader;
		}
		
	}
	
}

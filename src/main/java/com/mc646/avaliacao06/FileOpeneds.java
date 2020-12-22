package com.mc646.avaliacao06;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileOpeneds {

	private List<File> files;
	private final int MAX_FILES = 10;
	
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

	public int getCountFile() {
		return this.files.size();
	}
	
	public File openFile(String filename) {
		BufferedReader reader;
		
		try {
			reader = new BufferedReader(new FileReader(filename));
			
			this.files.add(new File(filename, reader));
			
			if(getCountFileByName(filename) > 1) {
				deleteFile(filename);
			}
			
			if(files.size() > MAX_FILES) {
				return files.remove(0);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void deleteFile(String filename) {
		int index = -1;
		for(File file: files) {
			index++;
			if(file.getName().equalsIgnoreCase(filename)) {
				files.remove(index);
				return;
			}
			
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

	public int getCountFileByName(String filename) {
		int count = 0;
		for(File file: files) {
			if(file.getName().equalsIgnoreCase(filename)) {
				count++;
			}
		}
		
		return count;
	}

	public File getTop() {
		return files.get(files.size()-1);
	}
	
}

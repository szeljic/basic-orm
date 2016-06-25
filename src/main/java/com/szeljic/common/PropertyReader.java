package com.szeljic.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

	private String fileName = "config.properties";
	private Properties properties = new Properties();
	
	public PropertyReader() {
	}
	
	public PropertyReader(String fileName) throws Exception {
		if(fileName == null || fileName.equals("")) {
			throw new Exception("Please add file name of properties.");
		}
		this.fileName = fileName;
		
		this.loadProperties();
	}
	
	private void loadProperties() throws IOException {
		this.properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
	}
	
	public String get(String key){
		return this.properties.getProperty(key);
	}
	
	public boolean has(String key) {
		if(this.properties.getProperty(key) == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean empty(String key) throws Exception {
		if(!this.has(key)) {
			throw new Exception("Key does not exist!");
		}
		if(this.properties.getProperty(key).equals("")) {
			return true;
		} else {
			return false;
		}
	}

}

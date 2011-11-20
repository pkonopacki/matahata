package com.zwort.matahata.ws.client.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.zwort.matahata.ws.client.model.Item;

public class FileParser {
	
	@SuppressWarnings("unchecked")
	public List<Item> readItems(String filename) {
		XStream xs = new XStream();
		return (List<Item>) xs.fromXML(getFileInputSteramFromFile(filename));
	}
	
	private InputStream getFileInputSteramFromFile(String filename) {
		InputStream fin = null;
		
		try {
			fin = new FileInputStream(filename);
			
		} catch (IOException ioe) {
			System.err.println ("Unable to read from file");
			System.exit(-1);
		}
		return fin;
	}

}

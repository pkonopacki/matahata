package com.zwort.matahata.cli.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.zwort.matahata.cli.model.Item;

public class XmlFileParser implements FileParser {
	
	@SuppressWarnings("unchecked")
    @Override
	public List<Item> readItems(String filename) {
		XStream xs = new XStream();
		return (List<Item>) xs.fromXML(getFileInputSteramFromFile(filename));
	}
	
	private InputStream getFileInputSteramFromFile(String filename) {
		InputStream fin = null;

        try {
			fin = new FileInputStream(filename.trim());
			
		} catch (IOException ioe) {
			System.err.println ("Unable to read from file: " + filename);
            ioe.printStackTrace();
			System.exit(-1);
		}
		return fin;
	}

}

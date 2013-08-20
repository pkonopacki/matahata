package com.zwort.matahata.cli.file;

/**
 * Created with IntelliJ IDEA.
 * User: ext-konopi
 * Date: 16/04/12
 * Time: 22:09
 * To change this template use File | Settings | File Templates.
 */
public class FileParserFactory {

    public static final String XML_FILE_EXT = "xml";
    public static final String CSV_FILE_EXT = "csv";

    public FileParser createFileParser(String fileName) {
        System.out.println(fileName);
        String[] splitString = fileName.split("\\.");
        String ext = splitString[splitString.length - 1];

        if (ext != null && ext.trim().equals(XML_FILE_EXT)) {
            return new XmlFileParser();

        } else {
            return new CsvFileParser();

        }

    }

}

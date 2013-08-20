package com.zwort.matahata.cli.file;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import au.com.bytecode.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.zwort.matahata.cli.model.Item;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ext-konopi
 * Date: 18/04/12
 * Time: 00:16
 * To change this template use File | Settings | File Templates.
 */
public class CsvFileParser implements FileParser {

    @Override
    public List<Item> readItems(String filename) {
        List<Item> itemsList = new ArrayList<Item>();

        try {
            CSVReader reader = new CSVReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(filename)));
            String [] nextLine;
            CsvMapper mapper = new CsvMapper();

            while ((nextLine = reader.readNext()) != null) {
                // nextLine[] is an array of values from the line
                //TODO: Exception when reading line
                Item item = mapper.parseLine(nextLine);
                itemsList.add(item);
            }

//            for (Item ite : itemsList) {
//                System.out.print(ite.getType());
//                System.out.print(ite.getDate());
//            }

        } catch (IOException ioe) {
            System.err.println ("Unable to read from file: " + filename);
            ioe.printStackTrace();
            System.exit(1);

        } catch (Exception e) {
            //TODO: Maybe remove
            System.err.println ("Exception during parsing CSV file: " + filename + ": ");
            e.printStackTrace();
            System.exit(1);
        }

        return itemsList;

    }

}

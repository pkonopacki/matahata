package com.zwort.matahata.cli.test.file;

import com.zwort.matahata.cli.model.Item;
import com.zwort.matahata.cli.file.CsvFileParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pierre
 * Date: 6/21/12
 * Time: 12:07 AM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:applicationContext-test.xml" })
public class CSVFileParserTest {

//    public static final String FILE_NAME = "C:\\Users\\Peter_konopacki\\git\\matahata\\matahata-cli\\src\\test\\resources\\Czerwiec.csv";
    public static final String FILE_NAME = "csv/Czerwiec.csv";

    @Test
    public void testParseCsv() {
        CsvFileParser parser = new CsvFileParser();
        List<Item> itemList = parser.readItems(FILE_NAME);
        assertNotEquals(itemList.size(), 0);
        //TODO: add some logic to it
    }


}

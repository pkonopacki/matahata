package com.zwort.matahata.cli.file;

import com.zwort.matahata.cli.model.Item;
import com.zwort.matahata.cli.model.ItemType;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: pierre
 * Date: 6/21/12
 * Time: 1:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class CsvMapper {

    public Item parseLine(String[] line) {
        Item item = new Item();
        int lineLength = line.length;

        try {
            item.setType(readType(line[0]));
            item.setDate(parseDate(line[1]));
            item.setLocation(line[2]);
            item.setSource(line[3]);
            item.setAmount(parseDouble(line[4]));
            item.setSrcAccountNo(line[5]);
            item.setDestAccountNo(line[6]);
            item.setCategoryAbbr(line[7]);
            item.setDescription(line[8]);
            item.setBenefInitials(line[9]);
            //TODO: Think of valid algorithm here
            //TODO: parsing boolean when null
            item.setRefundable(lineLength >= 9 ? parseBoolean(line[10]) : null);
            item.setCleared(lineLength >= 10 ? parseBoolean(line[11]) : null);
            item.setDebt(lineLength >= 11 ? parseBoolean(line[12]) :null);
            item.setOriginalAmount(lineLength >= 12 ? parseDoubleNonMandatory(line[13]) : null);
            item.setOriginalCurrency(lineLength >= 13 ? line[14] : "");

        } catch (ArrayIndexOutOfBoundsException aoobe) {
            aoobe.printStackTrace();
        }

        return item;
    }

    private Date parseDate(String s) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS z");

        try {
            Date date = (Date)formatter.parse(s);
            return date;

        } catch (Exception e) {
            System.err.println("Error parsing Date [" + s + "]. Abnormal termination");
            e.printStackTrace();
            System.exit(1);
            return null;
        }

    }

    private ItemType readType(String s) {

        if (s.equals("EXPENSE")) {
            return ItemType.EXPENSE;

        } else if (s.equals("TRANSFER")) {
            return ItemType.TRANSFER;

        } else if (s.equals("INCOME")){
            return ItemType.INCOME;

        } else {
            System.err.println("Error parsing Type [" + s + "]. Abnormal termination");
            System.exit(1);
            return null;
        }

    }

    private Double parseDouble(String s) {

        try  {
            return Double.parseDouble(s);

        } catch (Exception e) {
            System.err.println("Error parsing Double [" + s + "]. Abnormal termination");
            e.printStackTrace();
            System.exit(1);
            return null;
        }

    }

    private Double parseDoubleNonMandatory(String s) {

        try  {
            return Double.parseDouble(s);

        } catch (Exception e) {
            System.err.println("Error parsing Double [" + s + "].");
            return null;
        }

    }

    private Boolean parseBoolean(String s) {

        try {
            return Boolean.parseBoolean(s);

        } catch (Exception e) {
            System.err.println("Error parsing Boolean: [" + s + "]. Abnormal termination");
            e.printStackTrace();
            System.exit(1);
            return null;
        }

    }

}

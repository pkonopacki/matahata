package com.zwort.matahata.cli.file;

import com.zwort.matahata.cli.model.Item;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ext-konopi
 * Date: 18/04/12
 * Time: 00:13
 * To change this template use File | Settings | File Templates.
 */
public interface FileParser {

    List<Item> readItems(String filename);

}

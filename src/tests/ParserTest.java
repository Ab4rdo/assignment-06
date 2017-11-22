package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import parsers.ParseCSV;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ParserTest {

    String[] myNames = {"Mirek","Janusz","Kolega","Rufus"};

    @Test
    public void csvParserTest() {

        List<String> list2Check = ParseCSV.parseFile(new File("csvTest.csv"));
        String[] toCheck = new String[list2Check.size()];
        list2Check.toArray(toCheck);

        Assert.assertArrayEquals(myNames, toCheck);
    }
}

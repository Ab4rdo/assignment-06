package parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ParseCSV {

    private static final String csvSplitBy = ",";

    public static List<String> parseFile(File file) {

        List<String> list = new ArrayList<>();
        String line = "";

        try (BufferedReader bufferedReader  = new BufferedReader(new FileReader(file))) {
            while((line = bufferedReader.readLine()) != null) {
                String[] names = line.split(csvSplitBy);
                String curr;
                for(String s : names) {
                    curr = s.replace("\"", "");
                    curr = curr.trim();
                    list.add(curr);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }







}

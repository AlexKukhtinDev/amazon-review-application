package com.akukhtin.amazonreviewapplication.parser;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import org.springframework.stereotype.Component;

@Component
public class ParserUtil {
 private static final String CSV_FILE_PATH = "/Users/akukhtin/Downloads/Reviews.csv";

  public void parse() {
   CSVReader reader = null;
   try {
    reader = new CSVReader(new FileReader(CSV_FILE_PATH));
    String[] line;
    while ((line = reader.readNext()) != null) {
     //TODO
    }
   } catch (IOException e) {
    e.printStackTrace();
   }
  }
}

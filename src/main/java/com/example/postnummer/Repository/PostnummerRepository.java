package com.example.postnummer.Repository;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class PostnummerRepository {

  public PostnummerRepository() {
  }

public HashMap<String, String> postMap() {

  HashMap<String, String> postnummerMap = new HashMap<>();
  try{
    File file = new ClassPathResource("danskeByer.csv").getFile();
    Scanner input = new Scanner(file);

    while (input.hasNextLine()) {
      String line = input.nextLine();
      Scanner lineScanner = new Scanner(line).useDelimiter(";");
      String postnummer = lineScanner.next();
      String by = lineScanner.next();
      postnummerMap.put(postnummer, by);
    }
  } catch (IOException e) {
    e.printStackTrace();
  }
  return postnummerMap;
}

}

package com.example.postnummer.Service;


import com.example.postnummer.Repository.PostnummerRepository;

import java.util.HashMap;

public class PostnummerService {

  PostnummerRepository postnummerRepository;
  HashMap<String, String> postnummerMap;


  public PostnummerService() {
    postnummerRepository = new PostnummerRepository();
    postnummerMap = postnummerRepository.postMap();
  }

  public String findBy(String postnummer){
    return postnummerMap.get(postnummer);
  }
}

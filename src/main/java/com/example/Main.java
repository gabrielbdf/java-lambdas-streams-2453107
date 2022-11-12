package com.example;

import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.sound.midi.Track;
import javax.swing.plaf.basic.BasicTreeUI.TreeModelHandler;

public class Main {

  public static void main(String[] args) {

    Stream<String> lettersStream = Stream.of("a", "b", "c");

    Integer[] scores = new Integer[]{80, 66, 73, 92, 43};
    Stream<Integer> scoresStream = Arrays.stream(scores);

    List<String> shoppingList = new ArrayList<>();
    shoppingList.add("coffee");
    shoppingList.add("bread");
    shoppingList.add("pineapple");
    shoppingList.add("milk");
    shoppingList.add("pasta");
    
    Map<String, List<String>> transformedMap = shoppingList
            .stream()
            .sorted()
            .map(item -> item.substring(0,1).toUpperCase().concat(item.substring(1)))           
            .collect(Collectors.groupingBy(item -> item.substring(0,1)))
            .entrySet()
            .stream()
            .sorted((a,b) -> a.getKey().charAt(0) > b.getKey().charAt(0) ? 1 : -1)
            .collect(Collectors.toMap(
                 (item) -> item.getKey(),
                 (item) -> item.getValue(),
                 (v1, v2) -> {throw new RuntimeException();},
                 TreeMap::new
            ));


            System.out.println(transformedMap);
  }
}

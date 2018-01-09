package com.company;
import java.util.*;
import java.io.*;

public class Genres {
    private Map<String, Map<String, Integer>> genreToKeyScores = new HashMap<>();

    //Parsing csv file
    public Genres(File file){
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();
            String line;
            while (scan.hasNextLine()) {
                line = scan.nextLine();
                String[] data = line.split(", ");
                if (!genreToKeyScores.containsKey(data[0])) {
                    Map<String, Integer> newMap= new HashMap<>();
                    newMap.put(data[1], Integer.parseInt(data[2]));
                    genreToKeyScores.put(data[0], newMap);
                }
                else{
                    Map<String, Integer> map = genreToKeyScores.get(data[0]);
                    map.put(data[1],Integer.parseInt(data[2]));
                    genreToKeyScores.put(data[0], map);
                }
            }
        }
        catch(Exception e){
            System.out.println("Error parsing csv file");
        }
    }

    public Map<String, Map<String, Integer>> getGenreToKeyScores() {
        return genreToKeyScores;
    }
}

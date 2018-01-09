package com.company;

import java.util.*;
import java.util.regex.*;

public class Book {

    //Genre -> Score
    private TreeMap<String, Double> genreScores = new TreeMap<>();

    private String title;
    private String Description;

    public Book(String pTitle, String pDescription){
        this.title = pTitle;
        this.Description = pDescription;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.Description;
    }

    public void calculateGenreScores(Genres genres) {

        //Iterate through every Genre
        for (Map.Entry<String, Map<String, Integer>> entry: genres.getGenreToKeyScores().entrySet()){
            //Keyword -> occurance for algorithm use
            Map<String, Integer> occurances = new HashMap<>();
            //Keyword -> points for a genre
            Map<String, Integer> points = entry.getValue();

            //populate occurances
            for (String keyword: points.keySet()){
                Pattern p = Pattern.compile(keyword);
                Matcher m = p.matcher(this.getDescription());
                int count = 0;
                while (m.find()) {
                    count++;
                }
                if (count > 0)
                    occurances.putIfAbsent(keyword, count);
            }

            //calculate score
            int totalPoints = 0;
            int totalOccurrences = 0;
            for (Map.Entry<String, Integer> entry2: occurances.entrySet()){
                    //points for occuring words
                    totalPoints = totalPoints + points.get(entry2.getKey());
                    totalOccurrences = totalOccurrences + entry2.getValue();

            }
            //Store genre and score if needed
            if (occurances.size() > 0) {
                double score = (totalPoints / occurances.size()) * totalOccurrences;
                this.genreScores.put(entry.getKey(), score);
            }
        }
    }

    public void printScores(){
        System.out.println(this.getTitle());
        System.out.println("");
        for (Map.Entry<String, Double> genreScore: this.genreScores.entrySet()){
            System.out.println(genreScore.getKey() + ", " + genreScore.getValue());
        }
    }

}

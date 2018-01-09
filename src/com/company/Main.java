package com.company;

import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {

     //   File jsonFile = new File("Data/" + args[0]);
        File csvFile = new File("Data/" + args[1]);
        Genres genres = new Genres(csvFile);
        Utilities utilities = new Utilities();
        List<Book> bookList = utilities.createBooks(jsonFile);
        for (Book book: bookList){
            book.calculateGenreScores(genres);
        }


        //Sorting books by alphabetical order
        Collections.sort(bookList, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareTo(b2.getTitle());
            }
        });

        for(Book book: bookList){
            book.printScores();
            System.out.println("");
            System.out.println("");
        }

    }
}

package com.company;
import java.io.*;
import java.net.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Utilities {
    //Parsing JSON file
    public List<Book> createBooks(File file) throws IOException, ParseException {

        int page = 1;
        List<Book> bookList = new ArrayList<Book>();
        while (true) {
            InputStream input = new URL("https://pairing-library.herokuapp.com/api/v1/books?page=" + Integer.toString(page)).openStream();
            JSONParser parser = new JSONParser();
            JSONArray jsonArray2 = (JSONArray) parser.parse(new InputStreamReader(input, "UTF-8"));
            if (jsonArray2.isEmpty()) break;

            //JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(file));

            for (Object o : jsonArray2) {
                JSONObject bookObject = (JSONObject) o;
                String name = (String) bookObject.get("title");
                String description = (String) bookObject.get("description");
                bookList.add(new Book(name, description));
            }

            page++;
            System.out.println(page);
            input.close();
        }
        return bookList;
    }






}

package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class FilmManager {
    public HashSet<String> genres = new HashSet<>();
    public static HashMap<String, ArrayList<Film>> findProducersFilms(ArrayList<Film> films){
        var producersMap = new HashMap<String, ArrayList<Film>>();
        for (Film f:films) {
            if (producersMap.containsKey(f.producer)){
                producersMap.get(f.producer).add(f);
            }
            else{
                var temp = new ArrayList<Film>();
                temp.add(f);
                producersMap.put(f.producer,temp);
            }
        }
        return producersMap;
    }
    public void FillGenres(){
        this.genres.add("Action");
        this.genres.add("Comedy");
        this.genres.add("Drama");
        this.genres.add("Fantasy");
        this.genres.add("Horror");
        this.genres.add("Mystery");
        this.genres.add("Thriller");
    }
    public static HashMap<Integer, HashSet<String>> findFilmsByYear(ArrayList<Film> films){
        var yearMap = new HashMap<Integer, HashSet<String>>();
        for (Film f:films) {
            if (yearMap.containsKey(f.productionYear)){
                yearMap.get(f.productionYear).add(f.name);
            }
            else{
                var temp = new HashSet<String>();
                temp.add(f.name);
                yearMap.put(f.productionYear,temp);
            }
        }
        return yearMap;
    }
    public static ArrayList<String> ReadInfoFromFile(String filePath){
        ArrayList<String> everything = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();

            while (line != null) {
                everything.add(line);
                line = br.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return everything;
    };
    public static void FillFilmsArray(ArrayList<Film> films,ArrayList<String> str){
        for (String s:str) {
            String st[] = s.split(",");
            films.add(new Film(st[0], st[1],Integer.parseInt(st[2]), st[3]));
        }
        //filmList.add(new Film("First", "20 century", 2013,"Comedy"));
        //filmList.add(new Film("Second", "20 century", 2011,"Action"));
        //filmList.add(new Film("Third", "Sony", 2015, "Fantasy"));
        //filmList.add(new Film("Fourth", "Disney", 2013, "Drama"));
        //filmList.add(new Film("Fifth", "Marvel", 2013, "Comedy"));
        //filmList.add(new Film("Sixth", "Sony", 2015, "Horror"));
        //filmList.add(new Film("Seventh", "Marvel", 2011,"Mystery"));
    };

    public static void PrintFilms(ArrayList<Film> films){
        for (Film f:films) {
            System.out.println(f.toString());
        }
    };
}

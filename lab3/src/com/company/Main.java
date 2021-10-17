package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("string from first file");
        var str1 = FilmManager.ReadInfoFromFile(
                "D:\\politeh\\3course\\KPP\\labs\\lab3\\src\\com\\company\\data.txt");
        System.out.println(str1);
        System.out.println("------------------------------");
        System.out.println("string from first file");
        var str2 = FilmManager.ReadInfoFromFile(
                "D:\\politeh\\3course\\KPP\\labs\\lab3\\src\\com\\company\\data2.txt");
        System.out.println(str2);
        System.out.println("------------------------------");
        var films = new ArrayList<Film>();
        FilmManager.FillFilmsArray(films,str1);
        FilmManager.FillFilmsArray(films,str2);
        System.out.println("All available films");
        FilmManager.PrintFilms(films);
        System.out.println("------------------------------");
        System.out.println("Films produced in following year");
        var filmsByYear = FilmManager.findFilmsByYear(films);
        for (HashMap.Entry entry : filmsByYear.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: "
                    + entry.getValue());
        }
        System.out.println("------------------------------");
        System.out.println("Films produced by following producer");
        var filmsByProducer = FilmManager.findProducersFilms(films);
        for (HashMap.Entry entry : filmsByProducer.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: "
                    + entry.getValue());
        }
        System.out.println("------------------------------");

    }
}

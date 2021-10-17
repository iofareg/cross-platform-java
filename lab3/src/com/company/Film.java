package com.company;

import java.util.HashSet;

public class Film {
    public String name;
    public String producer;
    public int productionYear;
    public String genre;
    public Film(String name, String producer, int productionYear,String genre){
        this.name = name;
        this.producer=producer;
        this.productionYear=productionYear;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", productionYear=" + productionYear +
                ", Genre='" + genre + '\'' +
                '}';
    }
}
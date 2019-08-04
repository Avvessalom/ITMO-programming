package com.company;
import java.util.Comparator;

public class Characters implements Comparator{
    private String name;

    Characters(String name){
        this.name = name;
    }

    String getName(){
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return o1.toString().compareTo(o2.toString());
    }
}

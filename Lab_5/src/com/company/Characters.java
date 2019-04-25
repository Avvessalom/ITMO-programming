package com.company;
import java.util.Comparator;

public class Characters implements Comparator{
    private String name;

    public Characters(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return o1.toString().compareTo(o2.toString());
    }
}

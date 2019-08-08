package com.company;
import java.util.*;

public class Characters implements Comparable<Characters>{
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
    public int compareTo(Characters o) {
        return name.compareTo(o.getName());
    }

}

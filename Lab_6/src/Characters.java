import java.util.*;

/**
 * @author Eugene Lazurin R3136
 */


public class Characters implements Comparable<Characters>{
    private String name;
    private int size;
    private double location;
    private Date dateOfAppearing;


    Characters(String name, int size, double location){
        this.name = name;
        this.size = size;
        this.location = location;
        dateOfAppearing = new Date();
    }

    String getName(){
        return name;
    }



    public void setSize(int size){
        this.size = size;
    }
    int getSize(){
        return size;
    }



    public void setLocation(double location){
        this.location = location;
    }

    public double getLocation(){
        return location;
    }


    public Date getDateOfAppearing(){
        return dateOfAppearing;
    }


    private String firstUpperCase(String s){
        return s.substring(0,1).toUpperCase()+s.substring(1);
    }
    @Override
    public int compareTo(Characters o) {
        return name.compareTo(o.getName());
    }

    @Override
    public String toString(){
        return firstUpperCase(name) + "{" +
                "name: " + name +
                ",location: " + location +
                ", size: " + size +
                ", dateOfAppearing: " + dateOfAppearing +
                "}" + "\n";
    }

}

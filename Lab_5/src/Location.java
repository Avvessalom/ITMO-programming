import java.util.Random;

public abstract class Location {


    public int Weather;
    public String Weather_str;
    final Random random = new Random();

    public void setWeather(){
        Weather = random.nextInt(2);
    }
    public String getWeather(){
        if (Weather == 1){
            Weather_str = "Погода хорошая, солнечно";
        }
        if  (Weather == 0){
           Weather_str = "Ой, кажется дождь начинается!";
        }
        return Weather_str;
    }

    public String name;

    public void setName(String name) {
        this.name = name;
    }




    @Override
    public boolean equals(Object obj) {
        System.out.println("Переопределенный equals()");
        return 1 == 2;
    }

    @Override
    public int hashCode() {
        System.out.println("Переопределенный hashCode()");

        return 1;
    }
    // переопределение метода toString()
    @Override
    public String toString() {
        return ("Переопределенный toString");
    }
}

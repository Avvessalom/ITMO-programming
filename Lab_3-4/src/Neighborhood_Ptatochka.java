public class Neighborhood_Ptatochka extends  Location {


    public class House_Pyatochka extends Location {
        public void display() {
            System.out.print("к дому Пяточка.");
        }
    }


    public class Land extends Location {
        public void display() {
            System.out.print("на земле и");
        }
    }

    public void LocalClass(){
        class LocalInnerClass{
           public void LocalInnerClassMethod(){
               System.out.print("Локальный Класс");
           }
        }
    }



    void g() {
        // анонимный класс
        House_Pyatochka bref = new House_Pyatochka() {
        };
    }
}
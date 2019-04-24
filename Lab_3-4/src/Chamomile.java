public class Chamomile extends Thing {

    int a = 2147483640;

    public void display() {
        System.out.print("на ромашке");

    }

    public void height() throws Error {
        if (a<2147483640) {
            this.height = a * 10;
        }else {
            throw new UnCheckedException("unchecked exception(слишком большое число)");
        }

    }


    public static void structure() {
          class Spike{
             public String color = "green";
             public int quantity = 10;
         }
         Spike spike = new Spike();
    }
}

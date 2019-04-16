public class Main {


    public static void main(String[] args){

         Goodbye  goodBye = new Goodbye();
         Krolick krolick = new Krolick();
         Run run = new Run();
        Neighborhood_Ptatochka neighborhood_ptatochka = new Neighborhood_Ptatochka();
         Neighborhood_Ptatochka.House_Pyatochka house_pyatochka= neighborhood_ptatochka.new House_Pyatochka();
        Neighborhood_Ptatochka.Land land = neighborhood_ptatochka.new Land();
         Space space = new Space();
        Pyatochok pyatochok = new Pyatochok();
        Sit sit = new Sit();
        Guess guess = new Guess();
        Chamomile chamomile = new Chamomile();
        Find_Out find_out = new Find_Out();
        Guess_P guess_p = new Guess_P();
        Turn_Up turn_up = new Turn_Up();
        Try trye = new Try();
        Made_a_guess made_a_guess = new Made_a_guess();
        Recall recall = new Recall();
        ViniPooh viniPooh = new ViniPooh();
        Hope hope = new Hope();

        try {
            chamomile.height();
        }catch (UnCheckedException ex){
            String.format("%n");
            System.err.println(ex.getMessage());
        }


           krolick.setName("Кроликом");
        pyatochok.setName("Пяточокок");
        viniPooh.setName("Вини-Пух.");



         goodBye.display(); space.display();
        try {
            krolick.display(); space.display();
        }catch (CheckedException e){
            String.format("%n");
            System.err.println(e.getMessage());
        }

         run.display();     space.display();
        house_pyatochka.display();space.display();



        try {
            pyatochok.display(); space.display();
        }catch (CheckedException e){
            String.format("%n");
            System.err.println(e.getMessage());
        }

        sit.display();space.display();
         land.display();space.display();
        guess.display();space.display();
        chamomile.display();space.display();
        find_out.display(); space.display();
        guess_p.display(Enum2.love);space.display();
        turn_up.display();space.display();
         trye.display(); space.display();
         made_a_guess.display();space.display();
         hope.display();space.display();



        try {
            viniPooh.display(); space.display();
        }catch (CheckedException e){

            System.out.println(e.getMessage());

        }

        recall.display();space.display();
        try {
            viniPooh.display(); space.display();
        }catch (CheckedException e){

            System.out.println(e.getMessage());


        }


    }
}

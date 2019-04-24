public abstract class Thing {
    int height;

    public void setHeight(int height) {
        this.height = height;
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

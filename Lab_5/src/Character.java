public abstract class Character {
    public String name;

    public void setName(String name) {
        this.name = name;
    }
    public void display() throws CheckedException {

        if (this.name != null) {
            System.out.print(this.name);
        }
        else {throw new CheckedException("\nУ описываемого персонажа нет имени\n");}
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


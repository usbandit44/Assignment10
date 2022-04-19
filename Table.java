// Assignment: Assignment9.java
// Name: Arvin Edouard
// StudentID: 1222200512
// Lecture: Tuesday Thursday 1:30 to 2:45
// Description: Table class that creates table for peoples reservations

public class Table {
    String name;
    int guests;
    Table next;

    public Table(int n, String name){
        this.name = name;
        guests = n;
        next = null;
    }

    public String getName(){
        return name;
    }

    public String toString(){
        return "\nReservation for " + name + ": party of "
                + guests + ".\n";
    }


    public static class EmptyTable extends Table{

        public EmptyTable() {
            super(-1, "");
        }
    }
}

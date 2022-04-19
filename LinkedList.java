
// Assignment: Assignment10.java
// Name: Arvin Edouard
// StudentID: 1222200512
// Lecture: Tuesday Thursday 1:30 to 2:45
// Description: Class for link list that hold tables aloows for different minuplations of the list

import java.lang.reflect.Field;

public class LinkedList {
    Table first;
    int size;
    public LinkedList(){
        first = null;
        size = 0;
    }

    public void add(int numberOfGuests, String name){
        Table newGuest = new Table(numberOfGuests, name);
        if(first == null){
            first = newGuest;
        }
        else{
            Table pointer = first;
            while(pointer.next != null)
                pointer = pointer.next;

            pointer.next = newGuest;
        }
        size++;
    }

    public Table removeFirst(){
        if(first != null){ //checks if the list is empty
            Table temp = first;// removes first and saves it as temp
            first = first.next;
            size--;
            return temp;
        }else{
            return new Table.EmptyTable();// if empty returns empty table
        }
    }

    public Table removeLast(){
        Table temp = first;
        Table previous = first;
        while(temp != null){// goes to last varable in the linked lost
            previous = temp;
            temp = temp.next;
        }
        previous.next = null;// removes last element
        size--;
        return temp;
    }

    public Table removeMiddle(String a){
        Table temp = first;
        Table previous = first;
        while(temp != null && !temp.getName().equals(a)){// goes through list until it finds matching element
            previous = temp;
            temp = temp.next;
        }
        if(temp == null){// if it doesn't find element return empty table
            return new Table.EmptyTable();
        }else{// removes element
            previous.next = temp.next;
            size--;
            return temp;
        }
    }

    public Table removeGuest(String a){
        if(first == null){// if list is emoty
            return new Table.EmptyTable();
        }else if(first.getName().equals(a)){// if guest if first in line
           return this.removeFirst();
        }else{
            return this.removeMiddle(a);
        }
    }

    public int getPosition(String a){
        Table temp = first;
        int position = 0;
        if(first == null){// check if list is empty
            return -1;
        }else{
            while(temp != null && !temp.getName().equals(a)){// checks if element is found or if goes though entire list
                temp = temp.next;
                position++;
            }
        }
        if(temp == null){// if element not found
            return -1;
        }else{// if element is found
            return position;
        }
    
    }

    public int getNumberOfParties(int a){
        Table temp = first;
        int count = 0;
        while(temp != null){// checks if at end of list
            if(temp.guests == a){// checks if guest count equals provided number
                count++;
            }
            temp = temp.next;
        }
        return count;
    }

    public String listReservations(){
        Table temp = first;
        String list = "";
        while(temp != null){// adds every element in list to string
            list = list + temp.toString();
            temp = temp.next;
        }
        list = list + "\nTotal reservations: " + size + ".\n";
        String empty = "No reservations in queue at this time.\n";
        if(first == null){
            return empty;
        }else{
            return list;
        }
    }

}

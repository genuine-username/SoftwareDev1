// Jackson Allaway jackson.allaway@oneidaihla.org
// for CTE software development 1
// instructor Mr Gross

package Week6;

//import Week6.Horse;
import java.util.ArrayList;

public class Objects {
    public static void main(String[] args) {
        // Create an arrayList of horses
        ArrayList<Horse> horses = new ArrayList<Horse>();
        horses.add(new Horse("Hasufel", 1954));
        horses.add(new Horse("Bill", 1954));
        horses.add(new Horse("Snowmane", 1955));

        // Print their names and years of birth
        System.out.println("\nHere are my horses:");
        for (Horse horse : horses) {
            System.out.println("Name: " + horse.name + " Born: " + String.valueOf(horse.birthYear));
        }
    }
}


// Simple horse class created by Kim Gross
// for CTE Software Development class 2022

class Horse {
    String name;// current name of the horse
    int birthYear;// year the horse was born
    String[] names; // array of old names of the horse
    int numberofNames = 0; // how many old names are there.

    public Horse(String horseName, int year) { // horse constructor needs its name and birth year.
        name = horseName; // assigns the name of the horse to the horseName which was sent in the
                          // construtor.
        birthYear = year; // assigns the year to the birthYear that was sent in the constructor;
    }

    public void age() {
        // what should be in a age function?
    }

    public void changeName(String newName) {// change the name but safe the old name
        names[numberofNames] = name;
        numberofNames++;
        name = newName;
    }

    public String toString() {
        return name;
    }

}

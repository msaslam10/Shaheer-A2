import java.util.*;

public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partFive();
        assignment.partSix();
    }

    public void partFive() {
        Employee employee = new Employee("John", 35, "101 Theme Park Rd", "E001", "Ride Operator");
        Ride rollerCoaster = new Ride("Roller Coaster", 5, true, employee, 0);

        Visitor visitor1 = new Visitor("Michael", 25, "123 Wonderland Ave", "V001", "Day Pass");
        Visitor visitor2 = new Visitor("Sarah", 30, "456 Nowhere St", "V002", "Season Pass");
        Visitor visitor3 = new Visitor("James", 22, "789 Somewhere Blvd", "V003", "Day Pass");
        Visitor visitor4 = new Visitor("Emily", 28, "321 Fantasy Rd", "V004", "Day Pass");
        Visitor visitor5 = new Visitor("Jessica", 26, "654 Adventure St", "V005", "Season Pass");
        Visitor visitor6 = new Visitor("David", 29, "987 Epic Ln", "V006", "Day Pass");
        Visitor visitor7 = new Visitor("Linda", 31, "456 Fairytale Ave", "V007", "Season Pass");
        Visitor visitor8 = new Visitor("Robert", 23, "234 Dreamland Rd", "V008", "Day Pass");
        Visitor visitor9 = new Visitor("Alice", 27, "345 Fantasy St", "V009", "Season Pass");
        Visitor visitor10 = new Visitor("Brian", 24, "678 Magic Blvd", "V010", "Day Pass");

        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);
        rollerCoaster.addVisitorToQueue(visitor6);
        rollerCoaster.addVisitorToQueue(visitor7);
        rollerCoaster.addVisitorToQueue(visitor8);
        rollerCoaster.addVisitorToQueue(visitor9);
        rollerCoaster.addVisitorToQueue(visitor10);

        System.out.println("Queue before running one cycle:");
        rollerCoaster.printQueue();

        rollerCoaster.runOneCycle();

        System.out.println("Queue after running one cycle:");
        rollerCoaster.printQueue();

        System.out.println("Ride history after running one cycle:");
        rollerCoaster.printRideHistory();
    }

    public void partSix() {
        Employee employee = new Employee("John", 35, "101 Theme Park Rd", "E001", "Ride Operator");
        Ride rollerCoaster = new Ride("Roller Coaster", 5, true, employee, 0);

        // Add some visitors to the ride history for demonstration
        Visitor visitor1 = new Visitor("Michael", 25, "123 Wonderland Ave", "V001", "Day Pass");
        Visitor visitor2 = new Visitor("Sarah", 30, "456 Nowhere St", "V002", "Season Pass");
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.runOneCycle();

        // Write ride history to file
        rollerCoaster.writeRideHistoryToFile("ride_history.csv");
    }
}

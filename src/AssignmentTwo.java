import java.io.IOException;
import java.util.Comparator;

public class AssignmentTwo {

    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
        assignment.partFourA();
        assignment.partFourB();
        assignment.partFive();
        assignment.partSix();
        assignment.partSeven();
    }

    public void partThree() {
        Visitor visitor = new Visitor("Michael", 25, "123 Wonderland Ave", "V001", "Day Pass");
        visitor.introduce();
    }


    public void partFourA() {
        // Create an employee
        Employee employee = new Employee("John", 35, "101 Theme Park Rd", "E001", "Ride Operator");
        // Create a ride
        Ride rollerCoaster = new Ride("Roller Coaster", 5, true, employee);

        // Create some sample visitors
        Visitor visitor1 = new Visitor("Michael", 25, "123 Wonderland Ave", "V001", "Day Pass");
        Visitor visitor2 = new Visitor("Sarah", 30, "456 Nowhere St", "V002", "Season Pass");
        Visitor visitor3 = new Visitor("James", 22, "789 Somewhere Blvd", "V003", "Day Pass");
        Visitor visitor4 = new Visitor("Emily", 28, "321 Fantasy Rd", "V004", "Day Pass");
        Visitor visitor5 = new Visitor("Jessica", 26, "654 Adventure St", "V005", "Season Pass");

        // Add visitors to the ride history
        rollerCoaster.addVisitorToRideHistory(visitor1);
        rollerCoaster.addVisitorToRideHistory(visitor2);
        rollerCoaster.addVisitorToRideHistory(visitor3);
        rollerCoaster.addVisitorToRideHistory(visitor4);
        rollerCoaster.addVisitorToRideHistory(visitor5);

        // Check if a visitor is in the ride history
        boolean isInHistory = rollerCoaster.isVisitorInRideHistory(visitor3);
        System.out.println("Is visitor James in ride history? " + isInHistory);

        // Print the number of visitors in the ride history
        int numberOfVisitors = rollerCoaster.getNumberOfVisitorsInRideHistory();
        System.out.println("Number of visitors in ride history: " + numberOfVisitors);

        // Print unsorted ride history
        System.out.println("Unsorted ride history:");
        rollerCoaster.printRideHistory();
    }

    public void partFourB() {
        // Create an employee
        Employee employee = new Employee("John", 35, "101 Theme Park Rd", "E001", "Ride Operator");
        // Create a ride
        Ride rollerCoaster = new Ride("Roller Coaster", 5, true, employee);

        // Create some sample visitors
        Visitor visitor1 = new Visitor("Michael", 25, "123 Wonderland Ave", "V001", "Day Pass");
        Visitor visitor2 = new Visitor("Sarah", 30, "456 Nowhere St", "V002", "Season Pass");
        Visitor visitor3 = new Visitor("James", 22, "789 Somewhere Blvd", "V003", "Day Pass");
        Visitor visitor4 = new Visitor("Emily", 28, "321 Fantasy Rd", "V004", "Day Pass");
        Visitor visitor5 = new Visitor("Jessica", 26, "654 Adventure St", "V005", "Season Pass");

        // Add visitors to the ride history
        rollerCoaster.addVisitorToRideHistory(visitor1);
        rollerCoaster.addVisitorToRideHistory(visitor2);
        rollerCoaster.addVisitorToRideHistory(visitor3);
        rollerCoaster.addVisitorToRideHistory(visitor4);
        rollerCoaster.addVisitorToRideHistory(visitor5);

        // Print unsorted ride history
        System.out.println("Unsorted ride history:");
        rollerCoaster.printRideHistory();

        // Sort the ride history by visitor name
        rollerCoaster.sortRideHistory(Comparator.comparing(Visitor::getName));

        // Print sorted ride history
        System.out.println("Sorted ride history:");
        rollerCoaster.printRideHistory();
    }

    public void partFive() {
        Employee operator = new Employee("John", 35, "101 Theme Park Rd", "E001", "Ride Operator");
        Ride rollerCoaster = new Ride("Roller Coaster", 5, true, operator);

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

        // Export ride history to file
        rollerCoaster.writeRideHistoryToFile("ride_history.csv");

        System.out.println("Ride history after running one cycle:");
        rollerCoaster.printRideHistory();
        System.out.println("Ride history has been exported to ride_history.csv");
    }

    public void partSix() {
        Employee operator = new Employee("John", 35, "101 Theme Park Rd", "E001", "Ride Operator");
        Ride rollerCoaster = new Ride("Roller Coaster", 5, true, operator);

        // Add some visitors to the ride history for demonstration
        Visitor visitor1 = new Visitor("Michael", 25, "123 Wonderland Ave", "V001", "Day Pass");
        Visitor visitor2 = new Visitor("Sarah", 30, "456 Nowhere St", "V002", "Season Pass");
        Visitor visitor3 = new Visitor("James", 22, "789 Somewhere Blvd", "V003", "Day Pass");
        Visitor visitor4 = new Visitor("Emily", 28, "321 Fantasy Rd", "V004", "Day Pass");
        Visitor visitor5 = new Visitor("Jessica", 26, "654 Adventure St", "V005", "Season Pass");

        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);

        // Run one cycle to add visitors to ride history
        rollerCoaster.runOneCycle();

        // Export ride history to file
        rollerCoaster.writeRideHistoryToFile("ride_history.csv");

        System.out.println("Ride history has been exported to ride_history.csv");
    }

    public void partSeven() {
        Employee operator = new Employee("John", 35, "101 Theme Park Rd", "E001", "Ride Operator");
        Ride rollerCoaster = new Ride("Roller Coaster", 5, true, operator);

        // Import the ride history from the file
        rollerCoaster.readRideHistoryFromFile("ride_history.csv");

        // Print the number of visitors in the ride history
        System.out.println("Number of visitors in the ride history: " + rollerCoaster.getNumberOfVisitorsInRideHistory());

        // Print all visitors in the ride history
        System.out.println("Visitors in the ride history:");
        rollerCoaster.printRideHistory();
    }
}

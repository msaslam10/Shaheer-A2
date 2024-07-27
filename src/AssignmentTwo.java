public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partFourA();
        assignment.partFourB();
        assignment.partFive();
    }

    public void partThree() {
        // Implementation for part three
    }

    public void partFourA() {
        // Create an employee
        Employee employee = new Employee("John", 35, "101 Theme Park Rd", "E001", "Ride Operator");

        // Create a ride
        Ride rollerCoaster = new Ride("Roller Coaster", 5, true, employee, 3);

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

        // Print all visitors in the ride history
        rollerCoaster.printRideHistory();
    }

    public void partFourB() {
        // Create an employee
        Employee employee = new Employee("John", 35, "101 Theme Park Rd", "E001", "Ride Operator");

        // Create a ride
        Ride rollerCoaster = new Ride("Roller Coaster", 5, true, employee, 3);

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

        // Print the ride history before sorting
        System.out.println("Ride history before sorting:");
        rollerCoaster.printRideHistory();

        // Sort the ride history
        VisitorComparator visitorComparator = new VisitorComparator();
        rollerCoaster.sortRideHistory(visitorComparator);

        // Print the ride history after sorting
        System.out.println("Ride history after sorting:");
        rollerCoaster.printRideHistory();
    }

    public void partFive() {
        // Create an employee
        Employee employee = new Employee("John", 35, "101 Theme Park Rd", "E001", "Ride Operator");

        // Create a ride
        Ride rollerCoaster = new Ride("Roller Coaster", 5, true, employee, 3);

        // Create some sample visitors
        Visitor visitor1 = new Visitor("Michael", 25, "123 Wonderland Ave", "V001", "Day Pass");
        Visitor visitor2 = new Visitor("Sarah", 30, "456 Nowhere St", "V002", "Season Pass");
        Visitor visitor3 = new Visitor("James", 22, "789 Somewhere Blvd", "V003", "Day Pass");
        Visitor visitor4 = new Visitor("Emily", 28, "321 Fantasy Rd", "V004", "Day Pass");
        Visitor visitor5 = new Visitor("Jessica", 26, "654 Adventure St", "V005", "Season Pass");

        // Add visitors to the queue
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);

        // Run one cycle of the ride
        rollerCoaster.runOneCycle();

        // Print the ride history after running one cycle
        System.out.println("Ride history after running one cycle:");
        rollerCoaster.printRideHistory();
    }

    public void partSix() {
    }

    public void partSeven() {
    }
}

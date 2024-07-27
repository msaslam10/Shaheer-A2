public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partThree();
    }

    public void partThree() {
        // Create an employee
        Employee employee = new Employee("John", 35, "101 Theme Park Rd", "E001", "Ride Operator");

        // Create a ride
        Ride rollerCoaster = new Ride("Roller Coaster", 5, true, employee);

        // Create some sample visitors
        Visitor visitor1 = new Visitor("Alice", 25, "123 Wonderland Ave", "V001", "Day Pass");
        Visitor visitor2 = new Visitor("Bob", 30, "456 Nowhere St", "V002", "Season Pass");
        Visitor visitor3 = new Visitor("Charlie", 22, "789 Somewhere Blvd", "V003", "Day Pass");
        Visitor visitor4 = new Visitor("David", 28, "321 Fantasy Rd", "V004", "Day Pass");
        Visitor visitor5 = new Visitor("Eve", 26, "654 Adventure St", "V005", "Season Pass");

        // Add visitors to the queue
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);

        // Print the current queue
        rollerCoaster.printQueue();

        // Remove a visitor from the queue
        rollerCoaster.removeVisitorFromQueue(visitor3);

        // Print the current queue again
        rollerCoaster.printQueue();

        // Run one cycle of the ride
        rollerCoaster.runOneCycle();

        // Print the ride history
        rollerCoaster.printRideHistory();

        // Add visitor to ride history
        rollerCoaster.addVisitorToRideHistory(visitor3);

        // Check if a visitor is in the ride history
        boolean isInHistory = rollerCoaster.isVisitorInRideHistory(visitor3);
        System.out.println("Is visitor Charlie in ride history? " + isInHistory);

        // Get the number of visitors in the ride history
        int numberOfVisitors = rollerCoaster.getNumberOfVisitorsInRideHistory();
        System.out.println("Number of visitors in ride history: " + numberOfVisitors);
    }

    public void partFourA() {
    }

    public void partFourB() {
    }

    public void partFive() {
    }

    public void partSix() {
    }

    public void partSeven() {
    }
}

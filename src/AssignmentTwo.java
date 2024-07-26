public class AssignmentTwo {
    public static void main(String[] args) {
        // Create some sample visitors
        Visitor visitor1 = new Visitor("Alice", 25, "123 Wonderland Ave", "V001", "Day Pass");
        Visitor visitor2 = new Visitor("Bob", 30, "456 Nowhere St", "V002", "Season Pass");
        Visitor visitor3 = new Visitor("Charlie", 22, "789 Somewhere Blvd", "V003", "Day Pass");

        // Create an employee
        Employee employee = new Employee("John", 35, "101 Theme Park Rd", "E001", "Ride Operator");

        // Create a ride
        Ride rollerCoaster = new Ride("Roller Coaster", 5, true, employee);

        // Add visitors to the queue
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);

        // Print the current queue
        rollerCoaster.printQueue();

        // Remove a visitor from the queue
        rollerCoaster.removeVisitorFromQueue(visitor2);

        // Print the current queue again
        rollerCoaster.printQueue();

        // Run one cycle of the ride
        rollerCoaster.runOneCycle();

        // Print the ride history
        rollerCoaster.printRideHistory();
    }

    public void partThree() {
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

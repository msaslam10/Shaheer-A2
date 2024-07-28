public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partSeven();
    }



    public void partSeven() {
        // Create a new ride
        Employee operator = new Employee("John", 35, "101 Theme Park Rd", "E001", "Ride Operator");
        Ride rollerCoaster = new Ride("Roller Coaster", 5, true, operator, 0);

        // Import the ride history from the file
        rollerCoaster.readRideHistoryFromFile("ride_history.csv");

        // Print the number of visitors in the ride history
        System.out.println("Number of visitors in the ride history: " + rollerCoaster.getRideHistorySize());

        // Print all visitors in the ride history
        System.out.println("Visitors in the ride history:");
        for (Visitor visitor : rollerCoaster.getRideHistory()) {
            System.out.println(visitor);
        }
    }
}

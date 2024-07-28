public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partSix();
    }

    public void partSix() {
        Employee employee = new Employee("John", 35, "101 Theme Park Rd", "E001", "Ride Operator");
        Ride rollerCoaster = new Ride("Roller Coaster", 5, true, employee, 0);

        // Add a minimum of 5 visitors to the ride history
        addVisitorsToRide(rollerCoaster);

        // Export ride history to file
        rollerCoaster.writeRideHistoryToFile("ride_history.csv");

        System.out.println("Ride history has been exported to ride_history.csv");
    }

    private void addVisitorsToRide(Ride ride) {
        Visitor visitor1 = new Visitor("Michael", 25, "123 Wonderland Ave", "V001", "Day Pass");
        Visitor visitor2 = new Visitor("Sarah", 30, "456 Nowhere St", "V002", "Season Pass");
        Visitor visitor3 = new Visitor("James", 22, "789 Somewhere Blvd", "V003", "Day Pass");
        Visitor visitor4 = new Visitor("Emily", 28, "321 Fantasy Rd", "V004", "Day Pass");
        Visitor visitor5 = new Visitor("Jessica", 26, "654 Adventure St", "V005", "Season Pass");

        ride.addVisitorToQueue(visitor1);
        ride.addVisitorToQueue(visitor2);
        ride.addVisitorToQueue(visitor3);
        ride.addVisitorToQueue(visitor4);
        ride.addVisitorToQueue(visitor5);

        // Run one cycle to add visitors to ride history
        ride.runOneCycle();
    }
}

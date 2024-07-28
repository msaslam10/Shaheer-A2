public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        assignment.partFive();
    }

    public void partThree() {
        // Implementation for part three
    }

    public void partFourA() {
        // Implementation for part four A
    }

    public void partFourB() {
        // Implementation for part four B
    }

    public void partFive() {
        // Create an employee
        Employee employee = new Employee("John", 35, "101 Theme Park Rd", "E001", "Ride Operator");

        // Create a new ride object
        Ride rollerCoaster = new Ride("Roller Coaster", 5, true, employee, 3);

        // Create some sample visitors
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

        // Add visitors to the queue
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

        // Print all visitors in the queue
        System.out.println("Queue before running one cycle:");
        rollerCoaster.printQueue();

        // Run one cycle of the ride
        rollerCoaster.runOneCycle();

        // Print all visitors in the queue after one cycle is run
        System.out.println("Queue after running one cycle:");
        rollerCoaster.printQueue();

        // Print all visitors in the collection (ride history)
        System.out.println("Ride history after running one cycle:");
        rollerCoaster.printRideHistory();
    }

    public void partSix() {
        // Implementation for part six
    }

    public void partSeven() {
        // Implementation for part seven
    }
}

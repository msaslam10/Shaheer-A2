import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Ride implements RideInterface {
    private String rideName;
    private int maxRiders;
    private boolean isOpen;
    private Employee operator;
    private int numOfCycles;
    private Queue<Visitor> queue;
    private LinkedList<Visitor> rideHistory;

    public Ride() {
        this.queue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    public Ride(String rideName, int maxRiders, boolean isOpen, Employee operator, int numOfCycles) {
        this.rideName = rideName;
        this.maxRiders = maxRiders;
        this.isOpen = isOpen;
        this.operator = operator;
        this.numOfCycles = numOfCycles;
        this.queue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
    }

    // Getters and setters
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }
    public int getMaxRiders() { return maxRiders; }
    public void setMaxRiders(int maxRiders) { this.maxRiders = maxRiders; }
    public boolean isOpen() { return isOpen; }
    public void setOpen(boolean open) { isOpen = open; }
    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }
    public int getNumOfCycles() { return numOfCycles; }
    public void setNumOfCycles(int numOfCycles) { this.numOfCycles = numOfCycles; }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        queue.add(visitor);
        System.out.println(visitor.getName() + " added to the queue.");
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (queue.remove(visitor)) {
            System.out.println(visitor.getName() + " removed from the queue.");
        } else {
            System.out.println(visitor.getName() + " not found in the queue.");
        }
    }

    @Override
    public void printQueue() {
        System.out.println("Visitors in queue:");
        for (Visitor visitor : queue) {
            System.out.println(visitor);
        }
    }

    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("Cannot run the ride without an operator.");
            return;
        }
        if (queue.isEmpty()) {
            System.out.println("No visitors in queue to run the ride.");
            return;
        }

        int riders = Math.min(maxRiders, queue.size());
        for (int i = 0; i < riders; i++) {
            Visitor visitor = queue.poll();
            rideHistory.add(visitor);
            System.out.println(visitor.getName() + " is taking the ride.");
        }
        numOfCycles++;
    }

    @Override
    public void printRideHistory() {
        System.out.println("Ride history:");
        for (Visitor visitor : rideHistory) {
            System.out.println(visitor);
        }
    }

    @Override
    public void writeRideHistoryToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.toString());
                writer.newLine();
            }
            System.out.println("Ride history written to file: " + filename);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public void addVisitorToRideHistory(Visitor visitor) {
        rideHistory.add(visitor);
    }
}

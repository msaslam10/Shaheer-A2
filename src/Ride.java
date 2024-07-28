import java.io.*;
import java.util.*;

public class Ride implements RideInterface {
    private String name;
    private int maxRider;
    private boolean isOpen;
    private Employee rideOperator;
    private int numOfCycles;
    private Queue<Visitor> queue;
    private List<Visitor> rideHistory;

    public Ride(String name, int maxRider, boolean isOpen, Employee rideOperator, int numOfCycles) {
        this.name = name;
        this.maxRider = maxRider;
        this.isOpen = isOpen;
        this.rideOperator = rideOperator;
        this.numOfCycles = numOfCycles;
        this.queue = new LinkedList<>();
        this.rideHistory = new ArrayList<>();
    }

    // Implementing RideInterface methods
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        queue.add(visitor);
        System.out.println("Visitor " + visitor.getName() + " has been added to the queue.");
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (queue.remove(visitor)) {
            System.out.println("Visitor " + visitor.getName() + " has been removed from the queue.");
        } else {
            System.out.println("Visitor " + visitor.getName() + " is not in the queue.");
        }
    }

    @Override
    public void printQueue() {
        if (queue.isEmpty()) {
            System.out.println("The queue is empty.");
            return;
        }
        for (Visitor visitor : queue) {
            System.out.println("Visitor Name: " + visitor.getName() + ", Age: " + visitor.getAge() + ", Address: " + visitor.getAddress());
        }
    }

    @Override
    public void runOneCycle() {
        if (!isOpen) {
            System.out.println("Ride is not open. Cannot run the ride.");
            return;
        }
        if (queue.isEmpty()) {
            System.out.println("No visitors in the queue. Cannot run the ride.");
            return;
        }
        int riders = Math.min(maxRider, queue.size());
        for (int i = 0; i < riders; i++) {
            Visitor visitor = queue.poll();
            rideHistory.add(visitor);
            System.out.println("Visitor " + visitor.getName() + " has taken the ride.");
        }
        numOfCycles++;
        System.out.println("Ride cycle completed. Number of cycles run: " + numOfCycles);
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors have taken the ride yet.");
            return;
        }
        for (Visitor visitor : rideHistory) {
            System.out.println("Visitor Name: " + visitor.getName() + ", Age: " + visitor.getAge() + ", Address: " + visitor.getAddress());
        }
    }

    public void writeRideHistoryToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.getName() + "," + visitor.getAge() + "," + visitor.getAddress());
                writer.newLine();
            }
            System.out.println("Ride history written to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        this.maxRider = maxRider;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public Employee getRideOperator() {
        return rideOperator;
    }

    public void setRideOperator(Employee rideOperator) {
        this.rideOperator = rideOperator;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    public void setNumOfCycles(int numOfCycles) {
        this.numOfCycles = numOfCycles;
    }
}

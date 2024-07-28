import java.io.*;
import java.util.*;

public class Ride implements RideInterface {
    private String rideName;
    private int maxRiders;
    private boolean isOpen;
    private Employee operator;
    private int numOfCycles;
    private Queue<Visitor> queue;
    private LinkedList<Visitor> rideHistory;

    public Ride() {
        this.rideName = "";
        this.maxRiders = 0;
        this.isOpen = false;
        this.operator = null;
        this.numOfCycles = 0;
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

    // Getters and setters...

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

    public void readRideHistoryFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 5) {
                    Visitor visitor = new Visitor(details[0], Integer.parseInt(details[1]), details[2], details[3], details[4]);
                    rideHistory.add(visitor);
                }
            }
            System.out.println("Ride history read from file: " + filename);
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

    public int getRideHistorySize() {
        return rideHistory.size();
    }

    public LinkedList<Visitor> getRideHistory() {
        return rideHistory;
    }
}

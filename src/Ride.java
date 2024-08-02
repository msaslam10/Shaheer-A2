import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Collections;
import java.util.Comparator;

public class Ride implements RideInterface {
    private String rideName;
    private int capacity;
    private boolean isOpen;
    private Employee operator;
    private Queue<Visitor> queue;
    private List<Visitor> rideHistory;
    private final Lock queueLock = new ReentrantLock();
    private final Lock historyLock = new ReentrantLock();

    // Default constructor
    public Ride() {
        this.queue = new LinkedList<>();
        this.rideHistory = new ArrayList<>();
    }

    // Parameterized constructor
    public Ride(String rideName, int capacity, boolean isOpen, Employee operator) {
        this.rideName = rideName;
        this.capacity = capacity;
        this.isOpen = isOpen;
        this.operator = operator;
        this.queue = new LinkedList<>();
        this.rideHistory = new ArrayList<>();
    }

    // Getters and setters
    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    // Method to assign an Employee to operate the ride
    public void assignOperator(Employee operator) {
        this.operator = operator;
        this.isOpen = (operator != null);
    }

    // Interface methods implementation
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        queueLock.lock();
        try {
            if (queue.add(visitor)) {
                System.out.println("Visitor " + visitor.getName() + " has been added to the queue.");
            } else {
                System.out.println("Failed to add Visitor " + visitor.getName() + " to the queue.");
            }
        } finally {
            queueLock.unlock();
        }
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        queueLock.lock();
        try {
            if (queue.remove(visitor)) {
                System.out.println("Visitor " + visitor.getName() + " has been removed from the queue.");
            } else {
                System.out.println("Failed to remove Visitor " + visitor.getName() + " from the queue.");
            }
        } finally {
            queueLock.unlock();
        }
    }

    @Override
    public void printQueue() {
        queueLock.lock();
        try {
            if (queue.isEmpty()) {
                System.out.println("The queue is empty.");
            } else {
                System.out.println("Current queue:");
                for (Visitor visitor : queue) {
                    System.out.println("Visitor Name: " + visitor.getName() + ", Age: " + visitor.getAge() + ", Address: " + visitor.getAddress());
                }
            }
        } finally {
            queueLock.unlock();
        }
    }

    @Override
    public void runOneCycle() {
        queueLock.lock();
        historyLock.lock();
        try {
            int rideCount = Math.min(queue.size(), capacity);
            for (int i = 0; i < rideCount; i++) {
                Visitor visitor = queue.poll();
                if (visitor != null) {
                    rideHistory.add(visitor);
                }
            }
        } finally {
            queueLock.unlock();
            historyLock.unlock();
        }
    }

    @Override
    public void printRideHistory() {
        historyLock.lock();
        try {
            if (rideHistory.isEmpty()) {
                System.out.println("No visitors have taken the ride yet.");
            } else {
                System.out.println("Ride history:");
                for (Visitor visitor : rideHistory) {
                    System.out.println("Visitor Name: " + visitor.getName() + ", Age: " + visitor.getAge() + ", Address: " + visitor.getAddress());
                }
            }
        } finally {
            historyLock.unlock();
        }
    }

    // Additional methods for managing the collection
    public void addVisitorToRideHistory(Visitor visitor) {
        historyLock.lock();
        try {
            if (rideHistory.add(visitor)) {
                System.out.println("Visitor " + visitor.getName() + " has been added to the ride history.");
            } else {
                System.out.println("Failed to add Visitor " + visitor.getName() + " to the ride history.");
            }
        } finally {
            historyLock.unlock();
        }
    }

    public boolean isVisitorInRideHistory(Visitor visitor) {
        historyLock.lock();
        try {
            return rideHistory.contains(visitor);
        } finally {
            historyLock.unlock();
        }
    }

    public int getNumberOfVisitorsInRideHistory() {
        historyLock.lock();
        try {
            return rideHistory.size();
        } finally {
            historyLock.unlock();
        }
    }

    // Method to sort the ride history using a comparator
    public void sortRideHistory(Comparator<Visitor> comparator) {
        historyLock.lock();
        try {
            Collections.sort(rideHistory, comparator);
            System.out.println("Ride history sorted.");
        } finally {
            historyLock.unlock();
        }
    }

    public void writeRideHistoryToFile(String filename) {
        historyLock.lock();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.getName() + "," + visitor.getAge() + "," + visitor.getAddress());
                writer.newLine();
            }
            System.out.println("Ride history written to " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            System.err.println("Error writing to file: " + e.getMessage());
        } finally {
            historyLock.unlock();
        }

    }
    public void readRideHistoryFromFile(String filename) {
        historyLock.lock();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String address = parts[2];
                    // Create a new Visitor object from the read data
                    Visitor visitor = new Visitor(name, age, address, "dummyID", "dummyPass"); // Assuming Visitor constructor as per previous code
                    rideHistory.add(visitor);
                }
            }
            System.out.println("Ride history read from " + filename);
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
            System.err.println("Error reading from file: " + e.getMessage());
        } finally {
            historyLock.unlock();
        }
    }
}

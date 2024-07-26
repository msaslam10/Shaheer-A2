import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class Ride implements RideInterface {
    private String rideName;
    private int capacity;
    private boolean isOpen;
    private Employee operator;
    private Queue<Visitor> queue;
    private List<Visitor> rideHistory;

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
        if (queue.add(visitor)) {
            System.out.println("Visitor " + visitor.getName() + " has been added to the queue.");
        } else {
            System.out.println("Failed to add Visitor " + visitor.getName() + " to the queue.");
        }
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (queue.remove(visitor)) {
            System.out.println("Visitor " + visitor.getName() + " has been removed from the queue.");
        } else {
            System.out.println("Failed to remove Visitor " + visitor.getName() + " from the queue.");
        }
    }

    @Override
    public void printQueue() {
        if (queue.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            System.out.println("Current queue:");
            for (Visitor visitor : queue) {
                System.out.println("Visitor Name: " + visitor.getName() + ", Age: " + visitor.getAge() + ", Address: " + visitor.getAddress());
            }
        }
    }

    @Override
    public void runOneCycle() {
        int rideCount = Math.min(queue.size(), capacity);
        for (int i = 0; i < rideCount; i++) {
            Visitor visitor = queue.poll();
            if (visitor != null) {
                rideHistory.add(visitor);
            }
        }
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors have taken the ride yet.");
        } else {
            System.out.println("Ride history:");
            for (Visitor visitor : rideHistory) {
                System.out.println("Visitor Name: " + visitor.getName() + ", Age: " + visitor.getAge() + ", Address: " + visitor.getAddress());
            }
        }
    }
}

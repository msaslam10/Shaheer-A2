public class Visitor extends Person {
    private String visitorID;
    private String ticketType;

    public Visitor() {}

    public Visitor(String name, int age, String address, String visitorID, String ticketType) {
        super(name, age, address);
        this.visitorID = visitorID;
        this.ticketType = ticketType;
    }

    // Getters and setters
    public String getVisitorID() { return visitorID; }
    public void setVisitorID(String visitorID) { this.visitorID = visitorID; }
    public String getTicketType() { return ticketType; }
    public void setTicketType(String ticketType) { this.ticketType = ticketType; }

    @Override
    public String toString() {
        return super.toString() + "," + visitorID + "," + ticketType;
    }
}

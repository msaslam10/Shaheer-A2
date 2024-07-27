public class Visitor extends Person {
    private String visitorId;
    private String passType;

    // Default constructor
    public Visitor() {
        super();
    }

    // Parameterized constructor
    public Visitor(String name, int age, String address, String visitorId, String passType) {
        super(name, age, address);
        this.visitorId = visitorId;
        this.passType = passType;
    }

    // Getters and setters
    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getPassType() {
        return passType;
    }

    public void setPassType(String passType) {
        this.passType = passType;
    }
}

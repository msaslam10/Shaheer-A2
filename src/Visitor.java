public class Visitor {
    private String name;
    private int age;
    private String address;
    private String visitorID;
    private String passType;

    // Constructor
    public Visitor(String name, int age, String address, String visitorID, String passType) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.visitorID = visitorID;
        this.passType = passType;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getVisitorID() {
        return visitorID;
    }

    public String getPassType() {
        return passType;
    }

    // Method to introduce the visitor
    public void introduce() {
        System.out.println("Visitor Name: " + name + ", Age: " + age + ", Address: " + address + ", Visitor ID: " + visitorID + ", Pass Type: " + passType);
    }

    @Override
    public String toString() {
        return name + "," + age + "," + address + "," + visitorID + "," + passType;
    }
}

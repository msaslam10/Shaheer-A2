public class Employee {
    private String name;
    private int age;
    private String address;
    private String id;
    private String position;

    public Employee(String name, int age, String address, String id, String position) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.id = id;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }
}

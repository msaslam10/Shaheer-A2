public class Employee extends Person {
    private String employeeID;
    private String jobTitle;

    public Employee() {}

    public Employee(String name, int age, String address, String employeeID, String jobTitle) {
        super(name, age, address);
        this.employeeID = employeeID;
        this.jobTitle = jobTitle;
    }

    // Getters and setters
    public String getEmployeeID() { return employeeID; }
    public void setEmployeeID(String employeeID) { this.employeeID = employeeID; }
    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    @Override
    public String toString() {
        return super.toString() + "," + employeeID + "," + jobTitle;
    }
}

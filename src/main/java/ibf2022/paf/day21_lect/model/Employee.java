package ibf2022.paf.day21_lect.model;

public class Employee {
    
    // Below shows the linking of auto-mapping of name in java to SQL.
    // firstName (Entity)  --> first_name (SQL)
    private int Id;
    private String firstName;
    private String lastName;
    private float salary;

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public float getSalary() {
        return salary;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }
    
    
    @Override
    public String toString(){
        return "ID: %d, Full Name: %s %s, Salary: %f".formatted(Id, firstName, lastName, salary);
    }


}


package ibf2022.paf.day21_lect.model;

import java.util.List;

public class Employee {
    private Integer id;

    // firstName (Entity) --> first_name (mySQL)
    // firstname (Entity) --> firstname (mySQL)
    private String firstName;

    private String lastName;

    private Integer salary;

    private List<Dependant> dependants;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public List<Dependant> getDependants() {
        return dependants;
    }

    public void setDependants(List<Dependant> dependants) {
        this.dependants = dependants;
    }

    
    
    
}

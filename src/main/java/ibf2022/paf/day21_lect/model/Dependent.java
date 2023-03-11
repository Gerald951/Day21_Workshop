package ibf2022.paf.day21_lect.model;

import java.sql.Date;

public class Dependent {
   
    private int Id;
    private int employeeId;
    private String fullName;
    private String relationship;
    private Date birthDate;

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullname) {
        this.fullName = fullname;
    }
    public String getRelationship() {
        return relationship;
    }
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString(){
        return "Dependent ID: %d for Employee: %d %s, as %s. Birthday: %te %tb %tY".formatted(Id,employeeId, fullName, relationship, birthDate);
    }

}

package models;

import enums.StudentRole;

public class Student extends User {
    private Camp committeeStatus;
    private List<Camp> registeredCamps = new ArrayList<>();
    private List<Enquiry> enquiries= new ArrayList<>();

    public Student (String name, String userID, String email, String faculty, String password, StudentRole studentRole) {
        super(name, userID, email, faculty, password, studentRole);
    }
    public String getCommitteeStatus() {return this.committeeStatus;}
    public void setCommitteeStatus(Camp camp) {this.committeeStatus = camp;}
    public List<Camp> getRegisteredCamps() {return this.registeredCamps;}
    public List<Enquiry> getEnquiries() {return this.enquiries;}
}

package view.tm;

public class StudentTM {
    private String student_Id;
    private String student_name;
    private String email;
    private String contact;
    private String address;
    private String nic;

    public StudentTM() {
    }

    public StudentTM(String student_Id, String student_name, String email, String contact, String address, String nic) {
        this.setStudent_Id(student_Id);
        this.setStudent_name(student_name);
        this.setEmail(email);
        this.setContact(contact);
        this.setAddress(address);
        this.setNic(nic);
    }

    public String getStudent_Id() {
        return student_Id;
    }

    public void setStudent_Id(String student_Id) {
        this.student_Id = student_Id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    @Override
    public String toString() {
        return "StudentTM{" +
                "student_Id='" + student_Id + '\'' +
                ", student_name='" + student_name + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                ", nic='" + nic + '\'' +
                '}';
    }
}

package pom.testdata;

import utils.Reader;

public class Contact {

    private String firstName;
    private String lastName;
    private String email;
    private String country;

    public Contact(String fileName) {
        this.firstName = Reader.json(fileName).get("firstName").toString();
        this.lastName =  Reader.json(fileName).get("lastName").toString();
        this.email =  Reader.json(fileName).get("email").toString();
        this.country =  Reader.json(fileName).get("country").toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

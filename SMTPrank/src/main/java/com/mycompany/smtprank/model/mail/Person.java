package com.mycompany.smtprank.model.mail;

/**
 *
 * @author crab_one
 */
public class Person {
    private String firstname;
    private String lastname;
    private String address;
    
    public Person(String address) {
        this(new String(), new String(), address);
    }

    public Person(String firstname, String lastname, String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

package com.mycompany.smtprank.model.prank;

import com.mycompany.smtprank.model.mail.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author crab_one
 */
public class Prank {
    private Person author;
    private List<Person> victims;
    private String subject;
    private String message;

    public Prank(Person author, List<Person> victims, String subject, String message) {
        this.author = author;
        this.victims = victims;
        this.subject = subject;
        this.message = message;
    }
    
    public void addAllVictims(List<Person> persons) {
        victims.addAll(victims);
    }
    
    public void addVictims(Person person) {
        victims.add(person);
    }

    public Person getAuthor() {
        return author;
    }

    public List<Person> getVictims() {
        return new ArrayList<>(victims);
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

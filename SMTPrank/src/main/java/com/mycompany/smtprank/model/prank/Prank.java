package com.mycompany.smtprank.model.prank;

import com.mycompany.smtprank.model.mail.Message;
import com.mycompany.smtprank.model.mail.Person;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe modélisant une plaisanterie.
 * 
 * @author crab_one
 */
public class Prank {
    private Person author;
    private List<Person> victims;
    private String subject;
    private String content;

    public Prank(Person author, List<Person> victims, String subject, String content) {
        this.author = author;
        this.victims = victims;
        this.subject = subject;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public Message generateMessage() {
        Message message = new Message();
        
        message.setFrom(author.getAddress());
        
        for (Person victim : victims) {
            message.addTo(victim.getAddress());
        }
        
        message.setSubject(subject);
        message.setContent(content + "\r\n" + author.getFirstname());
        
        return message;
    }
}

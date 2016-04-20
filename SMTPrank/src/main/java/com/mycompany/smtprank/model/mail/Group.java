package com.mycompany.smtprank.model.mail;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe modélisant un groupe de personnes.
 * 
 * @author crab_one
 */
public class Group {
    private final List<Person> members;

    public Group() {
        members = new ArrayList<>();
    }

    public Group(List<Person> members) {
        this.members = members;
    }
        
    public void addMember(Person person) {
        members.add(person);
    }
    
    public void addAllMembers(List<Person> persons) {
        members.addAll(persons);
    }

    public List<Person> getMembers() {
        return new ArrayList<>(members);
    }    
}

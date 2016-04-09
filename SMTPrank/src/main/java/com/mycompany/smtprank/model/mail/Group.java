package com.mycompany.smtprank.model.mail;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author crab_one
 */
public class Group {
    private final List<Person> members;

    public Group() {
        members = new ArrayList<>();
    }
    
    public void addMember(Person person) {
        members.add(person);
    }

    public List<Person> getMembers() {
        return new ArrayList<>(members);
    }    
}

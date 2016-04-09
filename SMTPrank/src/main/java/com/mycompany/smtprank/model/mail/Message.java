package com.mycompany.smtprank.model.mail;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author crab_one
 */
public class Message {
    
    private String from;
    private final List<String> to;
    private final List<String> cc;
    private final List<String> bcc;
    private String subject;
    private String content;

    public Message() {
        to = new ArrayList<>();
        cc = new ArrayList<>();
        bcc = new ArrayList<>();
    }
    
    public void addTo(String address) {
        to.add(address);
    }
    
    public void addCc(String address) {
        cc.add(address);
    }
    
    public void addBcc(String address) {
        bcc.add(address);
    }

    public String getFrom() {
        return from;
    }

    public List<String> getTo() {
        return new ArrayList<>(to);
    }

    public List<String> getCc() {
        return new ArrayList<>(cc);
    }

    public List<String> getBcc() {
        return new ArrayList<>(bcc);
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

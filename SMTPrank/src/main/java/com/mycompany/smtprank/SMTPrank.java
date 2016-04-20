package com.mycompany.smtprank;

import com.mycompany.smtprank.config.ConfigurationManager;
import com.mycompany.smtprank.model.mail.Group;
import com.mycompany.smtprank.model.mail.Message;
import com.mycompany.smtprank.model.mail.Person;
import com.mycompany.smtprank.model.prank.Prank;
import com.mycompany.smtprank.model.prank.PrankGenerator;
import com.mycompany.smtprank.smtp.SmtpClient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author crab_one
 */
public class SMTPrank {

    private static final Logger LOG = Logger.getLogger(SMTPrank.class.getName());
    
    public static void main(String[] args) throws IOException {
        ConfigurationManager cm = new ConfigurationManager();
        PrankGenerator pg = new PrankGenerator(cm);
        SmtpClient client = new SmtpClient(cm.getSmtpServerAddress(), cm.getSmtpServerPort());
        
        List<Person> victims = new ArrayList<>();
        List<Group> groups;
        List<Prank> pranks;
        List<String> rawVictims = cm.loadVictimsFromFile();
        Message message;
        
        for (String rawVictim : rawVictims) {
            victims.add(new Person(rawVictim));
        }
        
        groups = pg.generateGroups(victims, cm.getNumberOfGroups(), cm.getMinVictimsInGroups());
        pranks = pg.generatePranks(groups);

        client.connect();
        
        for (Prank prank : pranks) {
            message = prank.generateMessage();
            client.sendMessage(message);
        }
        
        client.disconnect();
    }
}

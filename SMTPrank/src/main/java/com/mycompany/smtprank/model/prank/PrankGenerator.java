package com.mycompany.smtprank.model.prank;

import com.mycompany.smtprank.config.ConfigurationManager;
import com.mycompany.smtprank.config.IConfigurationManager;
import com.mycompany.smtprank.model.mail.Group;
import com.mycompany.smtprank.model.mail.Person;
import java.util.List;

/**
 *
 * @author crab_one
 */
public class PrankGenerator {
    private IConfigurationManager configurationManager;

    public PrankGenerator(IConfigurationManager configurationManager) {
        this.configurationManager = configurationManager;
    }
    
    public List<Group> generateGroups(List<Person> victims, int numberOfGroups) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public List<Prank> generatePranks() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

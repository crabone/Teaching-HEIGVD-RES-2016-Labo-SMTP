package com.mycompany.smtprank.model.prank;

import com.mycompany.smtprank.model.mail.Group;
import com.mycompany.smtprank.model.mail.Person;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author crab_one
 */
public class PrankGenerator {
    
    static final Logger LOG = Logger.getLogger(PrankGenerator.class.getName());
    
    public List<Group> generateGroups(List<Person> victims, int numberOfGroups, int minVictimsInGroups) {
        if (victims == null) {
            LOG.log(Level.SEVERE, "Victims parameter should not be null");
            throw new NullPointerException();
        }
        else {
            int totalVictims = victims.size(); //Attention nullPOinterException
            int minGroupSize = totalVictims / numberOfGroups;

            if (numberOfGroups < 1) {
                LOG.log(Level.SEVERE, "There must be at least one group to generate.");
                throw new RuntimeException();
            }
            else if (minVictimsInGroups < 2) {
                LOG.log(Level.SEVERE, "A groups must be at least composed with 2 victims");
                throw new UnsupportedOperationException();
            }
            else if (minGroupSize < minVictimsInGroups) {
                LOG.log(Level.SEVERE, "No sufficients amount of victims for the actual configuration");
                throw new UnsupportedOperationException();
            }
            else {
                List<Person> availableVictims = new ArrayList<>(victims);
                List<Group> groups = new ArrayList<>(numberOfGroups);
                int totalOfAvailableVictims = availableVictims.size();
                int turn = 0;
                Person victim;

                for (int i = 0; i < numberOfGroups; ++i) {
                    groups.add(new Group());
                }

                Collections.shuffle(availableVictims);

                do {
                    victim = availableVictims.remove(0);
                    groups.get(turn).addMember(victim);
                    turn = (turn + 1) % numberOfGroups;
                } while (--totalOfAvailableVictims != 0);

                return new ArrayList<>(groups);
            }
        }
    }
    
    public List<Prank> generatePranks() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

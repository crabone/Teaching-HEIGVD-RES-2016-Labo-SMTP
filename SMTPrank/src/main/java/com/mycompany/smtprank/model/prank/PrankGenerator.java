package com.mycompany.smtprank.model.prank;

import com.mycompany.smtprank.Utils;
import com.mycompany.smtprank.config.ConfigurationManager;
import com.mycompany.smtprank.model.mail.Group;
import com.mycompany.smtprank.model.mail.Person;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe permettant la génération de plaisanteries et de groupes.
 * 
 * @author crab_one
 */
public class PrankGenerator {
    
    static final Logger LOG = Logger.getLogger(PrankGenerator.class.getName());
    private ConfigurationManager configurationManager;

    public PrankGenerator(ConfigurationManager configurationManager) {
        this.configurationManager = configurationManager;
    }
    
    public List<Group> generateGroups(List<Person> victims, int numberOfGroups, int minVictimsInGroups) {
        if (victims == null) {
            LOG.log(Level.SEVERE, "Victims parameter should not be null");
            throw new NullPointerException();
        }
        else {
            int totalVictims = victims.size();
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
    
    public Prank generatePrank(Group group, String rawPrank) {
        Person sender;
        List<Person> victims;
        Prank prank;
        String[] content = new String[2];
        
        victims = group.getMembers();
        sender = victims.remove(0);
        
        /*
        Le contenu d'une plaisanterie est découpée en 2 sections distinctes, la première (sur une ligne)
        représente le sujet, et la seconde représente le contenu.
        */
        content = Utils.getNextLine(rawPrank);
        
        /*
        On désire prendre le sujet du message sans le préfixe "Subject: ".
        */
        prank = new Prank(sender, victims, content[0].substring(9, content[0].length()), content[1]);
        
        return prank;
    }
    
    public List<Prank> generatePranks(List<Group> groups) throws IOException {
        Random random = new Random();
        List<Prank> pranks = new ArrayList<>();
        Prank prank;

        List<String> messages = configurationManager.loadRawPranksFromFile();
        
        for (Group group : groups) {
            prank = generatePrank(group, messages.get(0)); // To change
            pranks.add(prank);
        }

        return new ArrayList<>(pranks);
    }
}

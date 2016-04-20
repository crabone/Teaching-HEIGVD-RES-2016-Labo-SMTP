package com.mycompany.smtprank.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe permettant la configuration de l'application SMTPrank.
 * 
 * @author crab_one
 */
public class ConfigurationManager implements IConfigurationManager {
    
    static final Logger LOG = Logger.getLogger(ConfigurationManager.class.getName());
    static final String CONFIG_DIRECTORY = "./config/";
    static final String DEFAULT_CONFIG = "default.cfg";
    
    private Properties defaultProperties;
    private Properties properties;
    
    public ConfigurationManager() throws IOException {
        File defaultFile = new File(CONFIG_DIRECTORY + DEFAULT_CONFIG);
        
        defaultProperties = new Properties();
        properties = new Properties();
        
        if (!defaultFile.isFile()) {
            LOG.log(Level.SEVERE, "Unable to open default configuration file.");
            throw new FileNotFoundException();
        }
        else {
            Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(defaultFile)));
            defaultProperties.load(reader);
            reader.close();
            
            properties = (Properties) defaultProperties.clone();
        }
    }
    
    public ConfigurationManager(String filename) throws IOException {
        this();
        File file = new File(CONFIG_DIRECTORY + filename);
        
        if (!file.isFile()) {
            LOG.log(Level.SEVERE, "Unable to open configuration file.");
            throw new FileNotFoundException();
        }
        else {
            Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            properties.load(reader);
            reader.close();
        }
    }
    
    public String getSmtpServerAddress() {
        return properties.getProperty("smtpServerAddress");
    }
    
    public int getSmtpServerPort() {
        return Integer.parseInt(properties.getProperty("smtpServerPort"));
    }

    public int getNumberOfGroups() {
        return Integer.parseInt(properties.getProperty("numberOfGroups"));
    }

    public int getMinVictimsInGroups() {
        return Integer.parseInt(properties.getProperty("minVictimsInGroups"));
    }
    
    public String getPathToVictims() {
        return properties.getProperty("pathToVictims");
    }
    
    public String getPathToPranks() {
        return properties.getProperty("pathToPranks");
    }
    
    public List<String> loadVictimsFromFile() throws IOException {
        return loadVictimsFromFile(getPathToVictims());
    }
    
    public List<String> loadVictimsFromFile(String filename) throws IOException {
        File file = new File(filename);
        
        if (!file.isFile()) {
            LOG.log(Level.SEVERE, "Unable to open victims file.");
            throw new FileNotFoundException();
        }
        else {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            List<String> victims = new ArrayList<>();
            
            while ((line = reader.readLine()) != null) {
                victims.add(line);
            }
            
            return victims;
        }
    }
    
    public List<String> loadRawPranksFromFile() throws IOException {
        return loadRawPranksFromFile(getPathToPranks());
    }
    
    public List<String> loadRawPranksFromFile(String filename) throws IOException {
        File file = new File(filename);
        
        if (!file.isFile()) {
            LOG.log(Level.SEVERE, "Unable to open pranks file.");
            throw new FileNotFoundException();
        }
        else {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            List<String> rawPranks = new ArrayList<>();
            String rawPrank = new String();
            
            while ((line = reader.readLine()) != null) {
                if (line.contains("===")) {
                    rawPranks.add(rawPrank);
                    rawPrank = new String();
                }
                else {
                    rawPrank += line + "\r\n";
                }
            }
            rawPranks.add(rawPrank);
            
            return rawPranks;
        }
    }
}

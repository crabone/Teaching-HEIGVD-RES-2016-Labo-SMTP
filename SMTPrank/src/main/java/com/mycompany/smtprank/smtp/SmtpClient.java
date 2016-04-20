package com.mycompany.smtprank.smtp;

import com.mycompany.smtprank.filters.CRLFFilterWriter;
import com.mycompany.smtprank.model.mail.Message;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author crab_one
 */
public class SmtpClient implements ISmtpClient {

    private static final Logger LOG = Logger.getLogger(SmtpClient.class.getName());
    
    private String smtpServerHost;
    private int smtpServerPort;
    private boolean connected = false;
    private Socket socket;
    private BufferedReader reader;
    private CRLFFilterWriter writer;

    public SmtpClient() {
        smtpServerHost = "127.0.0.1";
        smtpServerPort = SmtpProtocol.SMTP_DEFAULT_PORT;
    }

    public SmtpClient(String smtpServerHost, int smtpServerPort) {
        this.smtpServerHost = smtpServerHost;
        this.smtpServerPort = smtpServerPort;
    }
    
    public void connect() throws IOException {
        connect(smtpServerHost, smtpServerPort);
    }

    @Override
    public void connect(String serverHost, int serverPort) throws IOException {
        try {
            socket = new Socket(serverHost, serverPort);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new CRLFFilterWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
            connected = true;
            
            LOG.info(reader.readLine());
        } catch (IOException ex) {
            Logger.getLogger(SmtpClient.class.getName()).log(Level.SEVERE, null, ex);
            cleanup();
            return;
        }
        
        writer.write(SmtpProtocol.CMD_HELO + " " + serverHost + SmtpProtocol.CRLF);
        writer.flush();
        LOG.info(reader.readLine());
    }

    @Override
    public void disconnect() throws IOException {
        connected = false;
        writer.write(SmtpProtocol.CMD_QUIT + SmtpProtocol.CRLF);
        writer.flush();
        LOG.info(reader.readLine());
        cleanup();
    }

    @Override
    public void cleanup() throws IOException {
        if (reader != null) {
            reader.close();
        }
        
        if (writer != null) {
            writer.close();
        }
        
        if (socket != null) {
            socket.close();
        }
    }
    
    @Override
    public void sendMessage(Message message) throws IOException {
        writer.write(SmtpProtocol.CMD_MAIL + " FROM:<" + message.getFrom() + ">" + SmtpProtocol.CRLF);
        writer.flush();
        LOG.info(reader.readLine());
        
        for (String to : message.getTo()) {
            writer.write(SmtpProtocol.CMD_RCPT + " TO:<" + to + ">" + SmtpProtocol.CRLF);
            writer.flush();
            LOG.info(reader.readLine());
        }
        
        for (String cc : message.getCc()) {
            writer.write(SmtpProtocol.CMD_RCPT + " CC:<" + cc + ">" + SmtpProtocol.CRLF);
            writer.flush();
            LOG.info(reader.readLine());
        }
        
        writer.write(SmtpProtocol.CMD_DATA + SmtpProtocol.CRLF);
        writer.flush();
        LOG.info(reader.readLine());
        
        writer.write("From: " + message.getFrom() + SmtpProtocol.CRLF);
        writer.flush();
        
        writer.write("Subject: " + message.getSubject() + SmtpProtocol.CRLF);
        writer.flush();
        
        writer.write(SmtpProtocol.CRLF);
        writer.flush();
        
        writer.write(message.getContent());
        writer.flush();
        
        writer.write(SmtpProtocol.CRLF + "." + SmtpProtocol.CRLF);
        writer.flush();
        LOG.info(reader.readLine());
    }

    public String getSmtpServerHost() {
        return smtpServerHost;
    }

    public int getSmtpServerPort() {
        return smtpServerPort;
    }

    public void setSmtpServerHost(String smtpServerHost) {
        this.smtpServerHost = smtpServerHost;
    }

    public void setSmtpServerPort(int smtpServerPort) {
        this.smtpServerPort = smtpServerPort;
    }
    
}

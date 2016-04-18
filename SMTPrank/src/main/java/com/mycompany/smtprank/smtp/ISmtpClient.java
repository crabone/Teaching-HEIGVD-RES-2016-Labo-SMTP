package com.mycompany.smtprank.smtp;

import com.mycompany.smtprank.model.mail.Message;
import java.io.IOException;

/**
 *
 * @author crab_one
 */
public interface ISmtpClient {
    
    public void connect(String serverAddress, int serverPort) throws IOException;
    public void disconnect() throws IOException;
    public void cleanup() throws IOException;
    public void sendMessage(Message message) throws IOException;
    
}

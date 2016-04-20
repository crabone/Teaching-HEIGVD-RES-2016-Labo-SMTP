package com.mycompany.smtprank.smtp;

/**
 * Cette classe contient les commandes licites du
 * protocole SMTP.
 * 
 * @author crab_one
 */
public class SmtpProtocol {
    public static final int SMTP_DEFAULT_PORT = 25;
    
    public static final String CMD_HELO = "HELO";
    public static final String CMD_MAIL = "MAIL";
    public static final String CMD_RCPT = "RCPT";
    public static final String CMD_DATA = "DATA";
    public static final String CMD_RESET = "RSET";
    public static final String CMD_NOOP = "NOOP";
    public static final String CMD_QUIT = "QUIT";
    
    public static final String CRLF = "\r\n";
}

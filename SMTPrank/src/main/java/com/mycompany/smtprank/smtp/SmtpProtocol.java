/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.smtprank.smtp;

/**
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

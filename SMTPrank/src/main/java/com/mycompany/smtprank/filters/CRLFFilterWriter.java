package com.mycompany.smtprank.filters;

import com.mycompany.smtprank.Utils;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * Cette classe permet de convertir tout les retours à la ligne
 * d'un writer en CRLF.
 * 
 * @author crab_one
 */
public class CRLFFilterWriter extends FilterWriter {
    
    private int previousChar;

    public CRLFFilterWriter(Writer out) {
        super(out);
    }
    
    @Override
    public void write(String str, int off, int len) throws IOException {
        String[] lines = new String[2];
        String result = new String();
        
        lines[1] = str.substring(off, off + len);
        
        do {
            lines = Utils.getNextLine(lines[1]);
            
            if (lines[0].equals("")) {
                result += lines[1];
                break;
            }
            else {
                if (!lines[0].contains("\r\n")) {
                    lines[0] = lines[0].substring(0, lines[0].length() - 1) + "\r\n";
                }
                result += lines[0];
            }
            
        } while (!lines[0].equals(""));
        
        super.write(result, 0, result.length());
    }
    
    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        write(new String(cbuf), off, len);
    }
    
    @Override
    public void write(int c) throws IOException {
        if (c == '\r') {
            previousChar = '\r';
            return;
        }
        else if (c == '\n' && previousChar == '\r') {
            previousChar = c;
            write("\r\n", 0, 2);
            return;
        }
        else if (c != '\n' && previousChar == '\r') {
            previousChar = c;
            write(new String(Character.toChars('\r')), 0, 1);
        }

        write(new String(Character.toChars(c)), 0, 1);
    }
}

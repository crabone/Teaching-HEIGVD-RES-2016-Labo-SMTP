package com.mycompany.smtprank.filters;

import com.mycompany.smtprank.Utils;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

/**
 *
 * @author crab_one
 */
public class DoubleBeginingDotsFilterWriter extends FilterWriter {
    
    private int previousChar;
    private boolean newline; // Indique si on se trouve au début d'une ligne

    public DoubleBeginingDotsFilterWriter(Writer out) {
        super(out);
        newline = true;
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        String[] lines = new String[2];
        String result = new String();
        
        lines[1] = str.substring(off, off + len);
        
        do {
            lines = Utils.getNextLine(lines[1]);
            
            if (lines[0].equals("")) {
                lines[0] = lines[1];
                lines[1] = "";
            }
            
            if (newline == true && lines[0].startsWith(".")) {
                result += ".";
            }
            
            result += lines[0];
            
            newline = lines[0].endsWith("\n") || lines[0].endsWith("\r");
        } while (!lines[1].endsWith(""));
        
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

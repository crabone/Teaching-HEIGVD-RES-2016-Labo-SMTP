package com.mycompany.smtprank;

import java.util.logging.Logger;

/**
 *
 * @author crab_one
 */
public class Utils {

    private static final Logger LOG = Logger.getLogger(Utils.class.getName());
    
    /**
    * This method looks for the next new line separators (\r, \n, \r\n) to extract
    * the next line in the string passed in arguments. 
    * 
    * @param lines a string that may contain 0, 1 or more lines
    * @return an array with 2 elements; the first element is the next line with
    * the line separator, the second element is the remaining text. If the argument does not
    * contain any line separator, then the first element is an empty string.
    */
    public static String[] getNextLine(String lines) {
        String[] result = new String[2];
        int i;

        result[1] = lines;
        i = lines.indexOf("\r\n");

        if (i == -1) {
            i = lines.indexOf("\n");

            if (i == -1) {
                i = lines.indexOf("\r");

                if (i == -1) {
                    result[0] = new String();
                }
                else {
                    result[0] = lines.substring(0, i + 1);
                    result[1] = lines.substring(i + 1);
                }

            }
            else {
                result[0] = lines.substring(0, i + 1);
                result[1] = lines.substring(i + 1);
            }

        }
        else {
            result[0] = lines.substring(0, i + 2);
            result[1] = lines.substring(i + 2);
        }

        return result;
    }
    
}

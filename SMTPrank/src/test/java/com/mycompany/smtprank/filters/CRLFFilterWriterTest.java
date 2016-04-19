package com.mycompany.smtprank.filters;

import java.io.StringWriter;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author crab_one
 */
public class CRLFFilterWriterTest {
    
    @Test
    public void itShouldWorkOnUnix() throws Exception {
        String line = "This is line 1\nThis is line 2\nThis is line 3";
        String expected = "This is line 1\r\nThis is line 2\r\nThis is line 3";
        StringWriter stringWriter = new StringWriter();
        CRLFFilterWriter writer = new CRLFFilterWriter(stringWriter);
        writer.write(line);
        Assert.assertEquals(expected, stringWriter.toString());
    }
    
    @Test
    public void itShouldWorkOnMacOS9() throws Exception {
        String line = "This is line 1\rThis is line 2\rThis is line 3";
        String expected = "This is line 1\r\nThis is line 2\r\nThis is line 3";    
        StringWriter stringWriter = new StringWriter();
        CRLFFilterWriter writer = new CRLFFilterWriter(stringWriter);
        writer.write(line);
        Assert.assertEquals(expected, stringWriter.toString());
    }
    
    @Test
    public void itShouldWorkOnWindows() throws Exception {
        String line = "This is line 1\r\nThis is line 2\r\nThis is line 3";
        String expected = "This is line 1\r\nThis is line 2\r\nThis is line 3";    
        StringWriter stringWriter = new StringWriter();
        CRLFFilterWriter writer = new CRLFFilterWriter(stringWriter);
        writer.write(line);
        Assert.assertEquals(expected, stringWriter.toString());
    }
    
}

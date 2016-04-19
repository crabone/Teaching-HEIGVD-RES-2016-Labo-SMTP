package com.mycompany.smtprank.filters;

import java.io.StringWriter;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author crab_one
 */
public class DoubleBeginingDotsFilterWriterTest {
    
    @Test
    public void ItShouldDoubleBeginingDotsForStringsWithOneLine() throws Exception {
        String line = ".This is a line\n";
        StringWriter stringWriter = new StringWriter();
        DoubleBeginingDotsFilterWriter writer = new DoubleBeginingDotsFilterWriter(stringWriter);
        writer.write(line);
        Assert.assertEquals("." + line, stringWriter.toString());
    }

    @Test
    public void ItShouldDoubleBeginingDotsForStringsWithTwoLines() throws Exception {
        String line1 = "This is a line\n";
        String line2 = ".This is a second line\n";
        StringWriter stringWriter = new StringWriter();
        DoubleBeginingDotsFilterWriter writer = new DoubleBeginingDotsFilterWriter(stringWriter);
        writer.write(line1);
        writer.write(line2);
        Assert.assertEquals(line1 + "." + line2, stringWriter.toString());
    }
    
    @Test
    public void ItShouldWorkWithPartialLines() throws Exception {
        String line1 = "This is a";
        String line2 = ".partial line\n";
        StringWriter stringWriter = new StringWriter();
        DoubleBeginingDotsFilterWriter writer = new DoubleBeginingDotsFilterWriter(stringWriter);
        writer.write(line1);
        writer.write(line2);
        Assert.assertEquals(line1 + line2, stringWriter.toString());
    }
}

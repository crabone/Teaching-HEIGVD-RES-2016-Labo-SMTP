package com.mycompany.smtprank.transformers;

import com.mycompany.smtprank.filters.CRLFFilterWriter;
import com.mycompany.smtprank.filters.DoubleBeginingDotsFilterWriter;
import java.io.Writer;

/**
 *
 * @author crab_one
 */
public class CompleteStringTransformer extends StringTransformer {

    @Override
    public Writer decorateWithFilters(Writer writer) {
        writer = new CRLFFilterWriter(new DoubleBeginingDotsFilterWriter(writer));
        return writer;
    }
    
}

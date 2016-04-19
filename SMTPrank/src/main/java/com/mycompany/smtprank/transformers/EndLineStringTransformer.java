package com.mycompany.smtprank.transformers;

import com.mycompany.smtprank.filters.CRLFFilterWriter;
import java.io.Writer;

/**
 *
 * @author crab_one
 */
public class EndLineStringTransformer extends StringTransformer {

    @Override
    public Writer decorateWithFilters(Writer writer) {
        writer = new CRLFFilterWriter(writer);
        return writer;
    }
    
}

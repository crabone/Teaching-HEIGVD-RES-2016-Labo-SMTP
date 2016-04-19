package com.mycompany.smtprank.transformers;

import java.io.Writer;

/**
 *
 * @author crab_one
 */
public class NoOpStringTransformer extends StringTransformer {

    @Override
    public Writer decorateWithFilters(Writer writer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

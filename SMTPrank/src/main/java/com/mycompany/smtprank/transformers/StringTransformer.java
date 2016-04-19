package com.mycompany.smtprank.transformers;

import java.io.FilterWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author crab_one
 */
public abstract class StringTransformer {
    
    private static final Logger LOG = Logger.getLogger(StringTransformer.class.getName());
    private final List<FilterWriter> filters = new ArrayList<>();
    
    public abstract Writer decorateWithFilters(Writer writer);
    
}

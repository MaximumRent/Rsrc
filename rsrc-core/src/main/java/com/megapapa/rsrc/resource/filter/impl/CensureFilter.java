package com.megapapa.rsrc.resource.filter.impl;

import com.megapapa.rsrc.resource.file.FileResource;
import com.megapapa.rsrc.resource.filter.Filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Censure filter based on neural networks.
 */
public class CensureFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(CensureFilter.class);
    private static final String NAME = "Censure Filter";
    private static final int FILTER_LEVEL = -1;

    @Override
    public void beforeFiltering() {

    }

    @Override
    public void afterFiltering() {

    }

    @Override
    public FileResource doFilter(FileResource resource) {
        LOGGER.info("Censure filter is not supported now!");
        return null;
    }

    @Override
    public String getFilterName() {
        return NAME;
    }

    @Override
    public int getFilterLevel() {
        return FILTER_LEVEL;
    }
}

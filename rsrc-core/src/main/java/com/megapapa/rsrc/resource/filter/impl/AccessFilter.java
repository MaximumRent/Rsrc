package com.megapapa.rsrc.resource.filter.impl;

import com.megapapa.rsrc.resource.file.FileResource;
import com.megapapa.rsrc.resource.filter.Filter;

/**
 * Filter for accessing to resources.
 * Based on access handlers.
 */
public class AccessFilter implements Filter {

    private static final String NAME = "Access filter";
    private static final int FILTER_LEVEL = 1;

    public AccessFilter() {

    }

    @Override
    public void beforeFiltering() {

    }

    @Override
    public void afterFiltering() {

    }

    @Override
    public FileResource doFilter(FileResource resource) {

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

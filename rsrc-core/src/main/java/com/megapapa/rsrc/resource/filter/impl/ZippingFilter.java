package com.megapapa.rsrc.resource.filter.impl;

import com.megapapa.rsrc.resource.file.FileResource;
import com.megapapa.rsrc.resource.filter.Filter;

/**
 * Filter for resource zipping.
 */
public class ZippingFilter implements Filter {

    private static final String NAME = "Zipping filter";
    private static final int FILTER_LEVEL = 2;

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

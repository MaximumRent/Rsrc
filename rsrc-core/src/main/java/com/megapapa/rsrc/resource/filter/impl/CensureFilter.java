package com.megapapa.rsrc.resource.filter.impl;

import com.megapapa.rsrc.resource.file.FileResource;
import com.megapapa.rsrc.resource.filter.Filter;

/**
 * Censure filter based on neural networks.
 */
public class CensureFilter implements Filter {

    private static final String NAME = "Censure Filter";
    private static final int FILTER_LEVEL = 1;

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

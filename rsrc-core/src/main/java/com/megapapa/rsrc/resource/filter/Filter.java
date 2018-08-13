package com.megapapa.rsrc.resource.filter;

import com.megapapa.rsrc.resource.file.FileResource;

/**
 * Interface for filters.
 */
public interface Filter {

    /**
     * Applies a filter to a specific resource.
     * @param resource
     * @return filtered resource.
     */
    FileResource doFilter(FileResource resource);

    /**
     * Get filter name.
     * @return unique filter name.
     */
    String getFilterName();

    int getFilterLevel();
}

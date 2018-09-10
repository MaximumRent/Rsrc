package com.megapapa.rsrc.resource.filter;

import com.megapapa.rsrc.resource.file.FileResource;

/**
 * Interface for filters.
 */
public interface Filter {

    /**
     * Method, which calling before'doFilter'.
     */
    void beforeFiltering();

    /**
     * Method, which calling after 'doFilter'.
     * @return
     */
    void afterFiltering();

    /**
     * Applies a filter to a specific resource.
     * @param resource
     * @return filtered resource.
     */
    // TODO: Maybe change return type to void?
    FileResource doFilter(FileResource resource);

    /**
     * Get filter name.
     * @return unique filter name.
     */
    String getFilterName();

    int getFilterLevel();
}

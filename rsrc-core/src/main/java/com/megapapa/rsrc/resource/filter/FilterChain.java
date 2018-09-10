package com.megapapa.rsrc.resource.filter;

import com.megapapa.rsrc.resource.file.FileResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Class, which contains all filters and filtered resources.
 * Each filter in chain (on read and write) based on their level.
 */
public class FilterChain {

    private static final Logger LOGGER = LoggerFactory.getLogger(FilterChain.class);
    private static final int MAX_SUPPORTED_FILTER_LEVEL = 10;
    private static final int FIRST_FILTER_LEVEL = 1;

    private Map<Integer, List<Filter>> readFilters;
    private Map<Integer, List<Filter>> writeFilters;

    FilterChain() {
        readFilters = new HashMap<>();
        writeFilters = new HashMap<>();
    }

    /**
     * Register filter on specific level in write chain.
     * @param filter
     */
    void registerWrite(Filter filter) {
        int level = filter.getFilterLevel();
        List<Filter> filters = writeFilters.get(level);
        if (filters == null) {
            filters = new LinkedList<>();
            writeFilters.put(level, filters);
        }
        filters.add(filter);
        LOGGER.info("'{}' (level: {}): added to writing filter chain.", filter.getFilterName(), filter.getFilterLevel());
    }

    /**
     * Register filter on specific level in read chain.
     * @param filter
     */
    void registerRead(Filter filter) {
        int level = filter.getFilterLevel();
        List<Filter> filters = readFilters.get(level);
        if (filters == null) {
            filters = new LinkedList<>();
            readFilters.put(level, filters);
        }
        filters.add(filter);
        LOGGER.info("'{}' (level: {}): added to reading filter chain.", filter.getFilterName(), filter.getFilterLevel());
    }

    /**
     * Applies all read-filters on read operation.
     * @param resource
     * @return result of filtering
     */
    public FilterResult doReadChain(FileResource resource) {
        FilterResult filterResult = new FilterResult();
        try {
            for (int filterLevel = FIRST_FILTER_LEVEL; filterLevel <= MAX_SUPPORTED_FILTER_LEVEL; filterLevel++) {
                List<Filter> filters = readFilters.get(filterLevel);
                if (filters != null) {
                    for (Filter filter : filters) {
                        filter.beforeFiltering();
                        filter.doFilter(resource);
                        filter.afterFiltering();
                        filterResult.stamp(filter);
                    }
                }
            }
            filterResult.success();
        } catch (Throwable throwable) {
            filterResult.fail(throwable);
        }
        return filterResult;
    }

    /**
     * Applies all write-filters on write operation.
     * @param resource
     * @return result of filtering
     */
    public FilterResult doWriteChain(FileResource resource) {
        FilterResult filterResult = new FilterResult();
        try {
            for (int filterLevel = FIRST_FILTER_LEVEL; filterLevel <= MAX_SUPPORTED_FILTER_LEVEL; filterLevel++) {
                List<Filter> filters = writeFilters.get(filterLevel);
                if (filters != null) {
                    for (Filter filter : filters) {
                        filter.beforeFiltering();
                        filter.doFilter(resource);
                        filter.afterFiltering();
                        filterResult.stamp(filter);
                    }
                }
            }
            filterResult.success();
        } catch (Throwable throwable) {
            filterResult.fail(throwable);
        }
        return filterResult;
    }
}

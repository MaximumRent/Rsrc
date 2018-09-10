package com.megapapa.rsrc.resource.filter;

import com.megapapa.rsrc.resource.filter.impl.AccessFilter;
import com.megapapa.rsrc.resource.filter.impl.CensureFilter;
import com.megapapa.rsrc.resource.filter.impl.ZippingFilter;
import com.megapapa.rsrc.system.FilterLoader;
import com.megapapa.rsrc.system.exception.FilterLoadingException;

/**
 * Factory for building filter.
 */
class FilterFactory {

    /**
     * Standard filters
     */
    private static final String ZIP_FILTER = "zip";
    private static final String ACCESS_FILTER = "access";
    private static final String CENSURE_FILTER = "censure";

    /**
     * Get new filter based on filter string-type. Filter type can has user-defined type (e.g. org.company.FilterClass).
     * @param type
     * @return filter instance.
     */
    Filter get(String type) {
        switch (type) {
            case ZIP_FILTER:
                return new ZippingFilter();
            case ACCESS_FILTER:
                return new AccessFilter();
            case CENSURE_FILTER:
                return new CensureFilter();
        }
        try {
            return FilterLoader.load(type);
        } catch (FilterLoadingException e) {
            throw new IllegalArgumentException("Illegal type of filter: " + type);
        }
    }
}

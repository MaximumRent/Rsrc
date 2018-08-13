package com.megapapa.rsrc.resource.filter;

import com.megapapa.rsrc.config.FilterChainConfig;
import com.megapapa.rsrc.resource.filter.exception.FilterationFailedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

// TODO: Maybe need create filter chain based on yaml configuration? Something like: chains: zip, censure, access and etc.
public class FilterChainBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(FilterChainBuilder.class);

    private static final String FILTERS_SPLITTER = ",";

    private FilterChainBuilder() {}

    /**
     * Builded filter chain based on configurations from config file.
     * @param config
     * @return Filter chain
     */
    public static FilterChain build(FilterChainConfig config) {
        LOGGER.info("Start creating filter chain...");
        FilterChain filterChain = new FilterChain();
        parseConfig(config.getReadFilters()).forEach(filterChain::registerRead);
        parseConfig(config.getWriteFilters()).forEach(filterChain::registerWrite);
        LOGGER.info("Filter chain created successful.");
        return filterChain;
    }

    /**
     * Parse filters from config and return filters
     * @return List of filters from configuration string
     */
    private static List<Filter> parseConfig(String configs) {
        List<Filter> filters = new LinkedList<>();
        FilterFactory factory = new FilterFactory();
        String[] tokens = configs.split(FILTERS_SPLITTER);
        List<String> handledFilters = new LinkedList<>();
        for (String token : tokens) {
            String filterType = token.trim();
            filters.add(factory.get(filterType));
            handledFilters.forEach(handledFilter -> {
                if (handledFilter.equals(filterType)) {
                    throw new FilterationFailedException("Filter configuration contains two exemplars of one filter type.");
                }
            });
            handledFilters.add(filterType);
        }
        return filters;
    }
}

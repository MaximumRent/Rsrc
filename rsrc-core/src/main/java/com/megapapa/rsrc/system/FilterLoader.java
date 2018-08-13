package com.megapapa.rsrc.system;

import com.megapapa.rsrc.resource.filter.Filter;
import com.megapapa.rsrc.system.exception.FilterLoadingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;

public class FilterLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(FilterLoader.class);

    public static Filter load(String type) throws FilterLoadingException {
        Class extensionClass = null;
        try {
            extensionClass = Class.forName(type);
            Constructor constructor = extensionClass.getConstructor();
            return (Filter) constructor.newInstance();
        } catch (Exception e) {
            LOGGER.info("Can't load filter.", e);
            throw new FilterLoadingException("Can't load filter '" + type + "'.", e);
        }
    }
}

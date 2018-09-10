package com.megapapa.rsrc.cache;

import com.megapapa.rsrc.config.CacheConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileCacheBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileCacheBuilder.class);

    private FileCacheBuilder() {}

    public static FileCache build(CacheConfig config) {
        LOGGER.info("Starting creating cache...");
        FileCache cache = null;
        if (config == null) {
            // Creating dummy-cache
            cache = new FileCache();
        } else {
            // Cache by config
             cache = new FileCache(config.getSize());
        }
        LOGGER.info("Created cache: size - {}; warming-up - {}", config.getSize(), config.isWarmingUp());
        return cache;
    }
}

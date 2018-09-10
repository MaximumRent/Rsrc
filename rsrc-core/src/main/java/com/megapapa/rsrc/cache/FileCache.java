package com.megapapa.rsrc.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.megapapa.rsrc.resource.file.FileResource;
import com.megapapa.rsrc.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class FileCache {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileCache.class);

    private boolean emptyCache;
    private Cache<String, byte[]> cachedFiles;
    private long maxSize;
    private long currentSize;

    /**
     * Constructor for empty cache
     */
    public FileCache() {
        emptyCache = true;
    }

    /**
     * Default file cache with predetermined max size
     * @param maxSize
     */
    public FileCache(long maxSize) {
        cachedFiles = Caffeine.newBuilder().build();
        this.maxSize = maxSize;
        emptyCache = false;
    }

    public boolean isPreset() {
        return emptyCache;
    }

    /**
     *
     * @return true if file successfully added to cache; false, if file doesn't added to cache
     */
    // TODO: need passing not a resource, bytes array, because before we needed zipping bytes
    public boolean put(FileResource resource) {
        if ((currentSize + resource.getSize()) > maxSize) {
            LOGGER.info("Resource '{}' can't be added. Cause: Size exceeded.", resource);
            return false;
        }
        try {
            cachedFiles.put(resource.getFullPath(), FileUtil.getResourceBytes(resource));
            currentSize += resource.getSize();
        } catch (IOException e) {
            LOGGER.info("Resource '{}' can't be added. Cause: {}.", resource, e.getCause());
            return false;
        }
        LOGGER.info("Resource '{}' successfully added to cache.", resource);
        return true;
    }

    /**
     *
     * @param path to file
     * @return cached file bytes, if file present in cache, null, if file hasn't in cache
     */
    public byte[] get(String path) {
        return cachedFiles.getIfPresent(path);
    }
}

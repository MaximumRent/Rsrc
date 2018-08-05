package com.megapapa.rsrc.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.megapapa.rsrc.resource.Resource;
import com.megapapa.rsrc.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class FileCache {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileCache.class);

    private Cache<String, byte[]> cachedFiles;
    private long maxSize;
    private long currentSize;

    public FileCache(long maxSize) {
        cachedFiles = Caffeine.newBuilder().build();
        this.maxSize = maxSize;
    }

    /**
     *
     * @return true if file successfully added to cache; false, if file doesn't added to cache
     */
    // TODO: need passing not a resource, bytes array, because before we needed zipping bytes
    public boolean put(Resource resource) {
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

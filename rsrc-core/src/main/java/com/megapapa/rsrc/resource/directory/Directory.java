package com.megapapa.rsrc.resource.directory;

import com.megapapa.rsrc.cache.FileCache;
import com.megapapa.rsrc.resource.file.FileResource;
import com.megapapa.rsrc.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Directory extends Resource {

    private static final Logger LOGGER = LoggerFactory.getLogger(Directory.class);

    private List<FileResource> files;
    private FileCache cache;

    public Directory(String path, FileCache cache) {
        setPath(path);
        files = new LinkedList<>();
    }

    /**
     * Get bytes of file, which contains in directory
     * @param file
     * @return file bytes, if files doesn't present, returned null
     */
    public byte[] getFile(FileResource file) {
        byte[] cachedFile = cache.get(file.getFullPath());
        if (cachedFile != null) {
            return cachedFile;
        } else {
            try {
                return file.getBytes();
            } catch (IOException e) {
                LOGGER.warn(e.getLocalizedMessage());
                return null;
            }
        }
    }

    // TODO: Put file and in system?
    public void putFile(FileResource file) {
        file.setDirectory(this);
        files.add(file);
    }

    @Override
    public String toString() {
        return getFullPath();
    }

    public long getTotalSize() {
        long totalSize = 0;
        for (FileResource fileResource : files) {
            totalSize += fileResource.getSize();
        }
        return totalSize;
    }

    @Override
    public String getFullPath() {
        return getPath();
    }
}

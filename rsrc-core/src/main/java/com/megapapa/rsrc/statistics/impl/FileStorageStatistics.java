package com.megapapa.rsrc.statistics.impl;

import com.megapapa.rsrc.resource.directory.Directory;
import com.megapapa.rsrc.statistics.Statistics;
import com.megapapa.rsrc.store.FileStorage;

public class FileStorageStatistics implements Statistics {

    private FileStorage fileStorage;

    public FileStorageStatistics(FileStorage fileStorage) {
        this.fileStorage = fileStorage;
    }

    public long getUsageSpace() {
        long totalSpace = 0;
        for (Directory directory : fileStorage.getDirectories()) {
            totalSpace += directory.getTotalSize();
        }
        return totalSpace;
    }

    @Override
    public void createReport() {

    }
}

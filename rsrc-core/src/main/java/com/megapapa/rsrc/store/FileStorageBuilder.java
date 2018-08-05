package com.megapapa.rsrc.store;

import com.megapapa.rsrc.config.Configuration;
import com.megapapa.rsrc.resource.directory.Directory;
import com.megapapa.rsrc.system.SystemReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileStorageBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileStorageBuilder.class);

    public static FileStorage build(Configuration configuration) {
        LOGGER.info("Building file storage...");
        FileStorage storage = new FileStorage();
        configuration.getDirectories().values().forEach(directoryConfiguration -> {
            Directory directory = SystemReader.readDirectory(directoryConfiguration);
            storage.getDirectories().add(directory);
        });
        LOGGER.info("File storage builded successfull.");
        return storage;
    }
}

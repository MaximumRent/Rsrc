package com.megapapa.rsrc.system;

import com.megapapa.rsrc.config.DirectoryConfiguration;
import com.megapapa.rsrc.resource.ResourceFactory;
import com.megapapa.rsrc.resource.directory.Directory;
import com.megapapa.rsrc.resource.file.FileResource;
import com.megapapa.rsrc.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Reader for reading files and their info.
 * This reader read directories and find files for storage.
 */
public class SystemReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemReader.class);

    private SystemReader() {}

    /**
     * Non-recursive directory reading.
     * @param configuration
     * @return directory with file resource
     */
    public static Directory readDirectory(DirectoryConfiguration configuration) {
        LOGGER.info("Read directory on path {}", configuration.getPath());
        File systemDir = new File(configuration.getPath());
        if (!systemDir.isDirectory()) {
            LOGGER.error("'{}' is not directory.", configuration.getPath());
            throw new ReadingException(configuration.getPath() + " is not directory.");
        }

        Directory directory = new Directory(configuration.getPath());
        directory.setSize(systemDir.getUsableSpace());
        directory.setCreationTime(FileUtil.getCreationTime(systemDir));
        int filesCount = 0;
        for (File file : systemDir.listFiles()) {
            if (!file.isDirectory()) {
                FileResource resource = ResourceFactory.build(file, configuration.getType());
                if (resource != null) {
                    directory.putFile(resource);
                    filesCount++;
                }
            }
        }
        LOGGER.info("'{}' directory was readed successfully. Files in directory: {}", directory, filesCount);
        return directory;
    }

}

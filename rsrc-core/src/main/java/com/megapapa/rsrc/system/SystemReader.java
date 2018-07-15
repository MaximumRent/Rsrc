package com.megapapa.rsrc.system;

import com.megapapa.rsrc.config.DirectoryConfiguration;
import com.megapapa.rsrc.resource.FileResource;
import com.megapapa.rsrc.resource.directory.Directory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Reader for reading files and their info.
 * This reader read directories and find files for storage.
 */
public class SystemReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemReader.class);

    private SystemReader() {}

    public Directory readDirectory(DirectoryConfiguration configuration) {
        LOGGER.info("Read directory on path {}", configuration.getPath());
        File systemDir = new File(configuration.getPath());
        if (!systemDir.isDirectory()) {
            LOGGER.error("'{}' is not directory.", configuration.getPath());
            throw new ReadingException(configuration.getPath() + " is not directory.");
        }

        Directory directory = new Directory(configuration.getPath());
        directory.setSize(systemDir.getUsableSpace());
        directory.setCreationTime(LocalDateTime.ofInstant(
                    getCreationTime(systemDir).toInstant(), ZoneId.systemDefault()
                )
        );
        for (File file : systemDir.listFiles()) {

        }
        return directory;
    }

    private FileResource readFileResource() {

    }

    private FileTime getCreationTime(File file) {
        Path p = Paths.get(file.getAbsolutePath());
        BasicFileAttributes view;
        try {
            view = Files.getFileAttributeView(p, BasicFileAttributeView.class).readAttributes();
        } catch (IOException exception) {
            throw new ReadingException(exception);
        }
        return view.creationTime();
    }
}

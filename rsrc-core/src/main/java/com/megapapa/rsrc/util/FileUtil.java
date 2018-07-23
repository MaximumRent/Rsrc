package com.megapapa.rsrc.util;

import com.megapapa.rsrc.system.ReadingException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class FileUtil {

    public static LocalDateTime getCreationTime(File file) {
        Path p = Paths.get(file.getAbsolutePath());
        BasicFileAttributes view;
        try {
            view = Files.getFileAttributeView(p, BasicFileAttributeView.class).readAttributes();
        } catch (IOException exception) {
            throw new ReadingException(exception);
        }
        return LocalDateTime.ofInstant(view.creationTime().toInstant(), ZoneId.systemDefault());
    }
}

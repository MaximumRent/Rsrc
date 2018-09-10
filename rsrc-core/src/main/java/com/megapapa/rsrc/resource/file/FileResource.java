package com.megapapa.rsrc.resource.file;

import com.google.common.io.ByteSource;
import com.google.common.io.Files;
import com.megapapa.rsrc.resource.Resource;
import com.megapapa.rsrc.resource.directory.Directory;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;

public abstract class FileResource extends Resource {

    private static final String DELIMETER = "/";

    private String name;
    private Directory directory;

    public byte[] getBytes() throws IOException {
        File file = new File(getFullPath());
        ByteSource source = Files.asByteSource(file);
        return source.read();
    }

    public OutputStream getOutputStream() throws FileNotFoundException {
        File file = new File(getFullPath());
        return new BufferedOutputStream(new FileOutputStream(file));
    }

    public InputStream getInputStream() throws FileNotFoundException {
        File file = new File(getFullPath());
        return new BufferedInputStream(new FileInputStream(file));
    }

    abstract public Set<String> supportedTypes();

    public String getFullPath() {
        StringBuilder builder = new StringBuilder();
        builder
                .append(getPath())
                .append(DELIMETER)
                .append(name);
        return builder.toString();
    }

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }
}

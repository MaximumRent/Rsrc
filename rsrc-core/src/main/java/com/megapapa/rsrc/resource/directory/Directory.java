package com.megapapa.rsrc.resource.directory;

import com.megapapa.rsrc.resource.file.FileResource;
import com.megapapa.rsrc.resource.Resource;

import java.util.LinkedList;
import java.util.List;

public class Directory extends Resource {

    private List<FileResource> files;

    public Directory(String path) {
        setPath(path);
        files = new LinkedList<>();
    }

    public void getFile(FileResource file) {

    }

    // TODO: Put file and in system?
    public void putFile(FileResource file) {
        files.add(file);
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

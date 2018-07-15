package com.megapapa.rsrc.resource.directory;

import com.megapapa.rsrc.resource.FileResource;
import com.megapapa.rsrc.resource.Resource;

import java.util.LinkedList;
import java.util.List;

public class Directory extends Resource {

    private List<FileResource> files;

    public Directory(String path) {
        setPath(path);
        files = new LinkedList<>();
    }

    public void putFile(FileResource file) {
        files.add(file);
    }
}
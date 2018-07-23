package com.megapapa.rsrc.resource.file;

import com.megapapa.rsrc.resource.Resource;

import java.io.BufferedReader;

public abstract class FileResource extends Resource {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] read() {

    }
}

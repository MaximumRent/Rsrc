package com.megapapa.rsrc.resource.file;

import com.megapapa.rsrc.resource.Resource;

public abstract class FileResource extends Resource {

    private static final String DELIMETER = "/";

    private String name;

    public String getFullPath() {
        StringBuilder builder = new StringBuilder();
        builder
                .append(getPath())
                .append(DELIMETER)
                .append(name);
        return builder.toString();
    }
}

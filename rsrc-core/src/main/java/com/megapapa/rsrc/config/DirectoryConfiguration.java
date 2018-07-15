package com.megapapa.rsrc.config;

import com.megapapa.rsrc.access.Access;

public class DirectoryConfiguration {

    private String path;
    private String type;
    private Access access;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

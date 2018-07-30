package com.megapapa.rsrc.config;

public class DirectoryConfiguration {

    private String path;
    private String type;
    private AccessConfig access;
    private CacheConfig config;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public AccessConfig getAccess() {
        return access;
    }

    public void setAccess(AccessConfig access) {
        this.access = access;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

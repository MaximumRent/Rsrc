package com.megapapa.rsrc.config;

public class AccessConfig {

    /* Access can be public and protected */
    private String accessType; // Type - read, write and e.g.
    private String accessHandler; // Class of access handler

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public String getAccessHandler() {
        return accessHandler;
    }

    public void setAccessHandler(String accessHandler) {
        this.accessHandler = accessHandler;
    }

    @Override
    public String toString() {
        return accessType + ":" + accessHandler;
    }
}

package com.megapapa.rsrc.config;

import com.megapapa.rsrc.access.Access;
import io.bootique.annotation.BQConfigProperty;

/**
 * Created by maxim on 7/9/18.
 */
public class Directory {

    private Access access;
    private String path;
    private String scanningFilesType;

    public Access getAccess() {
        return access;
    }

    @BQConfigProperty
    public void setAccess(Access access) {
        this.access = access;
    }

    public String getPath() {
        return path;
    }

    @BQConfigProperty
    public void setPath(String path) {
        this.path = path;
    }

    public String getScanningFilesType() {
        return scanningFilesType;
    }

    @BQConfigProperty
    public void setScanningFilesType(String scanningFilesType) {
        this.scanningFilesType = scanningFilesType;
    }
}

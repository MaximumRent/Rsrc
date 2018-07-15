package com.megapapa.rsrc.config;

import io.bootique.annotation.BQConfig;
import io.bootique.annotation.BQConfigProperty;

import java.util.List;

/**
 * Created by maxim on 7/9/18.
 */
@BQConfig
public class RSRCConfigProvider {

    private List<Directory> directories;

    public List<Directory> getDirectories() {
        return directories;
    }

    @BQConfigProperty
    public void setDirectories(List<Directory> directories) {
        this.directories = directories;
    }
}

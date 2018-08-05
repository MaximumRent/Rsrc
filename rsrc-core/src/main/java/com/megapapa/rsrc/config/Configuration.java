package com.megapapa.rsrc.config;

import java.util.Map;

public class Configuration {

    private Map<String, DirectoryConfiguration> directories;

    public Map<String, DirectoryConfiguration> getDirectories() {
        return directories;
    }

    public void setDirectories(Map<String, DirectoryConfiguration> directories) {
        this.directories = directories;
    }
}

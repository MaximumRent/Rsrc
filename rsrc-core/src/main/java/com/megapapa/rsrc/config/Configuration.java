package com.megapapa.rsrc.config;

import java.util.Map;

public class Configuration {

    private Map<String, DirectoryConfiguration> directories;
    private FilterChainConfig filterChainConfig;

    public Map<String, DirectoryConfiguration> getDirectories() {
        return directories;
    }

    public void setDirectories(Map<String, DirectoryConfiguration> directories) {
        this.directories = directories;
    }

    public FilterChainConfig getFilterChainConfig() {
        return filterChainConfig;
    }

    public void setFilterChainConfig(FilterChainConfig filterChainConfig) {
        this.filterChainConfig = filterChainConfig;
    }
}

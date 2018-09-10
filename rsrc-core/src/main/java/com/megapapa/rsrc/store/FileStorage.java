package com.megapapa.rsrc.store;

import com.megapapa.rsrc.resource.Resource;
import com.megapapa.rsrc.resource.directory.Directory;
import com.megapapa.rsrc.resource.filter.FilterChain;
import com.megapapa.rsrc.statistics.impl.RSRCStatistics;

import java.util.LinkedList;
import java.util.List;

/**
 * Storage singleton, which provides interface to accessing to files described in configuration file.
 */
public class FileStorage {

    private List<Directory> directories;
    private RSRCStatistics rsrcStatistics;
    private FilterChain filterChain;

    FileStorage(FilterChain filterChain) {
        this.filterChain = filterChain;
        this.directories = new LinkedList<>();
        this.rsrcStatistics = new RSRCStatistics(this);
    }

    public List<Directory> getDirectories() {
        return directories;
    }

    public Resource getResource(String resourceName) {
        // find resource
        // use statistics!!
        // do filters
        // TODO !!!
    }

    // TODO: Make return custom return type on resource putting, something like PutResult
    public boolean putResource(Resource resource) {
        // use statistics
    }

    public boolean deleteResource(Resource resource) {
        // delete from cache, if present
        // use statistics
        // delete from system
    }

    // Add cache and storage there ZIPPED files
}

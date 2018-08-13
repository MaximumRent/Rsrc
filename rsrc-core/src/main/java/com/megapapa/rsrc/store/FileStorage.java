package com.megapapa.rsrc.store;

import com.megapapa.rsrc.resource.Resource;
import com.megapapa.rsrc.resource.directory.Directory;
import com.megapapa.rsrc.resource.filter.FilterChain;

import java.util.LinkedList;
import java.util.List;

/**
 * Storage singleton, which provides interface to accessing to files described in configuration file.
 */
public class FileStorage {

    private List<Directory> directories;
    private FilterChain filterChain;

    FileStorage(FilterChain filterChain) {
        directories = new LinkedList<>();
        this.filterChain = filterChain;
    }

    public List<Directory> getDirectories() {
        return directories;
    }

    public Resource getResource(String resourceName) {
        // find resource
        // do filters
        // TODO !!!
    }

    // TODO: Make return custom return type on resource putting, something like PutResult
    public boolean putResource(Resource resource) {

    }

    // Add cache and storage there ZIPPED files
}

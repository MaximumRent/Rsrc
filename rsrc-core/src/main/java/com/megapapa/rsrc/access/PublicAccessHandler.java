package com.megapapa.rsrc.access;

/**
 * Access handler for public directories.
 */
public class PublicAccessHandler extends AccessHandler {

    @Override
    public boolean handle(AccessMetaData metaData) {
        return true;
    }
}

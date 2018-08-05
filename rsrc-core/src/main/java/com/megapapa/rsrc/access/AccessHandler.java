package com.megapapa.rsrc.access;

/**
 * Parent class for each access handler.
 */
public abstract class AccessHandler {

    /**
     * Method, which checking privileges to resource.
     * @param metaData Metadata about access handling.
     * @return accepting to resource (true/false).
     */
    abstract public boolean handle(AccessMetaData metaData);
}

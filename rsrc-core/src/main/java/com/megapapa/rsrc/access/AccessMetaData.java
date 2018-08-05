package com.megapapa.rsrc.access;

/**
 * Metainformation about access to directory.
 */
public class AccessMetaData {

    private String directoryPath;
    private String directoryType;
    private String accessType;  // e.g. read/write and etc.
    private String requestAddress; // ip of user, who tried get resource -- TODO: experemental

    public String getDirectoryPath() {
        return directoryPath;
    }

    public void setDirectoryPath(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public String getDirectoryType() {
        return directoryType;
    }

    public void setDirectoryType(String directoryType) {
        this.directoryType = directoryType;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public String getRequestAddress() {
        return requestAddress;
    }

    public void setRequestAddress(String requestAddress) {
        this.requestAddress = requestAddress;
    }
}

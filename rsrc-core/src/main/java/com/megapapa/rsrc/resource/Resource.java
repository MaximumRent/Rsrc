package com.megapapa.rsrc.resource;

import java.time.LocalDateTime;

/**
 *
 * Abstract resource, which will be extended to concrete resources in system
 * like - file, text, image, sound.
 *
 * Created by maxim on 7/9/18.
 */
public abstract class Resource {

    private String path;
    private String name;
    private LocalDateTime creationTime;
    private int size;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }
}

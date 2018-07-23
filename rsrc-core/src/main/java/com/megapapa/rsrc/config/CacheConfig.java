package com.megapapa.rsrc.config;

public class CacheConfig {

    private long size;
    private boolean warmingUp;

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public boolean isWarmingUp() {
        return warmingUp;
    }

    public void setWarmingUp(boolean warmingUp) {
        this.warmingUp = warmingUp;
    }
}

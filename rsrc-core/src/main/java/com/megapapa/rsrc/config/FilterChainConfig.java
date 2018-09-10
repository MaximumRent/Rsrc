package com.megapapa.rsrc.config;

public class FilterChainConfig {

    private String writeFilters;
    private String readFilters;

    public String getWriteFilters() {
        return writeFilters;
    }

    public void setWriteFilters(String writeFilters) {
        this.writeFilters = writeFilters;
    }

    public String getReadFilters() {
        return readFilters;
    }

    public void setReadFilters(String readFilters) {
        this.readFilters = readFilters;
    }

    @Override
    public String toString() {
        return "Read filters: " + readFilters + "\n" +
                "Write filters: " + writeFilters;
    }
}

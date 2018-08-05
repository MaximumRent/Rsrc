package com.megapapa.rsrc.statistics.impl;

import com.megapapa.rsrc.resource.Resource;
import com.megapapa.rsrc.statistics.IncrementedStatistics;
import com.megapapa.rsrc.statistics.Statistics;
import com.megapapa.rsrc.store.FileStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Main statistics class, which contains statistics about RSRC work.
 */
public class RSRCStatistics implements Statistics {

    public static final String READING_STATISTICS = "reading";
    public static final String WRITING_STATISTICS = "writing";

    private Map<String, IncrementedStatistics> incrementedStatistics;
    private SystemStatistics systemStatistics;
    private FileStorageStatistics storageStatistics;

    public RSRCStatistics(FileStorage storage) {
        incrementedStatistics = new HashMap<>();
        incrementedStatistics.put(READING_STATISTICS, new ReadingStatistics());
        incrementedStatistics.put(WRITING_STATISTICS, new WritingStatistics());
        systemStatistics = new SystemStatistics();
        storageStatistics = new FileStorageStatistics(storage);
    }

    public void inc(String statisticsName, Resource resource) {
        incrementedStatistics.get(statisticsName).inc(resource);
    }

    public List<Map.Entry<String, Integer>> getFullStatistics(String statisticsName) {
        return incrementedStatistics.get(statisticsName).getSortedStatistics();
    }

    public String uptime() {
        return systemStatistics.uptime();
    }

    public long getUsageSpace() {
        return storageStatistics.getUsageSpace();
    }

    /**
     * Total report about RSRC work.
     */
    @Override
    public void createReport() {
        systemStatistics.createReport();
        storageStatistics.createReport();
        incrementedStatistics.values().forEach(IncrementedStatistics::createReport);
    }
}

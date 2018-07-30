package com.megapapa.rsrc.statistics;

import com.megapapa.rsrc.resource.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Main statistics class, which contains statistics about RSRC work.
 */
public class ResourceStatistics {

    public static final String READING_STATISTICS = "reading";
    public static final String WRITING_STATISTICS = "writing";

    private Map<String, IncrementedStatistics> statistics;

    public ResourceStatistics() {
        statistics = new HashMap<>();
        statistics.put(READING_STATISTICS, new ReadingStatistics());
        statistics.put(WRITING_STATISTICS, new WritingStatistics());
    }

    public void inc(String statisticsName, Resource resource) {
        statistics.get(statisticsName).inc(resource);
    }

    public List<Map.Entry<String, Integer>> getFullStatistics(String statisticsName) {
        return statistics.get(statisticsName).getSortedStatistics();
    }
}

package com.megapapa.rsrc.statistics;

import com.megapapa.rsrc.resource.Resource;

import java.util.HashMap;
import java.util.Map;

public class Statistics {

    public static final String READING_STATISTICS = "reading";
    public static final String WRITING_STATISTICS = "writing";

    private Map<String, CollectableStatistics> statistics;

    public Statistics() {
        statistics = new HashMap<>();
        statistics.put(READING_STATISTICS, new ReadingStatistics());
        statistics.put(WRITING_STATISTICS, new WritingStatistics());
    }

    public void inc(String statisticsName, Resource resource) {
        statistics.get(statisticsName).inc(resource);
    }

    public void
}

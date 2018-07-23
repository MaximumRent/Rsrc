package com.megapapa.rsrc.statistics;

import com.megapapa.rsrc.resource.FileResource;
import com.megapapa.rsrc.resource.Resource;

import java.util.HashMap;
import java.util.Map;

public class ReadingStatistics implements CollectableStatistics {

    private Map<String, Integer> readingStatistics;

    public ReadingStatistics() {
        readingStatistics = new HashMap<>();
    }

    @Override
    public void inc(Resource resource) {
        String fullPath = resource.getFullPath();
        Integer statistics = readingStatistics.get(fullPath);
        if (statistics == null) {
            statistics = 0;
        }
        statistics++;
        readingStatistics.put(fullPath, statistics);
    }

    @Override
    public void clear() {
        readingStatistics.clear();
    }

    public void nullifyStatistics(FileResource resource) {
        readingStatistics.put(resource.getFullPath(), 0);
    }
}

package com.megapapa.rsrc.statistics;

import com.megapapa.rsrc.resource.Resource;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class IncrementedStatistics implements UsageStatistics {

    private Map<String, Integer> statistics;

    public IncrementedStatistics() {
        statistics = new HashMap<>();
    }

    @Override
    public void inc(Resource resource) {
        String fullPath = resource.getFullPath();
        Integer statisticsValue = statistics.get(fullPath);
        if (statisticsValue == null) {
            statisticsValue = 0;
        }
        statisticsValue++;
        statistics.put(fullPath, statisticsValue);
    }

    @Override
    public void nullifyStatistics(Resource resource) {
        statistics.put(resource.getFullPath(), 0);
    }

    @Override
    public void clear() {
        statistics.clear();
    }

    public List<Map.Entry<String,Integer>> getSortedStatistics() {
        Comparator<Map.Entry<String, Integer>> byValue = Comparator.comparing(Map.Entry::getValue);
        return statistics.entrySet().stream().sorted(byValue).collect(Collectors.toList());
    }
}

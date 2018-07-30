package com.megapapa.rsrc.statistics;

import com.megapapa.rsrc.resource.Resource;

public interface UsageStatistics {

    void inc(Resource resource);
    void nullifyStatistics(Resource resource);
    void clear();
}

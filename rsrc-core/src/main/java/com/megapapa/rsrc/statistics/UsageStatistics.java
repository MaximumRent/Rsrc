package com.megapapa.rsrc.statistics;

import com.megapapa.rsrc.resource.Resource;

public interface UsageStatistics extends Statistics {

    void inc(Resource resource);
    void nullifyStatistics(Resource resource);
    void clear();
}

package com.megapapa.rsrc.statistics;

import com.megapapa.rsrc.resource.Resource;

public interface CollectableStatistics {

    void inc(Resource resource);
    void clear();
}

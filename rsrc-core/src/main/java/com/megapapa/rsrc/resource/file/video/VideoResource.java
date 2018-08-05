package com.megapapa.rsrc.resource.file.video;

import com.megapapa.rsrc.resource.SupportedTypes;
import com.megapapa.rsrc.resource.file.FileResource;

import java.util.Set;

public class VideoResource extends FileResource {

    @Override
    public Set<String> supportedTypes() {
        return SupportedTypes.videoTypes;
    }
}

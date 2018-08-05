package com.megapapa.rsrc.resource.file.image;

import com.megapapa.rsrc.resource.SupportedTypes;
import com.megapapa.rsrc.resource.file.FileResource;

import java.util.Set;

/**
 * Created by maxim on 7/9/18.
 */
public class ImageResource extends FileResource {

    @Override
    public Set<String> supportedTypes() {
        return SupportedTypes.imageTypes;
    }
}

package com.megapapa.rsrc.resource.file.document;

import com.megapapa.rsrc.resource.SupportedTypes;
import com.megapapa.rsrc.resource.file.FileResource;

import java.util.Set;

public class DocumentResource extends FileResource {

    @Override
    public Set<String> supportedTypes() {
        return SupportedTypes.documentTypes;
    }
}

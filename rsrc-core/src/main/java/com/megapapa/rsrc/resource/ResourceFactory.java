package com.megapapa.rsrc.resource;

import com.megapapa.rsrc.resource.file.FileResource;
import com.megapapa.rsrc.resource.file.document.DocumentResource;
import com.megapapa.rsrc.resource.file.image.ImageResource;
import com.megapapa.rsrc.resource.file.sound.SoundResource;
import com.megapapa.rsrc.resource.file.text.TextResource;
import com.megapapa.rsrc.resource.file.video.VideoResource;
import com.megapapa.rsrc.util.FileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 *
 * Build resources from package
 *
 * Created by maxim on 7/9/18.
 */
public class ResourceFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceFactory.class);

    private ResourceFactory() {}

    public static FileResource build(File file, String type) {
        FileResource resource = factory(type);
        if (resource != null) {
            resource.setPath(file.getAbsolutePath());
            resource.setSize(file.getUsableSpace());
            resource.setCreationTime(FileUtil.getCreationTime(file));
        } else {
            LOGGER.warn("File {} has unsupported type {}", file.getName(), type);
        }
        return resource;
    }

    private static FileResource factory(String type) {
        if (SupportedTypes.isImage(type)) {
            return new ImageResource();
        } else if (SupportedTypes.isDocument(type)) {
            return new DocumentResource();
        } else if (SupportedTypes.isSound(type)) {
            return new SoundResource();
        } else if (SupportedTypes.isText(type)) {
            return new TextResource();
        } else if (SupportedTypes.isVideo(type)) {
            return new VideoResource();
        }
        return null;
    }
}

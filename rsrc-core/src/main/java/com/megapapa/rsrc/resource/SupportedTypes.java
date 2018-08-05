package com.megapapa.rsrc.resource;

import java.util.HashSet;
import java.util.Set;

/**
 * Support class, which contains resource supported types.
 */
public class SupportedTypes {

    private SupportedTypes() {}

    public static Set<String> imageTypes;
    public static Set<String> documentTypes;
    public static Set<String> soundTypes;
    public static Set<String> textTypes;
    public static Set<String> videoTypes;

    static {
        imageTypes = new HashSet<>();
        imageTypes.add("jpg");
        imageTypes.add("bmp");
        imageTypes.add("gif");
        imageTypes.add("svg");
    }

    // TODO: maybe make document is not other types?
    static {
        documentTypes = new HashSet<>();
        documentTypes.add("doc");
        documentTypes.add("docx");
        documentTypes.add("pdf");
    }

    static {
        soundTypes = new HashSet<>();
        soundTypes.add("mp3");
        soundTypes.add("flac");
    }

    static {
        textTypes = new HashSet<>();
        textTypes.add("txt");
    }

    static {
        videoTypes = new HashSet<>();
        videoTypes.add("mpeg");
        videoTypes.add("webm");
    }

    public static boolean isImage(String type) {
        return imageTypes.contains(type);
    }

    public static boolean isDocument(String type) {
        return documentTypes.contains(type);
    }

    public static boolean isSound(String type) {
        return soundTypes.contains(type);
    }

    public static boolean isText(String type) {
        return textTypes.contains(type);
    }

    public static boolean isVideo(String type) {
        return videoTypes.contains(type);
    }
}

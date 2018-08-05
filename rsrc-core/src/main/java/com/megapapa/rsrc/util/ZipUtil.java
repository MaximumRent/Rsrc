package com.megapapa.rsrc.util;

import com.google.common.io.ByteStreams;
import com.megapapa.rsrc.resource.file.FileResource;
import org.apache.commons.compress.compressors.CompressorException;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.compressors.CompressorStreamFactory;

import java.io.IOException;

/**
 * Zipping utility, which provides 'zip' and 'unzip' methods.
 * Used DEFLATE algorithm.
 */
public class ZipUtil {

    /**
     *
     * @param fileResource
     * @return bytes of zipped file
     * @throws IOException
     */
    // TODO: !!! CHECK THIS !!!
    public static byte[] zipFile(FileResource fileResource) throws CompressorException, IOException {
        CompressorInputStream compressorStream = new CompressorStreamFactory()
                                                .createCompressorInputStream(CompressorStreamFactory.DEFLATE, fileResource.getInputStream());
        return ByteStreams.toByteArray(compressorStream);
    }

    /**
     *
     * @param zippedByteFile
     * @return bytes of unzipped file
     */
    public static byte[] unzipFile(byte[] zippedByteFile) {
        throw new UnsupportedOperationException("Unzipping not supported"); // TODO !!!!
    }
}

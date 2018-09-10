package com.megapapa.rsrc.access;

import com.megapapa.rsrc.config.AccessConfig;
import com.megapapa.rsrc.exception.InitializationException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Instrument-class for building access objects
 */
public class AccessBuilder {

    private AccessBuilder() {}

    public static Access build(AccessConfig config) {
        Access access = new Access();
        try {
            AccessHandler handler = getAccessHandler(config.getAccessHandler());
            access.setHandler(handler);
        } catch (Exception exception) {
            throw new InitializationException("Error initialization access handler '" + config + "'.", exception);
        }
        return access;
    }

    private static AccessHandler getAccessHandler(String accessHandlerClass) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class handlerClass = ClassLoader.getSystemClassLoader().loadClass(accessHandlerClass);
        Constructor constructor = handlerClass.getConstructor();
        AccessHandler handler = (AccessHandler) constructor.newInstance();
        return handler;
    }
}

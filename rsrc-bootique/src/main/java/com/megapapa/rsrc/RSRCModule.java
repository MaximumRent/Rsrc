package com.megapapa.rsrc;

import com.google.inject.Binder;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.megapapa.rsrc.config.RSRCConfigProvider;
import io.bootique.ConfigModule;
import io.bootique.config.ConfigurationFactory;


/**
 * Created by maxim on 7/9/18.
 */
public class RSRCModule extends ConfigModule {

    private static final String CONFIG_PREFIX = "rsrc";

    public void configure(Binder binder) {

    }

    protected String defaultConfigPrefix() {
        return CONFIG_PREFIX;
    }

    @Provides
    @Singleton
    public RSRCConfigProvider createResourceProvider(ConfigurationFactory configFactory, Injector injector) {
        // TODO !!!
        return null;
    }
}

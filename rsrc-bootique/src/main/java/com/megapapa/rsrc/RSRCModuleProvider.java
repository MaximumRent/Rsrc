package com.megapapa.rsrc;

import com.google.inject.Module;
import io.bootique.BQModuleProvider;

/**
 * Created by maxim on 7/9/18.
 */
public class RSRCModuleProvider implements BQModuleProvider {


    public Module module() {
        return new RSRCModule();
    }
}

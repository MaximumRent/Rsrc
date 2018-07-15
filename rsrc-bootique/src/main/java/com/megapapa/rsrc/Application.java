package com.megapapa.rsrc;

import io.bootique.Bootique;

/**
 * Created by maxim on 7/9/18.
 */
public class Application {

    public static void main(String[] args) {
        Bootique
                .app(args)
                .autoLoadModules()
                .exec()
                .exit();
    }
}

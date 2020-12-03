package com.ashwin;

import com.ashwin.config.AppModuleConfiguration;
import com.ashwin.di.AppModule;
import com.ashwin.routeimpl.GreetingRouteImpl;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class AppModuleApplication extends Application<AppModuleConfiguration> {
    public static void main(String[] args) throws Exception {
        new AppModuleApplication().run(args);
    }

    @Override
    public void run(AppModuleConfiguration config, Environment env) throws Exception {
        env.jersey().getResourceConfig().register(new AppModule());
        env.jersey().register(GreetingRouteImpl.class);
    }
}

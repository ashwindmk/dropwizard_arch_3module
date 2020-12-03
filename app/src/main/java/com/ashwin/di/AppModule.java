package com.ashwin.di;

import com.ashwin.repository.MessageRepository;
import com.ashwin.repositoryimpl.MessageRepositoryImpl;
import com.ashwin.route.GreetingRoute;
import com.ashwin.routeimpl.GreetingRouteImpl;
import com.ashwin.service.GreetingService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import javax.inject.Singleton;

public class AppModule extends AbstractBinder {
    @Override
    protected void configure() {
        // Repositories
        bind(MessageRepositoryImpl.class).to(MessageRepository.class).in(Singleton.class);

        // Services
        bind(GreetingService.class).to(GreetingService.class).in(Singleton.class);

        // Routes
        bind(GreetingRouteImpl.class).to(GreetingRoute.class).in(Singleton.class);
    }
}

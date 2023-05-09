package com.trace;

import com.trace.endpoint.SubscriptionEndpointCreator;
import com.trace.repository.InMemoryRepositoryProvider;
import com.trace.server.WebSocketServer;
import com.trace.server.converter.JsonResponseConverter;
import com.trace.service.DefaultServiceProvider;

public class Application {

    public static void main(String[] args) throws Exception {
        //Creating domain logic and satisfying dependencies.
        var repositoryProvider = new InMemoryRepositoryProvider();
        var serviceProvider = new DefaultServiceProvider(repositoryProvider);

        var webSocketCreator = new SubscriptionEndpointCreator(serviceProvider, new JsonResponseConverter());

        //Create and launch server.
        var server = new WebSocketServer(8080, "/subscription", webSocketCreator);
        server.start();
        server.join();
    }
}
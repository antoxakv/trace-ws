package com.trace.endpoint;

import com.trace.server.converter.ResponseConverter;
import com.trace.service.ServiceProvider;
import org.eclipse.jetty.websocket.server.JettyServerUpgradeRequest;
import org.eclipse.jetty.websocket.server.JettyServerUpgradeResponse;
import org.eclipse.jetty.websocket.server.JettyWebSocketCreator;

/**
 * Jetty Factory for create and configure {@link SubscriptionEndpoint}.
 */
public final class SubscriptionEndpointCreator implements JettyWebSocketCreator {

    private final ServiceProvider serviceProvider;

    private final ResponseConverter responseConverter;

    public SubscriptionEndpointCreator(ServiceProvider serviceProvider, ResponseConverter responseConverter) {
        this.serviceProvider = serviceProvider;
        this.responseConverter = responseConverter;
    }

    @Override
    public Object createWebSocket(
            JettyServerUpgradeRequest jettyServerUpgradeRequest,
            JettyServerUpgradeResponse jettyServerUpgradeResponse
    ) {
        return new SubscriptionEndpoint(
                serviceProvider.getIpService(),
                serviceProvider.getGeneratorService(),
                responseConverter
        );
    }
}

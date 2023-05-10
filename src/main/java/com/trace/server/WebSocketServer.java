package com.trace.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.websocket.server.JettyWebSocketCreator;
import org.eclipse.jetty.websocket.server.config.JettyWebSocketServletContainerInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class initializes and manages Jetty server.
 */
public final class WebSocketServer {

    private static final Logger LOG = LoggerFactory.getLogger(WebSocketServer.class);

    private final Server server;

    public WebSocketServer(int port, String url, JettyWebSocketCreator jettyWebSocketCreator) {
        server = new Server();
        var connector = new ServerConnector(server);
        connector.setPort(port);
        server.addConnector(connector);
        var context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        JettyWebSocketServletContainerInitializer.configure(
                context,
                (servletContext, wsContainer) -> wsContainer.addMapping(url, jettyWebSocketCreator)
        );
    }

    public void start() throws Exception {
        server.start();
    }

    public void join() throws InterruptedException {
        LOG.info("Use Ctrl+C to stop server");
        server.join();
    }
}


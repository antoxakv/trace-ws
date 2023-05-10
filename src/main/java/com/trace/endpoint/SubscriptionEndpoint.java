package com.trace.endpoint;

import com.trace.endpoint.dto.ErrorResponse;
import com.trace.endpoint.dto.SubscriptionDto;
import com.trace.server.TraceStatusCodes;
import com.trace.server.converter.ResponseConverter;
import com.trace.service.GeneratorService;
import com.trace.service.IpService;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketAdapter;
import org.eclipse.jetty.websocket.api.exceptions.WebSocketTimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Optional;

/**
 * Class serves requests from client and manages ws session.
 */
final class SubscriptionEndpoint extends WebSocketAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(SubscriptionEndpoint.class);

    private final IpService ipService;

    private final GeneratorService generatorService;

    private final ResponseConverter responseConverter;

    private volatile String ip;

    public SubscriptionEndpoint(
            IpService ipService,
            GeneratorService generatorService,
            ResponseConverter responseConverter
    ) {
        this.ipService = ipService;
        this.generatorService = generatorService;
        this.responseConverter = responseConverter;
    }

    @Override
    public void onWebSocketConnect(Session session) {
        super.onWebSocketConnect(session);
        ip = initIp();
        if (ip == null || !ipService.add(ip)) {
            session.close(
                    TraceStatusCodes.DUPLICATE_CONNECTION.getCode(),
                    TraceStatusCodes.DUPLICATE_CONNECTION.getReason()
            );
        }
    }

    @Override
    public void onWebSocketText(String message) {
        try {
            Optional<BigInteger> value = generatorService.generate();
            String response;
            if (value.isPresent()) {
                response = responseConverter.convert(new SubscriptionDto(value.get()));
            } else {
                response = responseConverter.convert(
                        new ErrorResponse("Can't generate unique value. Try again.")
                );
            }
            getRemote().sendString(response);
        } catch (IOException e) {
            LOG.error("Can't send random value", e);
        }
    }

    @Override
    public void onWebSocketClose(int statusCode, String reason) {
        if (statusCode != TraceStatusCodes.DUPLICATE_CONNECTION.getCode() && ip != null) {
            ipService.remove(ip);
        }
    }

    @Override
    public void onWebSocketError(Throwable cause) {
        if (cause instanceof WebSocketTimeoutException) {
            LOG.info("Closed unused connection for ip: {}", ip);
        } else {
            if (getSession().isOpen()) {
                getSession().close();
            }
            LOG.error("Error for client with ip {}", ip, cause);
        }
    }

    private String initIp() {
        String host = null;
        SocketAddress remoteAddress = getSession().getRemoteAddress();
        if (remoteAddress instanceof InetSocketAddress) {
            var inetSocketAddress = (InetSocketAddress) remoteAddress;
            host = inetSocketAddress.getHostString();
        }
        return host;
    }
}
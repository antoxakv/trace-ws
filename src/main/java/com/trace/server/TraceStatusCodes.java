package com.trace.server;

/**
 * Defined status codes of application for websocket.
 */
public enum TraceStatusCodes {

    DUPLICATE_CONNECTION(4000, "Not allowed multiple connection");

    private final int code;
    private final String reason;

    TraceStatusCodes(int code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    public int getCode() {
        return code;
    }

    public String getReason() {
        return reason;
    }
}

package com.trace.endpoint.dto;

/**
 * Dto for return error to client.
 */
public final class ErrorResponse {

    private final String text;

    public ErrorResponse(String text) {
        this.text = text;
    }
}

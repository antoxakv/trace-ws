package com.trace.endpoint.dto;

import java.math.BigInteger;

/**
 * Dto for return random number.
 */
public final class SubscriptionDto {

    private final BigInteger value;

    public SubscriptionDto(BigInteger value) {
        this.value = value;
    }
}

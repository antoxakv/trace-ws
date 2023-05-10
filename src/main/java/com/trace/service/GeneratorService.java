package com.trace.service;

import java.math.BigInteger;
import java.util.Optional;

/**
 * Interface defines logic for work with random value.
 */
public interface GeneratorService {

    /**
     * Generate random value.
     *
     * @return optional will contain random value, if it was succeeded generate, another cases optional will be empty.
     */
    Optional<BigInteger> generate();
}

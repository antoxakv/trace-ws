package com.trace.repository;

import java.math.BigInteger;

/**
 * Interface defines method for receive repositories.
 */
public interface RepositoryProvider {

    /**
     * Receiving repository for storing clients ip.
     *
     * @return ip repository.
     */
    DataRepository<String> getIpRepository();

    /**
     * Receiving repository for storing values.
     *
     * @return value repository.
     */
    DataRepository<BigInteger> getValueRepository();
}

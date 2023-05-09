package com.trace.repository;

import java.math.BigInteger;

/**
 * Interface defines method for receive repositories.
 */
public interface RepositoryProvider {

    /**
     * Receiving repository for storing clients ip.
     *
     * @return repository.
     */
    DataRepository<String> getIpStorage();

    /**
     * Receiving repository for storing values.
     *
     * @return repository.
     */
    DataRepository<BigInteger> getValueStorage();
}

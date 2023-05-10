package com.trace.repository;

import java.math.BigInteger;

/**
 * Class initialize and store repositories.
 */
public final class InMemoryRepositoryProvider implements RepositoryProvider {

    private final DataRepository<String> ipStorage = new InMemoryDataRepository<>();

    private final DataRepository<BigInteger> valueStorage = new InMemoryDataRepository<>();

    @Override
    public DataRepository<String> getIpRepository() {
        return ipStorage;
    }

    @Override
    public DataRepository<BigInteger> getValueRepository() {
        return valueStorage;
    }

}

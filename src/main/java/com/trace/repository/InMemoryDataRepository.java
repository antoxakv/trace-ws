package com.trace.repository;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class for storing data in memory.
 *
 * @param <V> the type of data in this repository.
 */
final class InMemoryDataRepository<V> implements DataRepository<V> {

    private final Set<V> storage = ConcurrentHashMap.newKeySet();

    @Override
    public boolean add(V data) {
        return storage.add(data);
    }

    @Override
    public void remove(V data) {
        storage.remove(data);
    }

}

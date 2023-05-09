package com.trace.repository;


/**
 * Interface defines common methods for repository.
 *
 * @param <V> the type of data in this repository.
 */
public interface DataRepository<V> {

    /**
     * Add data to storage.
     *
     * @param data element to be added to this repository.
     * @return {@code true} if this repository did not already contain the specified element.
     */
    boolean add(V data);

    /**
     * Remove data from storage.
     *
     * @param data element to be removed from this repository.
     */
    void remove(V data);
}

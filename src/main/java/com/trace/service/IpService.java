package com.trace.service;

/**
 * Interface define logic for work with clients ip.
 */
public interface IpService {

    /**
     * Add client ip to storage.
     *
     * @param ip client ip.
     * @return {@code true} if element added.
     */
    boolean add(String ip);

    /**
     * Remove client ip from storage.
     *
     * @param ip client ip.
     */
    void remove(String ip);
}

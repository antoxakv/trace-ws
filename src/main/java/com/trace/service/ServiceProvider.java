package com.trace.service;

/**
 * Interface defines method for receive services.
 */
public interface ServiceProvider {

    /**
     * Receiving service for manage clients ip.
     *
     * @return service.
     */
    IpService getIpService();

    /**
     * Receiving service for generate value.
     *
     * @return service.
     */
    GeneratorService getGeneratorService();
}

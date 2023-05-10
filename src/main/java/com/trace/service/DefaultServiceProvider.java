package com.trace.service;

import com.trace.repository.RepositoryProvider;

/**
 * Class initialize and store services.
 */
public final class DefaultServiceProvider implements ServiceProvider {

    private final IpService ipService;

    private final GeneratorService generatorService;

    public DefaultServiceProvider(RepositoryProvider repositoryProvider) {
        ipService = new DefaultIpService(repositoryProvider.getIpRepository());
        generatorService = new DefaultGeneratorService(repositoryProvider.getValueRepository());
    }

    @Override
    public IpService getIpService() {
        return ipService;
    }

    @Override
    public GeneratorService getGeneratorService() {
        return generatorService;
    }
}

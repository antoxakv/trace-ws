package com.trace.service;

import com.trace.repository.DataRepository;

final class DefaultIpService implements IpService {

    private final DataRepository<String> storage;

    DefaultIpService(DataRepository<String> storage) {
        this.storage = storage;
    }

    @Override
    public boolean add(String ip) {
        return storage.add(ip);
    }

    @Override
    public void remove(String ip) {
        storage.remove(ip);
    }
}

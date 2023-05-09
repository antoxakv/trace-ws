package com.trace.service;

import com.trace.repository.DataRepository;

import java.math.BigInteger;
import java.util.Optional;
import java.util.Random;

final class DefaultGeneratorService implements GeneratorService {

    private final DataRepository<BigInteger> storage;

    DefaultGeneratorService(DataRepository<BigInteger> storage) {
        this.storage = storage;
    }

    @Override
    public Optional<BigInteger> generate() {
        var value = new BigInteger(64, new Random());
        return storage.add(value) ? Optional.of(value) : Optional.empty();
    }
}

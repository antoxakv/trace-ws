package com.trace.server.converter;

/**
 * Interface defines behavior for convert dto to clients format.
 */
public interface ResponseConverter {

    /**
     * Convert dto to string.
     *
     * @param data any dto
     * @return string
     */
    String convert(Object data);

}

package com.trace.server.converter;

import com.google.gson.Gson;

/**
 * Class for convert dto to json string.
 */
public final class JsonResponseConverter implements ResponseConverter {

    private final Gson gson = new Gson();

    /**
     * Convert dto to json.
     *
     * @param data any dto.
     * @return string in json.
     */
    @Override
    public String convert(Object data) {
        return gson.toJson(data);
    }
}

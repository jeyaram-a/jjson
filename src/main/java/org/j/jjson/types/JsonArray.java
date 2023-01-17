package org.j.jjson.types;

import java.util.List;

public class JsonArray extends JsonElement {

    private final List<JsonElement> arr;

    public JsonArray(List<JsonElement> arr) {
        this.arr = arr;
    }
    @Override
    public JsonArray toJsonArray() {
        return this;
    }

    @Override
    public JsonObject toJsonObject() {
        throw new UnsupportedOperationException("Cannot convert JsonArray to JsonObject");
    }

    @Override
    public JsonString toJsonString() {
        throw new UnsupportedOperationException("Cannot convert JsonArray to JsonString");
    }

    @Override
    public JsonNumber toJsonNumber() {
        throw new UnsupportedOperationException("Cannot convert JsonArray to JsonNumber");
    }

    @Override
    public JsonBoolean toJsonBoolean() {
        throw new UnsupportedOperationException("Cannot convert JsonArray to JsonBoolean");
    }

    @Override
    public JsonNull toJsonNull() {
        throw new UnsupportedOperationException("Cannot convert JsonArray to JsonNull");
    }
}

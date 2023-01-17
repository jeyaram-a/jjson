package org.j.jjson.types;

import java.util.Objects;

public class JsonString implements JsonElement {

    private final String str;

    public JsonString(String str) {
        this.str = str;
    }
    public JsonArray toJsonArray() {
        throw new UnsupportedOperationException("Cannot convert JsonString to JsonArray");
    }

    @Override
    public JsonObject toJsonObject() {
        throw new UnsupportedOperationException("Cannot convert JsonString to JsonObject");
    }

    @Override
    public JsonString toJsonString() {
       return this;
    }

    @Override
    public JsonNumber toJsonNumber() {
        throw new UnsupportedOperationException("Cannot convert JsonString to JsonString");
    }

    @Override
    public JsonBoolean toJsonBoolean() {
        throw new UnsupportedOperationException("Cannot convert JsonString to JsonBoolean");
    }

    @Override
    public JsonNull toJsonNull() {
        throw new UnsupportedOperationException("Cannot convert JsonString to JsonNull");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonString that = (JsonString) o;
        return Objects.equals(str, that.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str);
    }

    @Override
    public String toString() {
        return str;
    }
}

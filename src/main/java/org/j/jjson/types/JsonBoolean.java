package org.j.jjson.types;

import java.util.Objects;

public class JsonBoolean implements JsonElement {

    private final boolean val;

    public JsonBoolean(boolean val) {
        this.val = val;
    }
    @Override
    public JsonArray toJsonArray() {
        throw new UnsupportedOperationException("Cannot convert JsonBoolean to JsonArray");

    }

    @Override
    public JsonObject toJsonObject() {
        throw new UnsupportedOperationException("Cannot convert JsonBoolean to JsonObject");
    }

    @Override
    public JsonString toJsonString() {
        throw new UnsupportedOperationException("Cannot convert JsonBoolean to toJsonString");
    }

    @Override
    public JsonNumber toJsonNumber() {
        throw new UnsupportedOperationException("Cannot convert JsonBoolean to JsonNumber");
    }

    @Override
    public JsonBoolean toJsonBoolean() {
        return this;
    }

    @Override
    public JsonNull toJsonNull() {
        throw new UnsupportedOperationException("Cannot convert JsonBoolean to toJsonNull");
    }

    @Override
    public String toString() {
        return ""+val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonBoolean that = (JsonBoolean) o;
        return val == that.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}

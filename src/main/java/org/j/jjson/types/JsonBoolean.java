package org.j.jjson.types;

public class JsonBoolean extends JsonElement {

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
}

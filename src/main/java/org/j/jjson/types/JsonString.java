package org.j.jjson.types;

public class JsonString extends JsonElement {

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
}

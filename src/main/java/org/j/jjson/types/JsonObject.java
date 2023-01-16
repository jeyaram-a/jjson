package org.j.jjson.types;

public class JsonObject extends JsonElement {
    @Override
    public JsonArray toJsonArray() {
        throw new UnsupportedOperationException("Cannot convert JsonObject to JsonArray");
    }

    @Override
    public JsonObject toJsonObject() {
       return this;
    }

    @Override
    public JsonString toJsonString() {
        throw new UnsupportedOperationException("Cannot convert JsonObject to JsonString");
    }

    @Override
    public JsonNumber toJsonNumber() {
        throw new UnsupportedOperationException("Cannot convert JsonObject to JsonNumber");
    }

    @Override
    public JsonBoolean toJsonBoolean() {
        throw new UnsupportedOperationException("Cannot convert JsonObject to JsonBoolean");
    }

    @Override
    public JsonNull toJsonNull() {
        throw new UnsupportedOperationException("Cannot convert JsonObject to JsonNull");
    }
}

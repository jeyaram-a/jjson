package org.j.jjson.types;

public class JsonNull extends JsonElement {
    @Override
    public JsonArray toJsonArray() {
        throw new UnsupportedOperationException("Cannot convert JsonNull to JsonArray");
    }

    @Override
    public JsonObject toJsonObject() {
        throw new UnsupportedOperationException("Cannot convert JsonNull to JsonObject");
    }

    @Override
    public JsonString toJsonString() {
        throw new UnsupportedOperationException("Cannot convert JsonNull to toJsonString");
    }

    @Override
    public JsonNumber toJsonNumber() {
        throw new UnsupportedOperationException("Cannot convert JsonNull to JsonNumber");
    }

    @Override
    public JsonBoolean toJsonBoolean() {
        throw new UnsupportedOperationException("Cannot convert JsonNull to JsonBoolean");
    }

    @Override
    public JsonNull toJsonNull() {
        return this;
    }


}

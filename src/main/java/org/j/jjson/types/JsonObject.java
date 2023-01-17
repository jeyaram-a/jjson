package org.j.jjson.types;

import java.util.HashMap;

public class JsonObject extends HashMap<String, JsonElement> implements JsonElement {

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

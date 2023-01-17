package org.j.jjson.types;

import java.util.Map;

public class JsonObject extends JsonElement {

    private final Map<String, JsonElement> obj;

    public JsonObject( Map<String, JsonElement> obj) {
        this.obj = obj;
    }

    public JsonElement get(String key) {
        return this.obj.get(key);
    }

    public void put(String key, JsonElement val) {
        this.obj.put(key, val);
    }

    public void remove(String key) {
        this.obj.remove(key);
    }

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

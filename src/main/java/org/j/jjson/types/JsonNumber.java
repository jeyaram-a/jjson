package org.j.jjson.types;

import java.math.BigDecimal;

public class JsonNumber extends JsonElement {

    private BigDecimal val;

    public JsonNumber(String num) {
       val = new BigDecimal(num);
    }
    public JsonArray toJsonArray() {
        throw new UnsupportedOperationException("Cannot convert JsonNumber to JsonArray");
    }

    @Override
    public JsonObject toJsonObject() {
        throw new UnsupportedOperationException("Cannot convert JsonNumber to JsonObject");
    }

    @Override
    public JsonString toJsonString() {
        throw new UnsupportedOperationException("Cannot convert JsonNumber to JsonString");
    }

    @Override
    public JsonNumber toJsonNumber() {
       return this;
    }

    @Override
    public JsonBoolean toJsonBoolean() {
        throw new UnsupportedOperationException("Cannot convert JsonNumber to JsonBoolean");
    }

    @Override
    public JsonNull toJsonNull() {
        throw new UnsupportedOperationException("Cannot convert JsonNumber to JsonNull");
    }
}

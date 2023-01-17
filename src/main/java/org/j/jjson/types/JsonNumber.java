package org.j.jjson.types;

import java.math.BigDecimal;
import java.util.Objects;

public class JsonNumber implements JsonElement {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonNumber that = (JsonNumber) o;
        return Objects.equals(val, that.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    @Override
    public String toString() {
        return val.toString();
    }
}

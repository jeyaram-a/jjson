package org.j.jjson.types;

public abstract class JsonElement {

    public boolean isJsonArray() {
        return this instanceof JsonArray;
    }

    public abstract JsonArray toJsonArray();


    public boolean isJsonObject() {
        return this instanceof JsonObject;
    }

    public abstract JsonObject toJsonObject();

    public boolean isJsonString() {
        return this instanceof JsonString;
    }

    public abstract JsonString toJsonString();

    public boolean isJsonNumber() {
        return this instanceof JsonNumber;
    }

    public abstract JsonNumber toJsonNumber();

    public boolean isJsonBoolean() {
        return this instanceof JsonBoolean;
    }

    public abstract JsonBoolean toJsonBoolean();

    public boolean isJsonNull() {
        return this instanceof JsonNull;
    }

    public abstract JsonNull toJsonNull();

}

package org.j.jjson.types;

public  interface JsonElement {

    public default boolean isJsonArray() {
        return this instanceof JsonArray;
    }

    public abstract JsonArray toJsonArray();


    public default boolean isJsonObject() {
        return this instanceof JsonObject;
    }

    public abstract JsonObject toJsonObject();

    public default boolean isJsonString() {
        return this instanceof JsonString;
    }

    public abstract JsonString toJsonString();

    public default boolean isJsonNumber() {
        return this instanceof JsonNumber;
    }

    public abstract JsonNumber toJsonNumber();

    public default boolean isJsonBoolean() {
        return this instanceof JsonBoolean;
    }

    public abstract JsonBoolean toJsonBoolean();

    public default boolean isJsonNull() {
        return this instanceof JsonNull;
    }

    public abstract JsonNull toJsonNull();

}

package org.j.jjson.types;

public  interface JsonElement {

    default boolean isJsonArray() {
        return this instanceof JsonArray;
    }

    JsonArray toJsonArray();

    default boolean isJsonObject() {
        return this instanceof JsonObject;
    }

    JsonObject toJsonObject();

    default boolean isJsonString() {
        return this instanceof JsonString;
    }

    JsonString toJsonString();

    default boolean isJsonNumber() {
        return this instanceof JsonNumber;
    }

    JsonNumber toJsonNumber();

    default boolean isJsonBoolean() {
        return this instanceof JsonBoolean;
    }

    JsonBoolean toJsonBoolean();

    default boolean isJsonNull() {
        return this instanceof JsonNull;
    }

    JsonNull toJsonNull();

}

package org.j.jjson.parser;

import org.j.jjson.types.*;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class JJSonParserTest {

    Path getPath(String fileName) throws URISyntaxException {
        URL res = getClass().getClassLoader().getResource(fileName);
       return Paths.get(res.toURI()).toFile().toPath();
    }

    @Test
    void TestArray() {
        var str = """
                    ["hello", 1, 1.0, {"k":"v"}, true, null]
                """;
        var parsed = JJSonParser.parse(str);
        assertTrue(parsed.isJsonArray());
        var arr = parsed.toJsonArray();
        var expectedJsonObj = new JsonObject();
        expectedJsonObj.put("k", new JsonString("v"));
        assertEquals(6, arr.size());
        assertEquals(new JsonString("hello"), arr.get(0));
        assertEquals(new JsonNumber("1"), arr.get(1));
        assertEquals(new JsonNumber("1.0"), arr.get(2));
        assertEquals(expectedJsonObj, arr.get(3));
        assertEquals(new JsonBoolean(true), arr.get(4));
        assertEquals(new JsonNull(), arr.get(5));
    }

    @Test
    void TestArrayMissingComma() {
        var str = """
                    ["hello", 1, 1.0 {"k":"v"}, true, null]
                """;
       var ex = assertThrows(ParseException.class,  () -> JJSonParser.parse(str));
       assertTrue(ex.getMessage().contains("Unexpected char at 21"));
    }

    @Test
    void TestArrayMissingClosingBrackets() {
        var str = """
                    ["hello", 1, 1.0, {"k":"v"}, true, null
                """;
        var ex = assertThrows(ParseException.class,  () -> JJSonParser.parse(str));
        assertTrue(ex.getMessage().contains("EOF"));
    }

    @Test
    void TestObject() {
        var str = """
                   {
                        "k1": "v1",
                        "k2": {
                            "v2k1": "v2v1",
                            "v2k2": 1.0
                        },
                        "k3": null
                   }
                """;
        var k2Obj = new JsonObject();
        k2Obj.put("v2k1", new JsonString("v2v1"));
        k2Obj.put("v2k2", new JsonNumber("1.0"));
        var k1Obj = new JsonObject();
        k1Obj.put("k1", new JsonString("v1"));
        k1Obj.put("k3", new JsonNull());
        k1Obj.put("k2", k2Obj);

        var parsed = JJSonParser.parse(str);
        assertEquals(k1Obj, parsed);
    }

    @Test
    void TestObjectMissingComma() {
        var str = """
                   {
                        "k1": "v1",
                        "k2": {
                            "v2k1": "v2v1",
                            "v2k2": 1.0
                        }
                        "k3": null
                   }
                """;
        var ex = assertThrows(ParseException.class,  () -> JJSonParser.parse(str));
        assertTrue(ex.getMessage().contains("Unexpected char at 111"));
    }

    @Test
    void TestObjectMissingClosingBrackets() {
        var str = """
                   {
                        "k1": "v1",
                        "k2": {
                            "v2k1": "v2v1",
                            "v2k2": 1.0,
                        
                        "k3": null
                   }
                """;
        var ex = assertThrows(ParseException.class,  () -> JJSonParser.parse(str));
        assertTrue(ex.getMessage().contains("EOF"));
    }


    @Test
    void Test1() throws URISyntaxException {
        var parsed = JJSonParser.parse(getPath("narcos.json"));
        assertTrue(parsed.isJsonObject());
        assertEquals(24, parsed.toJsonObject().size());
    }
}
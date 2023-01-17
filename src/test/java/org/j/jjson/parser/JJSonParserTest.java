package org.j.jjson.parser;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

class JJSonParserTest {

    Path getPath(String fileName) throws URISyntaxException {
        URL res = getClass().getClassLoader().getResource(fileName);
       return Paths.get(res.toURI()).toFile().toPath();
    }
    @Test
    void Test1() throws URISyntaxException, IOException {
        var parsed = JJSonParser.parse(getPath("narcos.json"));
        assert parsed.isJsonObject();
    }
}
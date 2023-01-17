package org.j.jjson.parser;

import org.j.jjson.types.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class JJSonParser {

    final private String content;

    private int cursor = 0;

    private boolean hasPrev() {
        return cursor > 0;
    }

    private char prevChar() {
        return content.charAt(cursor-1);
    }

    char charAtCursor() {
        return content.charAt(cursor);
    }

    private void moveForward() {
        ++cursor;
        if(cursor > content.length()) {
            throw new ParseException("Reached EOF. Malformed json");
        }
    }

    private void moveForward(int k) {
        cursor += k;
        if(cursor > content.length()) {
            throw new ParseException("Reached EOF. Malformed json");
        }
    }

    private void moveBackward() {
        --cursor;
    }

    private void moveBackward(int k) {
        cursor -= k;
    }

    public JJSonParser(String content) {
        this.content = content;
    }

    public JJSonParser(Path path) throws IOException {
        this.content = new String(Files.readAllBytes(path));
    }

    private void skipWhiteSpaces() {
        while (Character.isWhitespace(charAtCursor())) {
            moveForward();
        }
    }

    private String readWithinQuote() {
        assertChar('"');
        moveForward();
        var sb = new StringBuilder();
        while (true) {
            if(charAtCursor() == '"') {
                if(prevChar() != '\\') {
                    break;
                }
            }
            sb.append(charAtCursor());
            moveForward();
        }
        // now at '"'
        moveForward();
        return sb.toString();
    }

    private boolean matches(String s) {
        boolean mismatch = false;
        // no of move forward
        int nomf = 0;
        for (char x: s.toCharArray()) {
            if(x != charAtCursor()) {
                mismatch = true;
                break;
            }
            moveForward();
            ++nomf;
        }

        if(!mismatch)
            return true;

        moveBackward(nomf);
        return false;
    }

    void assertChar(char x) {
        // TODO improve add coloring and show context
        if(charAtCursor() != x) {
            String context = content.substring(Math.max(0, cursor-5), Math.min(cursor+6, content.length())).strip();
            throw new ParseException("Error !. Unexpected char at "+ cursor + " context \"" + context + "\"");
        }
    }

    void raiseStateError() {
        String context = content.substring(Math.max(0, cursor-5), Math.min(cursor+6, content.length()));
        throw new ParseException("Error !. Unexpected char at "+ cursor + " context \"" + context + "\"");
    }

    private JsonObject parseJsonObject() {
        Map<String, JsonElement> obj = new HashMap<>();
        boolean firstEncountered = false;
        while (true) {
            skipWhiteSpaces();
            if(charAtCursor() == '}') {
                moveForward();
                break;
            }
            if(firstEncountered) {
                assertChar(',');
                // skip ','
                moveForward();
            }
            skipWhiteSpaces();
            assertChar('"');
            String key = readWithinQuote();
            skipWhiteSpaces();
            assertChar(':');
            // at ':'
            moveForward();
            skipWhiteSpaces();
            JsonElement val = parse();
            obj.put(key, val);
            skipWhiteSpaces();
            firstEncountered = true;
        }
        return new JsonObject(obj);
    }

    private JsonArray parseJsonArray() {
        List<JsonElement> list = new ArrayList<>();
        boolean firstEncounterd = false;
        while (true) {
            skipWhiteSpaces();
            if(charAtCursor() == ']') {
                moveForward();
                break;
            }
            if (firstEncounterd) {
                assertChar(',');
                moveForward();
            }
            skipWhiteSpaces();
            list.add(parse());
            skipWhiteSpaces();
            firstEncounterd = true;
        }
        return new JsonArray(list);
    }

    private JsonString parseJsonString() {
        return new JsonString(readWithinQuote());
    }

    private JsonNumber parseJsonNumber() {
        assert Character.isDigit(charAtCursor());
        var sb = new StringBuilder();
        while (charAtCursor() == '.' || Character.isDigit(charAtCursor())) {
            sb.append(charAtCursor());
            moveForward();
        }

        return new JsonNumber(sb.toString());
    }

    private JsonNull parseJsonNull() {
        if(matches("null")) {
            return new JsonNull();
        }
       raiseStateError();
        return null;
    }

    private JsonBoolean parseJsonBoolean() {
        if(matches("true")) {
            return new JsonBoolean(true);
        } else if(matches("false")) {
            return new JsonBoolean(false);
        }
        raiseStateError();
        return null;
    }

    private JsonElement parseNullOrNumberOrBoolean() {
        if(Character.isDigit(charAtCursor())) {
            return parseJsonNumber();
        } else if(charAtCursor() == 'n') {
            return parseJsonNull();
        } else {
            return parseJsonBoolean();
        }
    }

    public JsonElement parse() {
        skipWhiteSpaces();
        switch (charAtCursor()) {
            case '{' -> {
                moveForward();
                return parseJsonObject();
            }
            case '[' -> {
                moveForward();
                return parseJsonArray();
            }
            case '"' -> {
                return parseJsonString();
            }

            default -> {
                return parseNullOrNumberOrBoolean();
            }
        }
    }
    public static JsonElement parse(String s) {
        var parser = new JJSonParser(s);
        return parser.parse();
    }

    public static JsonElement parse(Path path) throws IOException {
        var parser = new JJSonParser(path);
        var start = System.currentTimeMillis();
        var parsed = parser.parse();
        var elapsed = System.currentTimeMillis() - start;
        System.out.println(String.format("Parsing took %d ms", elapsed));
        return parsed;
    }
}

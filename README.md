# JJSON

Another json parser for java.

Supports all json types:
* JsonObject
* JsonArray
* JsonString
* JsonNumber
* JsonNull

Usage
```java
  void parse(String jsonStr) {
    
        // to check it is JsonObject
        if(parsed.isJsonObject()) {
            var object = parsed.toJsonObject();
            // can traverse just like a map
            for(Map.Entry<String, JsonElement> entry: object.entrySet()) {
                System.out.printf("%s -> %s \n", entry.getKey(), entry.getValue());
            }
        } else if(parsed.isJsonArray()) {
            var arr = parsed.toJsonArray();
            // can traverse just like a list
            for(var element: arr) {
                System.out.println(element);
            }
        } else if(parsed.isJsonString()) {
            var str = parsed.toJsonString();
            System.out.println(str.getVal());
        } else if(parsed.isJsonNumber()) {
            var num = parsed.toJsonNumber();
            // BigDecimal
            System.out.println(num.getVal());
        } else if(parsed.isJsonBoolean()) {
            var bool = parsed.toJsonBoolean();
            System.out.println(bool.getVal());
        } else {
            var Null = parsed.toJsonNull();
            // null
            System.out.println(Null.getVal());
        }

        // Or better use pattern matching switch

        switch (parsed) {
            case JsonObject ob -> System.out.println(ob.get("key"));
            case JsonArray arr -> System.out.println(arr.get(0));
            case JsonString str -> System.out.println(str.getVal());
            case JsonNumber num -> System.out.println(num.getVal());
            case JsonBoolean bool -> System.out.println(bool.getVal());
            case JsonNull Null -> System.out.println(Null.getVal());
            default -> throw new IllegalStateException("Not a valid json type");
        }
        
        // Can also parse files
        Path path = Paths.get("/file.json");
        var parsed = JJsonParser.parse(path);
}
```

To run tests:
```shell
    mvn test
```



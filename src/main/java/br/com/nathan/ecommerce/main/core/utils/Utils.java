package br.com.nathan.ecommerce.main.core.utils;

import com.google.common.base.Objects;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {

    public static Boolean TrueIfNull(Boolean value) {
        return value == null || value;
    }


    @SafeVarargs
    public static Map<String, List<String>> createErrorMap(Map<String, List<String>> ...maps) {
        var errorMap = new HashMap<String, List<String>>();

        Arrays.stream(maps).forEach(eachMap -> {
            eachMap.keySet().forEach(key -> {
                var errors = eachMap.get(key);
                if(!errors.isEmpty()) errorMap.put(key, errors);
            });
        });
        return errorMap;
    }

    public static String Hash256(String value) {
        return Hashing.sha256()
                .hashString(value, StandardCharsets.UTF_8)
                .toString();
    }
}

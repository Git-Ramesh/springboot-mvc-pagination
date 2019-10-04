package com.rs.app.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import lombok.extern.slf4j.Slf4j;

/**
 * Utility class for converting java object to JSON and JSON string to java
 * object.
 *
 * @author ramesh
 */
@Slf4j
public class JacksonUtil {
    private static final ObjectMapper OBJECT_MAPPER;
    private static final ObjectWriter OBJECT_WRITER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_WRITER = OBJECT_MAPPER.writer().withDefaultPrettyPrinter();
        log.info("ObjectMapper object initialized");
    }

    private JacksonUtil() {
        // No operations
    }

    /**
     * <p>
     * Converts targetObject to JSON.
     *
     * @param targetObject
     * @return JSON equivalent to targetObject
     */
    public static String convertToJson(Object targetObject) {
        String jsonString = null;
        try {
            jsonString = OBJECT_WRITER.writeValueAsString(targetObject);
        } catch (JsonProcessingException ex) {
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(
                    "Failed to convert object of " + targetObject.getClass().getName() + " to json string");
        }
        return jsonString;
    }

    /**
     * <p>
     * Converts the given JSON string to given targetClass object.
     *
     * @param <T>
     * @param json
     * @param targetClass
     * @return targetClass object
     */

    public static <T> T convertJsonToJavaObject(String json, Class<T> targetClass) {
        T targetObject = null;

        try {
            targetObject = OBJECT_MAPPER.readValue(json, targetClass);
        } catch (IOException io) {
            log.error("Failed to convert " + json + " to object of type " + targetClass, io);
            throw new RuntimeException("Failed to convert " + json + " to " + targetClass.getCanonicalName());
        }
        return targetObject;
    }
}

package com.clone;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ObjectMapperJsonSerializer  {
    public static final ObjectMapperJsonSerializer INSTANCE = new ObjectMapperJsonSerializer();
    private ObjectMapper objectMapper = new ObjectMapper();

    public <T> T fromString(String string, Class<T> clazz) {
        try {
            return objectMapper.readValue(string, clazz);
        } catch (IOException e) {
            throw new IllegalArgumentException("The given string value: " + string + " cannot be transformed to Json object", e);
        }
    }


    public <T> T fromString(String string, Type type) {
        try {
            return objectMapper.readValue(string, objectMapper.getTypeFactory().constructType(type));
        } catch (IOException e) {
            throw new IllegalArgumentException("The given string value: " + string + " cannot be transformed to Json object", e);
        }
    }

    public String toString(Object value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("The given Json object value: " + value + " cannot be transformed to a String", e);
        }
    }

    public <T> T clone(T value) {
        return fromString(toString(value), (Class<T>) value.getClass());
}

    public <T> List<T> clone(List<T> value) {
        try {
            String jsonString = toString(value);
            System.out.println(">>>>>> " + jsonString);
            //CollectionType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, (Class<T>) value.getClass());
            //return objectMapper.readValue(jsonString, new TypeReference<List<T>>() {});
            return objectMapper.readValue(jsonString, List.class); //new TypeReference<List<T>>() {}
            //return objectMapper.readValue(jsonString, javaType);

        } catch (IOException e) {
            throw new IllegalArgumentException("The given string value: "  + " cannot be transformed to Json object", e);
        }

    }
//
}
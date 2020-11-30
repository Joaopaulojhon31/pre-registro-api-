package com.webrecivil.api.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.webrecivil.api.exception.ApiException;

public final class JsonUtil {

    private final static ObjectMapper MAPPER;

    static {
        MAPPER = new ObjectMapper();
        MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
        MAPPER.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        MAPPER.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
    };

    private JsonUtil() {
    }
    
   	public static String transformToString(PropertyNamingStrategy namingStrategy, Object obj) throws ApiException {
    	try {
    		ObjectMapper specificMapper = new ObjectMapper();
    		specificMapper.enable(SerializationFeature.INDENT_OUTPUT);
    		specificMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
    		specificMapper.setPropertyNamingStrategy(namingStrategy);
    		return new String(specificMapper.writeValueAsBytes(obj));
    	} catch (Exception ex) {
    		throw new ApiException(ex);
    	}
    }
   	
    public static final <T> T transformToObject(PropertyNamingStrategy namingStrategy, Class<T> clazz, String json) throws ApiException {
        try {
        	ObjectMapper specificMapper = new ObjectMapper();
    		specificMapper.enable(SerializationFeature.INDENT_OUTPUT);
    		specificMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
    		specificMapper.setPropertyNamingStrategy(namingStrategy);
            return specificMapper.readValue(json, clazz);
        } catch (Exception ex) {
            throw new ApiException(ex);
        }
    }
    
    public static final String transformToString(Object obj) throws ApiException {
        try {
            return new String(MAPPER.writeValueAsBytes(obj));
        } catch (Exception ex) {
            throw new ApiException(ex);
        }
    }

    public static final <T> T transformToObject(Class<T> clazz, BufferedReader reader) throws ApiException {
        try {
            return MAPPER.readValue(reader, clazz);
        } catch (Exception ex) {
            throw new ApiException(ex);
        }
    }

    public static final <T> T transformToObject(Class<T> clazz, byte[] bytes) throws ApiException {
        try {
            return MAPPER.readValue(bytes, clazz);
        } catch (Exception ex) {
            throw new ApiException(ex);
        }
    }

    public static final <T> T transformToObject(Class<T> clazz, File file) throws ApiException {
        try {
            return MAPPER.readValue(file, clazz);
        } catch (Exception ex) {
            throw new ApiException(ex);
        }
    }

    public static final <T> T transformToObject(Class<T> clazz, InputStream is) throws ApiException {
        try {
            return MAPPER.readValue(is, clazz);
        } catch (Exception ex) {
            throw new ApiException(ex);
        }
    }

    public static final <T> T transformToObject(Class<T> clazz, String json) throws ApiException {
        try {
            return MAPPER.readValue(json, clazz);
        } catch (Exception ex) {
            throw new ApiException(ex);
        }
    }
    
    public static final <T> List<T> transformToObjectList(Class<T> clazz, String json) throws ApiException {
        try {
            return MAPPER.readValue(json, MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (Exception ex) {
            throw new ApiException(ex);
        }
    }
    
    public static final <T> List<T> transformToObjectList(Class<T> clazz, List<T> lista) throws ApiException {
        try {
            return MAPPER.convertValue(lista, MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (Exception ex) {
            throw new ApiException(ex);
        }
    }

}

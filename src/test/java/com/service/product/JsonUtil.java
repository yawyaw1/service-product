package com.service.product;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.platform.commons.util.StringUtils;

import java.util.List;

public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Method that convert a string response to a list of defined objects
     * @param content
     * @param <T>
     * @return
     * @throws JsonProcessingException
     */
    public static <T> List<T> convertStringToList(String content, Class<T> clazz) throws JsonProcessingException {
        if (StringUtils.isNotBlank(content)) {
            return objectMapper.readValue(content, objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
        }
        return null;
    }
}

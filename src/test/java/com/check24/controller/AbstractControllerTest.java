package com.check24.controller;

import java.io.IOException;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Abstract parent class for all controller test classes.
 * @author Ramzan_zafar
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public abstract class AbstractControllerTest {
    protected MockMvc mockMvc;

    protected final void setupControllerMvc(Object controller) {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    protected final String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsString(obj);
    }

    protected final <T> T mapFromJson(String json, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, clazz);
    }

    protected final <T> List<T> mapFromJsonList(String json, Class<T> elementClazz) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, elementClazz));
    }
}

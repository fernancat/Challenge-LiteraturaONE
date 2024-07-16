package com.fernan.gt.Literature.service;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvierteDatos {
    private ObjectMapper objectMapper = new ObjectMapper(); 
    public <T> T convertData(String json, Class<T> classC){
        try{
            return objectMapper.readValue(json, classC); 
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}

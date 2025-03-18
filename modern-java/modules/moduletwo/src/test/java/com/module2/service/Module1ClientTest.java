package com.module2.service;

import com.moduleone.service.Module1Service;
import com.moduletwo.client.Module1Client;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Module1ClientTest {

    Module1Client module1Client = new Module1Client(new Module1Service());
    @Test
    void retrieveData() {
        var module1DTO = module1Client.retrieveData();
        assert module1DTO!=null;
        assertEquals("Hello! This is from Module1", module1DTO.name());
    }
}
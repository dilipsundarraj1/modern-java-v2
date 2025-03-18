package com.moduletwo.client;

import com.moduleone.dtos.Module1DTO;
import com.moduleone.service.Module1Service;

public class Module1Client {

    private final Module1Service module1Service;

    public Module1Client(Module1Service module1Service) {
        this.module1Service = module1Service;
    }

    public Module1DTO retrieveData(){
        return module1Service.retrieveData();
    }
}

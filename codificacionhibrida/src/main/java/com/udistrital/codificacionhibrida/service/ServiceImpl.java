package com.udistrital.codificacionhibrida.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements IServiceCodificacion{

    @Override
    public String returnMessage() {
        return "Hello World";
    }


}

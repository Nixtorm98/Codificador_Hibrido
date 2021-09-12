package com.udistrital.codificacionhibrida.controller;

import com.udistrital.codificacionhibrida.dtos.HelloWorldDto;
import com.udistrital.codificacionhibrida.service.IServiceCodificacion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CodificacionRestController {

    private IServiceCodificacion iServiceCodificacion;

    private CodificacionRestController(IServiceCodificacion iServiceCodificacion){
        this.iServiceCodificacion = iServiceCodificacion;
    }

    @GetMapping("/helloWorld")
    public ResponseEntity<HelloWorldDto> getHelloWorld(){
        HelloWorldDto helloWorldDto = new HelloWorldDto();
        helloWorldDto.setMessage(iServiceCodificacion.returnMessage());
        return new ResponseEntity<>(helloWorldDto, HttpStatus.OK);
    }

}

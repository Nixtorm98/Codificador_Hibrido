package com.udistrital.codificacionhibrida.controller;

import com.udistrital.codificacionhibrida.dtos.*;
import com.udistrital.codificacionhibrida.exception.InvalidLengthException;
import com.udistrital.codificacionhibrida.service.IServiceCodificacion;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

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

    @PostMapping("/encode")
    public ResponseEntity<CodificacionResponseDto> getEncode(@Valid @RequestBody CodificacionRequestDto codificacionRequestDto){
        return new ResponseEntity<>(iServiceCodificacion.ObtenerMensajeCodificado(codificacionRequestDto.getMensaje()), HttpStatus.OK);
    }

    @PostMapping("/decode")
    public ResponseEntity<DecodificacionResponseDto> getDecode(@Valid @RequestBody DecodificacionRequestDto decodificacionRequest) throws InvalidLengthException {
        return new ResponseEntity<>(iServiceCodificacion.ObtenerMensajeDecodificado(decodificacionRequest.getMensajeCodificado()), HttpStatus.OK);
    }
}

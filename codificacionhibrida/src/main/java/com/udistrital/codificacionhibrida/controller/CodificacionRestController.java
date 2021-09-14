package com.udistrital.codificacionhibrida.controller;

import com.udistrital.codificacionhibrida.dtos.*;
import com.udistrital.codificacionhibrida.exception.ErrorDto;
import com.udistrital.codificacionhibrida.exception.InvalidLengthException;
import com.udistrital.codificacionhibrida.service.IServiceCodificacion;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class CodificacionRestController {

    private IServiceCodificacion iServiceCodificacion;

    private CodificacionRestController(IServiceCodificacion iServiceCodificacion){
        this.iServiceCodificacion = iServiceCodificacion;
    }

    @Operation(summary = "Obtiene el mensaje original y lo codifica mediante codificación híbrida")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "El mensaje se codificó correctamente",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CodificacionResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "El request contiene algún valor no valido",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))}),
            @ApiResponse(responseCode = "500", description = "Ocurrió un error interno al realizar la petición",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))}),
    })
    @PostMapping(value = "/encode", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CodificacionResponseDto> getEncode(@Valid @RequestBody CodificacionRequestDto codificacionRequestDto){
        return new ResponseEntity<>(iServiceCodificacion.ObtenerMensajeCodificado(codificacionRequestDto.getMensaje()), HttpStatus.OK);
    }

    @Operation(summary = "Obtiene el mensaje codificado y lo decodifica mediante codificación híbrida")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "El mensaje se decodificó correctamente",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CodificacionResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "El request contiene algún valor no valido",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))}),
            @ApiResponse(responseCode = "500", description = "Ocurrió un error interno al realizar la petición",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorDto.class))}),
    })
    @PostMapping(value = "/decode", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DecodificacionResponseDto> getDecode(@Valid @RequestBody DecodificacionRequestDto decodificacionRequest) throws InvalidLengthException {
        return new ResponseEntity<>(iServiceCodificacion.ObtenerMensajeDecodificado(decodificacionRequest.getMensajeCodificado()), HttpStatus.OK);
    }
}

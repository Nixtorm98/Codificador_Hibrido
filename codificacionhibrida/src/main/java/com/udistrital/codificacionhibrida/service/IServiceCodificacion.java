package com.udistrital.codificacionhibrida.service;

import com.udistrital.codificacionhibrida.dtos.CodificacionResponseDto;
import com.udistrital.codificacionhibrida.dtos.DecodificacionResponseDto;
import com.udistrital.codificacionhibrida.exception.InvalidLengthException;

public interface IServiceCodificacion {

    String returnMessage();

    CodificacionResponseDto ObtenerMensajeCodificado(String mensaje);

    DecodificacionResponseDto ObtenerMensajeDecodificado(String mensaje) throws InvalidLengthException;
}

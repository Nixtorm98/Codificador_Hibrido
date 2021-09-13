package com.udistrital.codificacionhibrida.service;

import com.udistrital.codificacionhibrida.dtos.CodificacionResponse;
import com.udistrital.codificacionhibrida.dtos.DecodificacionResponse;

public interface IServiceCodificacion {

    String returnMessage();

    CodificacionResponse ObtenerMensajeCodificado(String mensaje);

    DecodificacionResponse ObtenerMensajeDecodificado(String mensaje);
}

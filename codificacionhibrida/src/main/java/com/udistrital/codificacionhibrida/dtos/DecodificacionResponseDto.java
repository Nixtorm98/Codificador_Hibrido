package com.udistrital.codificacionhibrida.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DecodificacionResponseDto {

    private String mensajeDecodificado;

    private String mensajeMorse;

}

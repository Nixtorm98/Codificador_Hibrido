package com.udistrital.codificacionhibrida.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecodificacionRequest {
    private String mensajeCodificado;
}

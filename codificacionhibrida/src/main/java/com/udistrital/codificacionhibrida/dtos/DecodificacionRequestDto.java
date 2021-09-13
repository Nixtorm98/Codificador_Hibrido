package com.udistrital.codificacionhibrida.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecodificacionRequestDto {
    @NotEmpty(message = "El campo no puede estar vacío.")
    @Pattern(regexp = "^[A-Za-z0-9=]*$", message = "El mensaje contiene caracteres no permitidos")
    private String mensajeCodificado;
}

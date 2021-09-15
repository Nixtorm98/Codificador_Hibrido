package com.udistrital.codificacionhibrida.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodificacionRequestDto {

    @NotEmpty(message = "El campo no puede estar vacío.")
    @Pattern(regexp = "^[A-Za-z0-9\u00f1\u00d1,.!;?¿¡_():á-úÁ-Ú]+( +[A-Za-z0-9\u00f1\u00d1,.!;?¿¡_():á-úÁ-Ú]+)*$", message = "El mensaje contiene caracteres no permitidos")
    private String mensaje;

}

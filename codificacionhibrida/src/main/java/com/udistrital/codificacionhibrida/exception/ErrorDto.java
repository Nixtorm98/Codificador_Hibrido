package com.udistrital.codificacionhibrida.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto {

    private String cause;
    private String message;
    private LocalDate date;

}

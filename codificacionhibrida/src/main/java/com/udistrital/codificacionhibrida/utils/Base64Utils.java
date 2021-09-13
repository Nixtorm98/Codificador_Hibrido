package com.udistrital.codificacionhibrida.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Utils {

    public static String convertirTextoABase64(String cadena){
        return Base64.getEncoder().encodeToString(cadena.getBytes(StandardCharsets.UTF_8));
    }

    public static String convertirBase64ATexto(String cadena){
        return new String(Base64.getDecoder().decode(cadena));
    }
}

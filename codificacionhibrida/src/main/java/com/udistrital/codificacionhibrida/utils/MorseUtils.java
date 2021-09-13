package com.udistrital.codificacionhibrida.utils;

import java.util.Arrays;
import java.util.HashMap;

public class MorseUtils {

    public static String convertirMorseALetras(String cadena){
        String[] mensajeFraccionado = cadena.split("   ");
        StringBuilder palabraCompleta = new StringBuilder();
        for(String m : mensajeFraccionado){
            palabraCompleta.append(morseAPalabra(m));
        }
        return palabraCompleta.toString().trim();
    }

    public static String convertirFraseAMorse(String frase){
        String[] mensajeFraccionado = frase.toUpperCase().split(" ");
        StringBuilder palabraCompleta = new StringBuilder();
        for(String m : mensajeFraccionado){
            palabraCompleta.append(palabraAMorse(m));
        }
        return palabraCompleta.toString().trim();
    }

    public static String palabraAMorse(String palabra){
        String mensaje[] = palabra.split("");
        //System.out.println(Arrays.toString(mensaje));
        HashMap<String,String> morse = CrearMapCodigoMorse.getLetterToMorse();
        StringBuilder cadena = new StringBuilder();
        for(String m : mensaje){
            cadena.append((morse.get(m) == null) ? "" : morse.get(m));
            cadena.append(" ");
        }
        cadena.append("  ");
        return cadena.toString();
    }

    public static String morseAPalabra(String palabra){
        String mensaje[] = palabra.split(" ");
        //System.out.println(Arrays.toString(mensaje));
        HashMap<String,String> morse = CrearMapCodigoMorse.getMorseToLetter();
        StringBuilder cadena = new StringBuilder();
        for(String m : mensaje){
            cadena.append((morse.get(m) == null) ? "" : morse.get(m));
        }
        cadena.append(" ");
        return cadena.toString();
    }

}

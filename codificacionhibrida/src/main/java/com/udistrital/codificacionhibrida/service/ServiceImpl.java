package com.udistrital.codificacionhibrida.service;
import com.udistrital.codificacionhibrida.dtos.CodificacionResponseDto;
import com.udistrital.codificacionhibrida.dtos.DecodificacionResponseDto;
import com.udistrital.codificacionhibrida.exception.InvalidLengthException;
import com.udistrital.codificacionhibrida.utils.Base64Utils;
import com.udistrital.codificacionhibrida.utils.MorseUtils;
import org.springframework.stereotype.Service;

import java.util.Locale;


@Service
public class ServiceImpl implements IServiceCodificacion{

    @Override
    public CodificacionResponseDto ObtenerMensajeCodificado(String mensaje) {
        CodificacionResponseDto codificacionResponse = new CodificacionResponseDto();
        String mensajemorse = MorseUtils.convertirFraseAMorse(remplazarSimbolosNoConocidos(mensaje.toLowerCase()));
        String mensajeBase64 = Base64Utils.convertirTextoABase64(mensajemorse);
        codificacionResponse.setMensajeMorseCodificado("1. Morse: "+ mensajemorse);
        codificacionResponse.setMensajeConvertido("2. Base64: "+ mensajeBase64);
        return codificacionResponse;
    }

    @Override
    public DecodificacionResponseDto ObtenerMensajeDecodificado(String mensaje) throws InvalidLengthException {
        DecodificacionResponseDto decodificacionResponse = new DecodificacionResponseDto();
        String mensajemorse = Base64Utils.convertirBase64ATexto(mensaje);
        String mensajeFinal = MorseUtils.convertirMorseALetras(mensajemorse);
        if(mensajeFinal == null || mensajeFinal.isEmpty()){
            throw new InvalidLengthException("El mensaje no pudo ser decodificado, revise el tamaño o contenido");
        }
        decodificacionResponse.setMensajeDecodificado("1. Base 64 a morse : "+ mensajemorse);
        decodificacionResponse.setMensajeMorse("2. Morse a texto original: "+ mensajeFinal);
        return decodificacionResponse;
    }

    private String remplazarSimbolosNoConocidos(String mensaje){
       String mensajesina = mensaje.replaceAll("á","a");
       String mensajesine = mensajesina.replaceAll("é","e");
       String mensajesini = mensajesine.replaceAll("í","i");
       String mensajesino = mensajesini.replaceAll("ó","o");
       String mensajesinu = mensajesino.replaceAll("ú","u");
       String mensajesinsignos = mensajesinu.replaceAll("¿¡-_()","");
       return mensajesinsignos;
    }
}

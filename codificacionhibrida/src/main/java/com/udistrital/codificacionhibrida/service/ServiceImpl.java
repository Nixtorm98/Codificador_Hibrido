package com.udistrital.codificacionhibrida.service;
import com.udistrital.codificacionhibrida.dtos.CodificacionResponse;
import com.udistrital.codificacionhibrida.dtos.DecodificacionResponse;
import com.udistrital.codificacionhibrida.utils.MorseUtils;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements IServiceCodificacion{

    @Override
    public String returnMessage() {
        return "Hello World";
    }

    @Override
    public CodificacionResponse ObtenerMensajeCodificado(String mensaje) {
        CodificacionResponse codificacionResponse = new CodificacionResponse();
        codificacionResponse.setMensajeConvertido("El mensaje codificado es: "+ MorseUtils.convertirFraseAMorse(mensaje));
        return codificacionResponse;
    }

    @Override
    public DecodificacionResponse ObtenerMensajeDecodificado(String mensaje) {
        DecodificacionResponse decodificacionResponse = new DecodificacionResponse();
        decodificacionResponse.setMensajeDecodificado("El mensaje decodificado es: "+MorseUtils.convertirMorseALetras(mensaje));
        return decodificacionResponse;
    }
}

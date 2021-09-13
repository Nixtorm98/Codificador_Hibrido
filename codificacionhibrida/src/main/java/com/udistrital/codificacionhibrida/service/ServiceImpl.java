package com.udistrital.codificacionhibrida.service;
import com.udistrital.codificacionhibrida.dtos.CodificacionResponse;
import com.udistrital.codificacionhibrida.dtos.DecodificacionResponse;
import com.udistrital.codificacionhibrida.utils.Base64Utils;
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
        String mensajemorse = MorseUtils.convertirFraseAMorse(mensaje);
        String mensajeBase64 = Base64Utils.convertirTextoABase64(mensajemorse);
        codificacionResponse.setMensajeConvertido("El mensaje codificado es: "+ mensajeBase64);
        return codificacionResponse;
    }

    @Override
    public DecodificacionResponse ObtenerMensajeDecodificado(String mensaje) {
        DecodificacionResponse decodificacionResponse = new DecodificacionResponse();
        String mensajemorse = Base64Utils.convertirBase64ATexto(mensaje);
        String mensajeFinal = MorseUtils.convertirMorseALetras(mensajemorse);
        decodificacionResponse.setMensajeDecodificado("El mensaje decodificado es: "+mensajeFinal);
        return decodificacionResponse;
    }
}

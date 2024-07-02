package com.example.Foro_Hub.domain.respuesta.validaciones.actualizar;

import com.example.Foro_Hub.domain.respuesta.ActualizarRespuestaDTO;
import com.example.Foro_Hub.domain.respuesta.Respuesta;
import com.example.Foro_Hub.domain.respuesta.RespuestaRepository;
import com.example.Foro_Hub.domain.topico.Estado;
import com.example.Foro_Hub.domain.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SolucionDuplicada implements ValidarRespuestaActualizada{

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validate(ActualizarRespuestaDTO data, Long respuestaId) {
       if (data.solucion()){
           Respuesta respuesta = respuestaRepository.getReferenceById(respuestaId);
           var topicoResuelto = topicoRepository.getReferenceById(respuesta.getTopico().getId());
           if (topicoResuelto.getEstado() == Estado.CLOSED){
               throw new ValidationException("Este topico ya esta solucionado.");
           }
       }
    }
}



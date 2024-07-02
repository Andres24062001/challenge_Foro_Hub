package com.example.Foro_Hub.domain.respuesta.validaciones.actualizar;

import com.example.Foro_Hub.domain.respuesta.ActualizarRespuestaDTO;

public interface ValidarRespuestaActualizada {

    public void validate(ActualizarRespuestaDTO data, Long respuestaId);

}

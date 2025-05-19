package com.aplicacion.inventariado.servicio;

import org.springframework.http.ResponseEntity;

import com.aplicacion.inventariado.modelo.Categoria;
import com.aplicacion.inventariado.respuesta.CategoriaRespuestaRest;

public interface ICategoriaServicio {
    public ResponseEntity<CategoriaRespuestaRest> buscar();
    public ResponseEntity<CategoriaRespuestaRest> buscarId(Long id);
    public ResponseEntity<CategoriaRespuestaRest> guardar(Categoria categoria);

}

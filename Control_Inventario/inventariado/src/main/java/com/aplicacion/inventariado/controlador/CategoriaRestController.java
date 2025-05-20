package com.aplicacion.inventariado.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aplicacion.inventariado.modelo.Categoria;
import com.aplicacion.inventariado.respuesta.CategoriaRespuestaRest;
import com.aplicacion.inventariado.servicio.ICategoriaServicio;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class CategoriaRestController {

    @Autowired
    private ICategoriaServicio servicio;
    
    @GetMapping("/categorias")
    public ResponseEntity<CategoriaRespuestaRest> buscarCategorias(){
        ResponseEntity<CategoriaRespuestaRest> respuesta = servicio.buscar();
        return respuesta;
    }
   
    @GetMapping("/categorias/{id}")
    public ResponseEntity<CategoriaRespuestaRest> buscarCategoriasId(
            @PathVariable Long id){
        ResponseEntity<CategoriaRespuestaRest> respuesta = servicio.buscarId(id);
        return respuesta;
    }

    @PostMapping("/categorias")
    public ResponseEntity<CategoriaRespuestaRest> guardarCategoria(
            @RequestBody Categoria categoria){
        ResponseEntity<CategoriaRespuestaRest> respuesta = servicio.guardar(categoria);
        return respuesta;
    }
    
    @PutMapping("/categorias/{id}")
    public ResponseEntity<CategoriaRespuestaRest> actualizarCategoria(
            @RequestBody Categoria categoria, @PathVariable Long id){
        ResponseEntity<CategoriaRespuestaRest> respuesta = servicio.actualizar(categoria, id);
        return respuesta;
    }
    
    @DeleteMapping("/categorias/eliminar/{id}")
    public ResponseEntity<CategoriaRespuestaRest> eliminarCategoria(
            @PathVariable Long id){
        ResponseEntity<CategoriaRespuestaRest> respuesta = servicio.eliminar(id);
        return respuesta;
    }
   
}

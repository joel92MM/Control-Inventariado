package com.aplicacion.inventariado.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aplicacion.inventariado.dao.ICategoryDAO;
import com.aplicacion.inventariado.modelo.Categoria;
import com.aplicacion.inventariado.respuesta.CategoriaRespuestaRest;

@Service
public class CategoriaServiceImpl implements ICategoriaServicio{
    @Autowired
    private ICategoryDAO categoriaDAO;
    
    @Override
    @Transactional(readOnly=true)
    public ResponseEntity<CategoriaRespuestaRest> buscar() {
        // TODO Auto-generated method stub
        CategoriaRespuestaRest response = new CategoriaRespuestaRest();
        try {
            List<Categoria> categoria = (List<Categoria>)categoriaDAO.findAll();
            response.getCategoriaRespuesta().setCategoria(categoria);
            response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
        } catch (Exception e) {
            // TODO: handle exception
            response.setMetadata("Respuesta no ok", "-1", "Error al consultar");
            e.getStackTrace();
            return new ResponseEntity<CategoriaRespuestaRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<CategoriaRespuestaRest>(response, HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly=true)
    public ResponseEntity<CategoriaRespuestaRest> buscarId(Long id) {
        // TODO Auto-generated method stub
        CategoriaRespuestaRest response = new CategoriaRespuestaRest();
        List<Categoria> listaCategoria = new ArrayList<>(); 
        try {
            Optional<Categoria> categoria = categoriaDAO.findById(id);
            if(categoria.isPresent()){
                listaCategoria.add(categoria.get());
                response.getCategoriaRespuesta().setCategoria(listaCategoria);
                response.setMetadata("Respuesta ok", "00", "Categoria encontrada");
    
            }else{
                response.setMetadata("Respuesta nok", "-1", "Error al consultr por id");   
                return new ResponseEntity<CategoriaRespuestaRest>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.setMetadata("Respuesta no ok", "-1", "Error al consultar por id");
            e.getStackTrace();
            return new ResponseEntity<CategoriaRespuestaRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
        return new ResponseEntity<CategoriaRespuestaRest>(response, HttpStatus.OK);
       }

    @Override
    @Transactional
    public ResponseEntity<CategoriaRespuestaRest> guardar(Categoria categoria) {
   
        // TODO Auto-generated method stub
        CategoriaRespuestaRest response = new CategoriaRespuestaRest();
        List<Categoria> lista = new ArrayList<>();
        try {
            Categoria categoriaGuardar = categoriaDAO.save(categoria);

            if (categoriaGuardar != null) {
                lista.add(categoriaGuardar);
                response.getCategoriaRespuesta().setCategoria(lista);
                response.setMetadata("Respuesta ok", "00", "Categoria guardada");
            } else {
                response.setMetadata("Respuesta no ok", "-1", "Error al guardar categoria");
                return new ResponseEntity<CategoriaRespuestaRest>(response, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            // TODO: handle exception
            response.setMetadata("Respuesta no ok", "-1", "Error al guardar categoria");
            e.getStackTrace();
            return new ResponseEntity<CategoriaRespuestaRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<CategoriaRespuestaRest>(response, HttpStatus.OK);
    }

}

package com.aplicacion.inventariado.dao;

import java.util.Locale.Category;

import org.springframework.data.repository.CrudRepository;

import com.aplicacion.inventariado.modelo.Categoria;

public interface ICategoryDAO extends CrudRepository<Categoria, Long>{
    

}

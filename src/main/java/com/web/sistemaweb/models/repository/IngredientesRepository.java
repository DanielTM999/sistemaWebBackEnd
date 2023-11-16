package com.web.sistemaweb.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.sistemaweb.models.Ingredientes;

@Repository
public interface IngredientesRepository extends JpaRepository<Ingredientes, Long>{
    
}

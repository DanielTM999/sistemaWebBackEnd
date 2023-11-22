package com.web.sistemaweb.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.sistemaweb.models.Comanda;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Long>{
    
}

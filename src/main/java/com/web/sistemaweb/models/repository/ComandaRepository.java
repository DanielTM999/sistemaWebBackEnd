package com.web.sistemaweb.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.sistemaweb.models.Comanda;

public interface ComandaRepository extends JpaRepository<Comanda, Long>{
    
}

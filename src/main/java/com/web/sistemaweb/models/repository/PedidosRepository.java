package com.web.sistemaweb.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.sistemaweb.models.Pedidos;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long>{
    
}

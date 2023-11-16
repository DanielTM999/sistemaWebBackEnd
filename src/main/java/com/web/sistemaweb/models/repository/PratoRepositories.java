package com.web.sistemaweb.models.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.web.sistemaweb.components.TypePrato;
import com.web.sistemaweb.models.Prato;

@Repository
public interface PratoRepositories extends JpaRepository<Prato, Long>{
    Prato findByNome(String nome);
    List<Prato> findByTypePrato(TypePrato typePrato);
}

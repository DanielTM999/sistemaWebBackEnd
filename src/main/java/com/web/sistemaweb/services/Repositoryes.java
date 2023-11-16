package com.web.sistemaweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.sistemaweb.models.repository.ComandaRepository;
import com.web.sistemaweb.models.repository.IngredientesRepository;
import com.web.sistemaweb.models.repository.PedidosRepository;
import com.web.sistemaweb.models.repository.PratoRepositories;

import lombok.Getter;

@Getter
@Service
public class Repositoryes {
    
    @Autowired
    private PratoRepositories pratoRepositories;

    @Autowired
    private IngredientesRepository ingredientesRepository;

    @Autowired
    private PedidosRepository pedidosRepository;

    @Autowired
    private ComandaRepository comandaRepository;

}

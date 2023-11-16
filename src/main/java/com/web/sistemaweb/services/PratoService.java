package com.web.sistemaweb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.web.sistemaweb.components.TypePrato;
import com.web.sistemaweb.components.dto.req.PratoDto;
import com.web.sistemaweb.components.dto.res.PratoRes;
import com.web.sistemaweb.models.Ingredientes;
import com.web.sistemaweb.models.Prato;

@Service
public class PratoService {

    public Prato CreatePrato(PratoDto req){
        List<Ingredientes> ingredientes = new ArrayList<>();
        Prato prato = new Prato();
        prato.setNome(req.getNomePrato());
        prato.setTypePrato(TypePrato.fromDescricao(req.getType()));

        for (String element : req.getIngredientes()) {
            Ingredientes ing = new Ingredientes();
            ing.setNomeIngrediente(element);
            ing.setPrato(prato); 
            ingredientes.add(ing);
        }
        prato.setIngredientes(ingredientes);
        return prato;
    }

    public PratoRes createpratosRes(Prato prato){
        return new PratoRes(prato);
    }
}

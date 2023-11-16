package com.web.sistemaweb.components.dto.res;

import java.util.ArrayList;
import java.util.List;

import com.web.sistemaweb.models.Prato;

import lombok.Data;

@Data
public class PratoRes {
    private long id;
    private String nome;
    List<String> ingredientes;

    public PratoRes(Prato prato){
        ingredientes = new  ArrayList<>();
        id = prato.getId();
        nome = prato.getNome();
        prato.getIngredientes().forEach(e -> ingredientes.add(e.getNomeIngrediente())); 
    }
}

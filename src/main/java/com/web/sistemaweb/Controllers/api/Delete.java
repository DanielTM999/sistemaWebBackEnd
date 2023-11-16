package com.web.sistemaweb.Controllers.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.sistemaweb.models.Comanda;
import com.web.sistemaweb.models.Prato;
import com.web.sistemaweb.services.Repositoryes;

@RestController
@RequestMapping("delete/")
public class Delete {

    @Autowired
    private Repositoryes repositoryes;
    
    @DeleteMapping("prato/{id}")
    public void DeletePrato(@PathVariable String id){
        Optional<Prato> prato = repositoryes.getPratoRepositories().findById(Long.parseLong(id));
        if(prato.isPresent()){
            repositoryes.getPratoRepositories().delete(prato.get());
        }
    }

    @DeleteMapping("pedido/{id}")
    public void DeletePedido(@PathVariable String id){
        Optional<Comanda> comanda = repositoryes.getComandaRepository().findById(Long.parseLong(id));
        if(comanda.isPresent()){
            repositoryes.getComandaRepository().delete(comanda.get());
        }
    }

}

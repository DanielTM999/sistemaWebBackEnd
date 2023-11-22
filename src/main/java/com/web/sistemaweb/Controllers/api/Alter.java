package com.web.sistemaweb.Controllers.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.web.sistemaweb.components.dto.req.AlterAddDto;
import com.web.sistemaweb.components.dto.req.AlterComandaDto;
import com.web.sistemaweb.models.Comanda;
import com.web.sistemaweb.services.ComandaServices;
import com.web.sistemaweb.services.Repositoryes;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/alter")
public class Alter {

    @Autowired
    private Repositoryes repositoryes;

    @Autowired
    private ComandaServices comandaServices;
    
    @PostMapping("comanda")
    public void alterComanda(@RequestBody AlterComandaDto req){
        Optional<Comanda> comanda = repositoryes.getComandaRepository().findById(req.getId());
        System.out.println(req.getRemoves());
        if(comanda.isPresent()){
            Comanda elementToAlter = comandaServices.AlterComanda(comanda.get(), req);
            repositoryes.getComandaRepository().save(elementToAlter); 
        }
    }

    @PostMapping("comanda/add")
    public void addinAlter(@RequestBody @Valid AlterAddDto req){
        Optional<Comanda> comanda = repositoryes.getComandaRepository().findById(req.getId());
        if(comanda.isPresent()){
            Comanda elementToAlter = comandaServices.alterAdd(comanda.get(), req);
            repositoryes.getComandaRepository().save(elementToAlter); 
        }
    }

}

package com.web.sistemaweb.Controllers.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.sistemaweb.components.dto.req.PedidosReq;
import com.web.sistemaweb.components.dto.req.PratoDto;
import com.web.sistemaweb.services.ComandaServices;
import com.web.sistemaweb.services.PratoService;
import com.web.sistemaweb.services.Repositoryes;

import jakarta.validation.Valid;

@RestController
@RequestMapping("add/")
public class New {

    @Autowired
    private Repositoryes repositoryes;

    @Autowired
    private PratoService pratoService;

    @Autowired
    private ComandaServices comandaServices;
    
    @PostMapping("prato")
    public ResponseEntity<String> AddNewPrato(@Valid @RequestBody PratoDto req, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder("Erros de validação:\n");
            bindingResult.getAllErrors().forEach(error -> errorMessage.append(error.getDefaultMessage()).append("\n"));
            return new ResponseEntity<>(errorMessage.toString(), HttpStatus.BAD_REQUEST);
        }
        repositoryes.getPratoRepositories().save(pratoService.CreatePrato(req));
        return new ResponseEntity<>("Prato adicionado com sucesso", HttpStatus.OK);
    }

    @PostMapping("pedido")
    public ResponseEntity<String> AddNewPedido(@Valid @RequestBody PedidosReq req, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder("Erros de validação:\n");
            bindingResult.getAllErrors().forEach(error -> errorMessage.append(error.getDefaultMessage()).append("\n"));
            return new ResponseEntity<>(errorMessage.toString(), HttpStatus.BAD_REQUEST);
        }
        repositoryes.getComandaRepository().save(comandaServices.CreatePedido(req));
         return new ResponseEntity<>("", HttpStatus.OK);
    }

}

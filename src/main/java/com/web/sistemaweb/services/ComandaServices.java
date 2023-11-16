package com.web.sistemaweb.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.sistemaweb.components.dto.req.PedidosReq;
import com.web.sistemaweb.components.dto.req.SubPedidos;
import com.web.sistemaweb.models.Comanda;
import com.web.sistemaweb.models.Pedidos;
import com.web.sistemaweb.models.Prato;

@Service
public class ComandaServices {

    @Autowired
    private Repositoryes repositoryes;
    
    public Comanda CreatePedido(PedidosReq req){
        Comanda comanda = new Comanda();
        List<Pedidos> pedidos = new ArrayList<>();
         
        for (SubPedidos element : req.getPedidos()) {
            Pedidos pedido = new Pedidos();
            pedido.setComanda(comanda);
            Optional<Prato> pr = repositoryes.getPratoRepositories().findById(element.getId());
            if(pr.isPresent()){
                pedido.setPrato(pr.get());
            }
            pedidos.add(pedido);
        }
        comanda.setPedidos(pedidos);
        
        return comanda;
    }

}

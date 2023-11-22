package com.web.sistemaweb.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.sistemaweb.components.dto.req.AlterAddDto;
import com.web.sistemaweb.components.dto.req.AlterComandaDto;
import com.web.sistemaweb.components.dto.req.PedidosReq;
import com.web.sistemaweb.components.dto.req.SubPedidos;
import com.web.sistemaweb.components.dto.req.AlterAddDto.AddListAlterIten;
import com.web.sistemaweb.components.dto.req.AlterComandaDto.Pratoinfos;
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

    public Comanda AlterComanda(Comanda comanda, AlterComandaDto req){
        deleteIdRes(req);
        List<Pedidos> pedidos = new ArrayList<>();

        for (Pratoinfos info : req.getPratoinfos()) {
            Optional<Pedidos> pedido = repositoryes.getPedidosRepository().findById(info.getId());
            if(pedido.isPresent()){
                pedidos.add(pedido.get());
            }
        }

        comanda.setPedidos(pedidos);

        return comanda;

    }

    public Comanda alterAdd(Comanda comanda, AlterAddDto req){
        List<Pedidos> pedidos = comanda.getPedidos();
        for (AddListAlterIten element : req.getElementList()) {
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

    private void deleteIdRes(AlterComandaDto req) {
       for (Long id : req.getRemoves()) {
            Optional<Pedidos> pedido = repositoryes.getPedidosRepository().findById(id);
            if(pedido.isPresent()){
                repositoryes.getPedidosRepository().delete(pedido.get());
            }
       }
    }

}

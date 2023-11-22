package com.web.sistemaweb.services;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
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
            Prato pr = repositoryes.getPratoRepositories().findById(element.getId()).orElseThrow(() ->  new ResponseStatusException(HttpStatus.BAD_REQUEST));
            pedido.setPrato(pr);
            pedidos.add(pedido);
        }
        comanda.setPedidos(pedidos);
        
        return comanda;
    }

    public Comanda AlterComanda(Comanda comanda, AlterComandaDto req){
        deleteIdRes(req);
        List<Pedidos> pedidos = new ArrayList<>();

        for (Pratoinfos info : req.getPratoinfos()) {
            Pedidos pedido = repositoryes.getPedidosRepository().findById(info.getId()).orElseThrow(() ->  new ResponseStatusException(HttpStatus.BAD_REQUEST));
            pedidos.add(pedido);
        }

        comanda.setPedidos(pedidos);

        return comanda;

    }

    public Comanda alterAdd(Comanda comanda, AlterAddDto req){
        List<Pedidos> pedidos = comanda.getPedidos();
        for (AddListAlterIten element : req.getElementList()) {
            Pedidos pedido = new Pedidos();
            pedido.setComanda(comanda);
            Prato pr = repositoryes.getPratoRepositories().findById(element.getId()).orElseThrow(() ->  new ResponseStatusException(HttpStatus.BAD_REQUEST));
            pedido.setPrato(pr);
            pedidos.add(pedido);
        }
        comanda.setPedidos(pedidos);

        return comanda;
    }

    private void deleteIdRes(AlterComandaDto req) {
       for (Long id : req.getRemoves()) {
            Pedidos pedido = repositoryes.getPedidosRepository().findById(id).orElseThrow(() ->  new ResponseStatusException(HttpStatus.BAD_REQUEST));
            repositoryes.getPedidosRepository().delete(pedido);
       }
    }

}

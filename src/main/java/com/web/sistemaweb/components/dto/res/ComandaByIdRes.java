package com.web.sistemaweb.components.dto.res;

import java.util.ArrayList;
import java.util.List;

import com.web.sistemaweb.models.Comanda;
import com.web.sistemaweb.models.Pedidos;
import com.web.sistemaweb.models.Prato;

import lombok.Data;

@Data
public class ComandaByIdRes {
    
    public long id;

    public List<Pratoinfo> pratoinfos;

    public ComandaByIdRes(Comanda comanda){
        pratoinfos = new ArrayList<>();
        this.id = comanda.getId();
        for(Pedidos prato : comanda.getPedidos()){
            Pratoinfo info = new Pratoinfo(prato.getPrato());
            pratoinfos.add(info);
        }
    }

    @Data
    private class Pratoinfo {
        private long id;
        private String nome;
        
        public Pratoinfo(Prato prato){
            this.id = prato.getId();
            this.nome = prato.getNome();
        } 
    }
}

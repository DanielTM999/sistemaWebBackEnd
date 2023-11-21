package com.web.sistemaweb.components.dto.res;

import java.util.ArrayList;
import java.util.List;

import com.web.sistemaweb.models.Comanda;
import com.web.sistemaweb.models.Pedidos;
import com.web.sistemaweb.models.Prato;

import lombok.Data;

@Data
public class PedidosRes {

    List<PedidosList> listaPedidos;

    public PedidosRes(List<Comanda> pedidos){
        listaPedidos = createInLIst(pedidos);

    }

     private List<PedidosList> createInLIst(List<Comanda> pedidosList){
        List<PedidosList> lista = new ArrayList<>();
        
        for (Comanda pedidos : pedidosList) {
            PedidosList p = new PedidosList();
            List<PratosListSub> subList = new ArrayList<>();
            String data = FormatData(pedidos.getDataComanda().toString());
            p.setData(data);
            p.setId(pedidos.getId());
            for (Pedidos pd : pedidos.getPedidos()) {
                Prato prato = pd.getPrato();
                if(prato != null){
                    PratosListSub listSub = new PratosListSub();
                    listSub.setTipo(prato.getTypePrato().toString());
                    listSub.setDescricao(prato.getNome());
                    subList.add(listSub);
                }
            }
            p.setItens(subList);
            lista.add(p);
        }

        return lista;
    }

    private String FormatData(String BaseData){
        String[] explode = BaseData.split("T");
        String dataFormat = "";
        dataFormat += "Data: "+explode[0]+" / ";
        dataFormat += "Hora: "+explode[1];
        dataFormat = dataFormat.substring(0, dataFormat.length()-7);
        return dataFormat;
    }

    @Data
    private class PedidosList {
        private long id;
        private String data;
        private List<PratosListSub> itens;

        
    }

    @Data
    private class PratosListSub {
        private String tipo;
        private String descricao;
    }
}

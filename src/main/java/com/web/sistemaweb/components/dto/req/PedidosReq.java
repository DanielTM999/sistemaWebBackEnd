package com.web.sistemaweb.components.dto.req;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PedidosReq {

    @NotNull(message = "A lista de Pedidos não pode ser nula")
    @NotEmpty(message = "A lista de Pedidos não pode estar vazia")
    private List<SubPedidos> pedidos;
}

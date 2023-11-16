package com.web.sistemaweb.components.dto.req;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SubPedidos {
    @NotBlank
    private String type;

    @NotBlank
    private long id;

    @NotBlank
    private String name;

}

package com.web.sistemaweb.components.dto.req;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PratoDto {
    @NotBlank
    private String nomePrato;

    @NotBlank
    private String type;

    @NotNull(message = "A lista de ingredientes não pode ser nula")
    @NotEmpty(message = "A lista de ingredientes não pode estar vazia")
    private List<String> ingredientes;
}

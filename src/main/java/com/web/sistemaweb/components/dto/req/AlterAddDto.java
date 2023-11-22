package com.web.sistemaweb.components.dto.req;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AlterAddDto {

    private long id;

    private List<AddListAlterIten> elementList;

    @Data
    public static class AddListAlterIten{
        @NotBlank
        private String type;

        @NotBlank
        private long id;

        @NotBlank
        private String name;
    }
}

package com.web.sistemaweb.components.dto.req;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AlterComandaDto {
    private long id;
    private List<Pratoinfos> pratoinfos;
    private List<Long> removes;

    @Data
    @NoArgsConstructor
    public static class Pratoinfos{
        private long id;
    }
}

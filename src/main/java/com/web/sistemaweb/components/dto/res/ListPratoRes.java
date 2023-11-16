package com.web.sistemaweb.components.dto.res;

import java.util.List;
import lombok.Data;

@Data
public class ListPratoRes {
    List<PratoRes> pratos;

    public ListPratoRes(List<PratoRes> list){
        pratos = list;
    }
}

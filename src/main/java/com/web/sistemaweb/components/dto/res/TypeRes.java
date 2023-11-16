package com.web.sistemaweb.components.dto.res;

import java.util.List;

import lombok.Data;

@Data
public class TypeRes {
    private List<String> types;

    public TypeRes(List<String> lista){
        types = lista;
    }

}

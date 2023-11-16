package com.web.sistemaweb.components;

public enum TypePrato {
    ENTRADA("entrada"),
    PRINCIPAL("principal"),
    SOBREMESA("sobremesa");

    private final String type;

    TypePrato(String type) {
        this.type = type;
    }

    public String getDescricao() {
        return type;
    }

    public static TypePrato fromDescricao(String descricao) {
        for (TypePrato status : TypePrato.values()) {
            if (status.type.equalsIgnoreCase(descricao)) {
                return status;
            }
        }
        throw new IllegalArgumentException("type inválido: " + descricao);
    }
}

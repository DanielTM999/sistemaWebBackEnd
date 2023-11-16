package com.web.sistemaweb.models;

import java.util.List;


import com.web.sistemaweb.components.TypePrato;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Prato {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "prato", cascade = CascadeType.ALL)
    private List<Ingredientes> ingredientes;

    @OneToMany(mappedBy = "prato", cascade = CascadeType.ALL)
    private List<Pedidos> pedidos;

    @Column(nullable = false)
    private TypePrato typePrato;
    
}

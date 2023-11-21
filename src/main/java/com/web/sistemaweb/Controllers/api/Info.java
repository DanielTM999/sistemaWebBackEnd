package com.web.sistemaweb.Controllers.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.web.sistemaweb.components.TypePrato;
import com.web.sistemaweb.components.dto.res.ComandaByIdRes;
import com.web.sistemaweb.components.dto.res.ListPratoRes;
import com.web.sistemaweb.components.dto.res.PedidosRes;
import com.web.sistemaweb.components.dto.res.PratoRes;
import com.web.sistemaweb.components.dto.res.TypeRes;
import com.web.sistemaweb.models.Comanda;
import com.web.sistemaweb.models.Prato;
import com.web.sistemaweb.services.PratoService;
import com.web.sistemaweb.services.Repositoryes;

@RestController
@RequestMapping("info/")
public class Info {

    @Autowired
    private Repositoryes repositoryes;

    @Autowired
    private PratoService pratoService;
   
    @GetMapping("getTypes/prato")
    public ResponseEntity<TypeRes> GetAllTypes(){
        List<String> typeList = new ArrayList<>();
        Arrays.asList(TypePrato.values()).forEach(e -> typeList.add(e.toString().toLowerCase()));

        return ResponseEntity.ok().body(new TypeRes(typeList));
    }

    @GetMapping("get/pratos")
    public ResponseEntity<ListPratoRes> GetAllPratos(){
        List<PratoRes> pratos = new ArrayList<>();
        for (Prato prato : repositoryes.getPratoRepositories().findAll()) {
            if(prato != null){
                pratos.add(pratoService.createpratosRes(prato));
            }
        }

        return ResponseEntity.ok().body(new ListPratoRes(pratos));
    }

    @GetMapping("get/pratos/bytype/{id}")
    public ResponseEntity<ListPratoRes> getPratosBytype(@PathVariable String id){
        TypePrato type = TypePrato.fromDescricao(id);

        List<PratoRes> pratos = new ArrayList<>();
        List<Prato> listPratos = repositoryes.getPratoRepositories().findByTypePrato(type);

        for (Prato prato : listPratos) {
            pratos.add(pratoService.createpratosRes(prato));
        }

        return ResponseEntity.ok().body(new ListPratoRes(pratos));
    }

    @GetMapping("get/comanda/byid/{id}")
    public ResponseEntity<ComandaByIdRes> getComandaByid(@PathVariable String id){
        Optional<Comanda> comanda = repositoryes.getComandaRepository().findById(Long.parseLong(id));
        if(comanda.isPresent()){
            return ResponseEntity.ok().body(new ComandaByIdRes(comanda.get()));
        }
        return ResponseEntity.badRequest().build();
    } 

    @GetMapping("get/pedidos")
    public ResponseEntity<PedidosRes> getAllPedidos(){
        List<Comanda> comanda = repositoryes.getComandaRepository().findAll();
        return ResponseEntity.ok().body(new PedidosRes(comanda));
    }

    

}

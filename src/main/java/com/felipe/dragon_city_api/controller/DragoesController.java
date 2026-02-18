package com.felipe.dragon_city_api.controller;

import com.felipe.dragon_city_api.model.DragaoModel;
import com.felipe.dragon_city_api.service.DragoesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DragoesController {
    private final DragoesService dragoesService;

    public DragoesController(DragoesService dragoesService) {
        this.dragoesService = dragoesService;
    }

    @GetMapping("")
    public List<DragaoModel> buscarTodos(){
        return dragoesService.listarDragoes();
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarPorId(@RequestParam Long id){
        return dragoesService.buscarDragaoPorID(id);
    }

    @GetMapping("/ordenar")
    public List<DragaoModel> ordenarLista(@RequestParam String criterio){
        return dragoesService.ordenarDragoes(criterio);
    }

    @PostMapping("")
    public List<DragaoModel> inserirDragoes(@RequestBody List<DragaoModel> novosDragoes) {
        return dragoesService.inserirDragoes(novosDragoes);
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<?> deletarDragoes(@RequestParam Long id) {
        return dragoesService.deletarDragao(id);
    }
}

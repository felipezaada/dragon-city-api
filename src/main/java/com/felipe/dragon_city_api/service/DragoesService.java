package com.felipe.dragon_city_api.service;

import com.felipe.dragon_city_api.model.DragaoModel;
import com.felipe.dragon_city_api.repository.DragoesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DragoesService {

    private final DragoesRepository dragoesRepository;

    public DragoesService(DragoesRepository dragoesRepository) {
        this.dragoesRepository = dragoesRepository;
    }

    public List<DragaoModel> listarDragoes() {
        return dragoesRepository.listarDragoes();
    }

    public ResponseEntity<DragaoModel> buscarDragaoPorID(Long id){
        Optional<DragaoModel> tempDragao = dragoesRepository.buscarDragaoPorID(id);
        return tempDragao.map(dragaoModel -> ResponseEntity.ok().body(dragaoModel))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public List<DragaoModel> ordenarDragoes(String criterio){
        return dragoesRepository.ordenarDragoes(criterio);
    }

    public List<DragaoModel> inserirDragoes(List<DragaoModel> novosDragoes) {
        return dragoesRepository.inserirDragoes(novosDragoes);
    }

    public ResponseEntity<?> deletarDragao(Long id) {
        if(!dragoesRepository.deletarDragaoLista(id)) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().build();
    }
}

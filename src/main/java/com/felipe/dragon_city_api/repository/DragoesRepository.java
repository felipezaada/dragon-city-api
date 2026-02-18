package com.felipe.dragon_city_api.repository;

import com.felipe.dragon_city_api.model.DragaoModel;
import com.felipe.dragon_city_api.util.DragoesQuickSort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DragoesRepository {

    List<DragaoModel> dragoesLista = new ArrayList<>();

    public List<DragaoModel> listarDragoes() {
        return dragoesLista;
    }

    public Optional<DragaoModel> buscarDragaoPorID(Long id) {
        return dragoesLista.stream().filter(dragao -> dragao.getId() == id).findFirst();
    }

    public List<DragaoModel> ordenarDragoes(String criterio){
        DragoesQuickSort.quickSort(dragoesLista, 0, dragoesLista.size() - 1, criterio.toUpperCase());
        return dragoesLista;
    }

    public List<DragaoModel> inserirDragoes(List<DragaoModel> novosDragoes) {
        dragoesLista.addAll(novosDragoes);
        return novosDragoes;
    }

    public boolean deletarDragaoLista(Long id) {
        return dragoesLista.removeIf(dragao -> dragao.getId() == id);
    }
}

package com.felipe.dragon_city_api.util;

import com.felipe.dragon_city_api.model.DragaoModel;

import java.util.List;

public class DragoesQuickSort {

    public static boolean comparaEntradaQuickSort(List<DragaoModel> dragoesList, int fim, int j, String criterio) {
        DragaoModel pivot = dragoesList.get(fim);
        DragaoModel dragaoJ = dragoesList.get(j);
        return switch (criterio) {
            case "NOME" -> dragaoJ.getNome().compareToIgnoreCase(pivot.getNome()) < 0;
            case "TIPO" -> dragaoJ.getTipo().compareToIgnoreCase(pivot.getTipo()) < 0;
            case "ID" -> dragaoJ.getId() < pivot.getId();
            default -> false;
        };
    }

    public static int partition(List<DragaoModel> dragoesList, int inicio, int fim, String criterio) {
        int i = inicio;

        for (int j = inicio; j < fim; j++) {
            if (comparaEntradaQuickSort(dragoesList, fim, j, criterio)) {
                DragaoModel aux = dragoesList.get(i);
                dragoesList.set(i, dragoesList.get(j));
                dragoesList.set(j, aux);
                i++;
            }
        }
        DragaoModel aux = dragoesList.get(i);
        dragoesList.set(i, dragoesList.get(fim));
        dragoesList.set(fim, aux);

        return i;
    }

    public static void quickSort(List<DragaoModel> dragoesList, int inicio, int fim, String criterio) {
        if (inicio < fim) {
            int p = partition(dragoesList, inicio, fim, criterio);
            quickSort(dragoesList, inicio, p - 1, criterio);
            quickSort(dragoesList, p + 1, fim, criterio);
        }
    }
}
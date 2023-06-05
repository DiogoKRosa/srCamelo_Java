/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelagem;

import java.util.ArrayList;

/**
 *
 * @author dsm-2
 */
public class QuickSort_Int {
    //Versão de Hoare do Quicksort
    //Facilita a vida: só pede o array como argumento
    public void quicksort(ArrayList<Tabela_Produto> A){        
        quicksort(A, 0, A.size() - 1);
    }
    
    //Quicksort de Hoare
    private void quicksort(ArrayList<Tabela_Produto> A, int inicio, int fim){        
        if(inicio < fim){
            //realiza a partição
            int q = partition(A, inicio, fim);
            //ordena a partição esquerda
            quicksort(A, inicio, q - 1);
            //ordena a partição direita
            quicksort(A, q + 1, fim);            
        }
    }
    
    //Método de partição
    private int partition(ArrayList<Tabela_Produto> A, int inicio, int fim){
        Tabela_Produto tbl = new Tabela_Produto();
        tbl=A.get(inicio);
        //o pivo é o elemento inicial
        float pivo = tbl.getValor();
        //índice i irá percorrer o array da esquerda para a direita
        int i = inicio + 1;
        //índice j irá percorrer o array da direita para a esquerda
        int j = fim;
        
        //O loop irá parar quando os índices se ultrapassarem
        while(i <= j){
            
            /*
             * Este laço irá parar quando encontrar algum elemento
             * à esquerda que é maior que o pivô, pois ele deveria estar na 
             * partição direita
             */
            while(i <= j && A.get(i).getValor() < pivo){
                i = i + 1;
            }
            /*
             * Esse laço irá parar quando encontrar algum elemento
             * à direira que é menor ou igual ao pivô, pois ele deveria estar na 
             * partição esquerda
             */
            while(i <= j && A.get(j).getValor() >= pivo){
                j = j - 1;
            }
            
            //se os índices não ultrapassarem, troca-os de posição
            if(i < j){
                swap(A, i, j);
            }
        }
        //coloca o pivô na posição de ordenação
        swap(A, inicio, j);
        return j; //retorna a posição do pivô
    }
    
    //método auxiliar para realizar as trocas de elementos
    private void swap(ArrayList<Tabela_Produto> A, int i, int j){
        Tabela_Produto temp = A.get(i);
        A.set((i), A.get(j));
        A.set(j, temp);
        
    }
}

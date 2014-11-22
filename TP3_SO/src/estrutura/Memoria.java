/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrutura;

import java.util.ArrayList;

/**
 *
 * @author gabriela
 */
public class Memoria {

    ArrayList<Bloco> memoria = new ArrayList<>();

    /**
     * Este metodo adiciona o bloco na memoria caso ela esteja vazia.
     * 
     * @param bloco, este bloco sera adicionado a memoria
     * @return true caso de pra adicionar, false caso contrario.
     */
    public boolean adicionarNaMemoria(Bloco bloco) {
        if (!isMemoriaCheia(bloco)) {
            memoria.add(bloco);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Este metodo verifica se a memoria ja esta cheia, ou seja, se ja temos
     * 1024 na memoria. Isso eh verificado fazendo um somatorio do tamanho de
     * todos os processos.
     *
     * @return true caso a memoria esteja cheia, false caso contrario.
     */
    public boolean isMemoriaCheia(Bloco bloco) {

        int tamanhoTotalMemoria = 0;

        for (Bloco b : memoria) {
            tamanhoTotalMemoria += b.getTamanho();
        }

        if ((tamanhoTotalMemoria+bloco.getTamanho()) > 1024) {
            return true;
        } else {
            return false;
        }
    }
    

    public ArrayList<Bloco> getMemoria() {
        return memoria;
    }

    public void setMemoria(ArrayList<Bloco> memoria) {
        this.memoria = memoria;
    }

}

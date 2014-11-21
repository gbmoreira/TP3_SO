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

    public void adicionarNaMemoria(Bloco bloco) {

    }

    /**
     * Este metodo verifica se a memoria ja esta cheia, ou seja, se ja temos 1024 na memoria.
     * Isso eh verificado fazendo um somatorio do tamanho de todos os processos.
     * 
     * @return true caso a memoria esteja cheia, false caso contrario.
     */
    public boolean isMemoriaCheia() {

        int tamanhoTotalMemoria = 0;

        for (Bloco bloco : memoria) {
            tamanhoTotalMemoria += bloco.processo.getTamanho();
        }

        if (tamanhoTotalMemoria >= 1024) {
            return true;
        } else {
            return false;
        }
    }

//    public Bloco procurarBlocoVazio() {
//
//    }

}

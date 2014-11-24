/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import estrutura.Bloco;
import estrutura.Memoria;

/**
 *
 * @author Gabriela
 */
public class FirstFit {

    Memoria memoria = new Memoria();

    public void executarFirstFit(Bloco bloco) {

        if (memoria.isMemoriaCheia(bloco)) {

            for (Bloco b : memoria.getMemoria()) {

                if ((b.isLivre()) && (b.getTamanho() < bloco.getTamanho())) {
                    b.setTamanho(this.divideBloco(b , bloco));
//                    memoria.adicionarNaMemoria(bloco); temos que informar o indice pra inserir na posicao correta
//                    memoria.adicionarNaMemoria(b);
                }
            }

        }
    }

    /**
     * Este metodo eh responsavel por quebrar o bloco em duas partes.

     * Como o bloco a ser inserido é menor do que o bloco de destino, ele
     * ocupara os primeiros espacos com o arquivo, sequencialmente, ate que todo
     * o bloco seja inserido. Assim teremos o bloco dividido em duas partes: uma
     * com o tamanho do bloco inserido, e a outra com o restante do espaco.
     *
     * 

     * 
     * @param blocoVazio 
     * @param blocoParaAlocar
     * 
     * @return o numero do novo tamanho do bloco vazio.
     */
    public int divideBloco(Bloco blocoVazio, Bloco blocoParaAlocar) {

        int tamanhoBlocoVazio = 0;

        tamanhoBlocoVazio = blocoVazio.getTamanho() - blocoParaAlocar.getTamanho();
        return tamanhoBlocoVazio;
    }

}

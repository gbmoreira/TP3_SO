/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import estrutura.Bloco;
import estrutura.Memoria;
import java.util.ArrayList;

/**
 *
 * @author Gabriela
 */
public class FirstFit {

    Memoria memoria = new Memoria();

    FirstFit(Memoria memoria) {
        this.memoria = memoria;
    }

    public void executarFirstFit(Bloco bloco) {

        ArrayList<Bloco> blocosVazios = new ArrayList<>();

        if (memoria.isMemoriaCheia(bloco)) {

            blocosVazios = memoria.getBlocosVazios();

            for (Bloco blocoVazio : blocosVazios) {
                int indiceNovoBloco;

                if (blocoVazio.getTamanho() > bloco.getTamanho()) {
                    blocoVazio.setTamanho(this.divideBloco(blocoVazio, bloco));

                    //if para saber qual posicao inserir na memoria
                    if (blocoVazio.getIndexInicioBloco() == 0) {
                        indiceNovoBloco = 0;
                    } else {
                        indiceNovoBloco = blocoVazio.getIndexInicioBloco();
                    }

                    blocoVazio.setIndexInicioBloco(indiceNovoBloco + 1);
                    blocoVazio.setLivre(true);
                    
                    memoria.adicionarNaMemoria(indiceNovoBloco, bloco);
                    memoria.atualizarIndicesMemoria();
                    break;                    
                }
            }
        }
    }

    /**
     * Este metodo eh responsavel por quebrar o bloco em duas partes.
     *
     * Como o bloco a ser inserido é menor do que o bloco de destino, ele
     * ocupara os primeiros espacos com o arquivo, sequencialmente, ate que todo
     * o bloco seja inserido. Assim teremos o bloco dividido em duas partes: uma
     * com o tamanho do bloco inserido, e a outra com o restante do espaco.
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

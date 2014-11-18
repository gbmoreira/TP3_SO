/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrutura;

/**
 *
 * @author Gabriela Nome do processo, tempo necessário para concluir sua
 * execução (segundos) e tamanho que ocupará em memória (em MB). Exemplo de
 * arquivo de entrada:
 */
public class Processo {

    private String nome;
    private double tempoExecucao;
    private int tamanho;

    Processo(String nome, double tempoExecucao, int tamanho) {
        this.nome = nome;
        this.tempoExecucao = tempoExecucao;
        this.tamanho = tamanho;
    }
}

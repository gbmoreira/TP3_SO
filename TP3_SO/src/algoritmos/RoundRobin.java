/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import estrutura.Arquivo;
import estrutura.Bloco;
import estrutura.Memoria;
import estrutura.Processo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José Renato
 */
public class RoundRobin {

    private double quantum = 5.0, tempoTotal = 0.0;
    private String nome, tempoTermino;
    private boolean fim = false;
    private Arquivo arquivo = new Arquivo();
    private ArrayList<Processo> listaProcesso = new ArrayList<Processo>();
    Memoria memoria = new Memoria();

    public void escalonar() {

        try {
            listaProcesso = arquivo.lerArquivo();
        } catch (IOException ex) {
            Logger.getLogger(RoundRobin.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (!fim) {

            for (int i = 0; i < listaProcesso.size(); i++) {
                Bloco bloco = new Bloco(listaProcesso.get(i));

                fim = true;
                if (listaProcesso.get(i).isPronto()) {
                    fim = true;
                    continue;
                }

                if (listaProcesso.get(i).getTempoExecucao() <= quantum) {
                    tempoTotal += listaProcesso.get(i).getTempoExecucao();
                    listaProcesso.get(i).setTempoFinal(tempoTotal);
                    listaProcesso.get(i).setPronto(true);
                    fim = false;
                    bloco.setLivre(false);
                } else {
                    tempoTotal += quantum;
                    listaProcesso.get(i).setTempoExecucao(listaProcesso.get(i).getTempoExecucao() - quantum);
                    fim = false;
                    bloco.setLivre(true);

                }

                if (memoria.adicionarNaMemoria(i,bloco)) {
                    System.out.println("Bloco adicionado!");
                } else {
                    FirstFit first = new FirstFit(memoria);
                    first.executarFirstFit(bloco);
                    System.out.println("Rode algum fit ai mano!");
                }

                System.out.println("");
            }
        }

        for (int i = 0; i < listaProcesso.size(); i++) {
            nome = listaProcesso.get(i).getNome();
            if (nome.endsWith("0")) {
                tempoTermino = arquivo.format(listaProcesso.get(i).getTempoFinal());
                arquivo.escreverArquivo(nome, tempoTermino, "RoundRobin");
            }
        }

    }

    /**
     * | Somente gets e sets |
     */
    public double getQuantum() {
        return quantum;
    }

    public void setQuantum(double quantum) {
        this.quantum = quantum;
    }

    public double getTempoTotal() {
        return tempoTotal;
    }

    public void setArquivo(Arquivo arquivo) {
        this.arquivo = arquivo;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import algoritmos.RoundRobin;
import estrutura.Arquivo;

/**
 *
 * @author gabriela
 */
public class Controlador {

    RoundRobin robin;
    Arquivo arquivo;
    String caminho;

    public Controlador(String caminho) {
        robin = new RoundRobin();
        arquivo = new Arquivo();
        this.caminho = caminho;
        this.executarRoundRobin();
    }

    public void executarRoundRobin() {
        arquivo.setCaminho(caminho);
        robin.setArquivo(arquivo);
        robin.escalonar();
    }

}

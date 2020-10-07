package cena;

import objetoJogo.Bastao;
import objetoJogo.Bola;
import objetoJogo.Jogador;

public class Jogo {
    public boolean jogoIniciado = false;
    public Bastao bastao;
    public Bola bola;
    public Jogador jogador;

    public Jogo(Bastao bastao, Bola bola, Jogador jogador) {
        this.bastao = bastao;
        this.bola = bola;
        this.jogador = jogador;
    }

    public void jogar() {
        if (this.jogoIniciado) {
            // Bastao
            this.bastao.gerar();

            // Bola
            this.bola.gerar();

            this.jogador.renderizarTexto();
            this.jogador.adicionarPontos();
        }
    }
}

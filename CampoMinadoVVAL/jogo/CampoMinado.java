package br.com.poli.CampoMinadoVVAL.jogo;

import br.com.poli.CampoMinadoVVAL.Jogador;
import br.com.poli.CampoMinadoVVAL.mapa.Mapa;
import br.com.poli.CampoMinadoVVAL.mapa.MapaDificil;
import br.com.poli.CampoMinadoVVAL.mapa.MapaFacil;
import br.com.poli.CampoMinadoVVAL.mapa.MapaMedio;

public class CampoMinado {
	private Jogador jogador;
	private Mapa mapa;
	private Dificuldade dificuldade;

	public CampoMinado(String nome, Dificuldade dificuldade) {
		// Construtor!!! c:
		this.jogador = new Jogador(nome);
		this.dificuldade = dificuldade;
		// Inicializa um novo mapa!
		switch (dificuldade) {
		case FACIL:
			this.mapa = new MapaFacil();
			break;
		case MEDIO:
			this.mapa = new MapaMedio();
			break;
		case DIFICIL:
			this.mapa = new MapaDificil();
			break;
		}

	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Mapa getMapa() {
		return mapa;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

	public Dificuldade getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
	}

}

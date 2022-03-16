package br.com.poli.CampoMinadoVVAL;

public class Jogador  implements Comparable<Jogador> {
	private int tempo;
	private String nome;

	public Jogador(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	@Override
	public int compareTo(Jogador novo) {
		if(this.tempo < novo.tempo) {
		return -1;	
		    	
		}
		if (this.tempo>novo.tempo) {
			return 1;
		}
		else {
			return 0;
		}
	}

}

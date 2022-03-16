package br.com.poli.CampoMinadoVVAL.mapa;

import java.util.ArrayList;
import java.util.List;

public class Celula {
	private boolean bandeira;
	private boolean bomba;
	private int qtdBombasVizinhas;
	private boolean visivel;
	private int linha; // inicializado pelo construtor
	private int coluna; // inicializado pelo construtor
	private List<Celula> vizinhos = new ArrayList<Celula>();
	private boolean bombaProvavel;
	private int qtCelulasVizinhasInvisiveis;
	private int qtBandeirasVizinhas;
	private int qtCelulasVizinhas;
	private int qtBombasProvaveis;
	private int qtSuspeitas;

	public Celula(int linha, int coluna) {
		this.bandeira = false;
		this.bomba = false;
		this.qtdBombasVizinhas = 0;
		this.visivel = false;
		this.linha = linha;
		this.coluna = coluna;
		this.bombaProvavel = false;
		this.qtCelulasVizinhas = 0;
		this.qtCelulasVizinhasInvisiveis = 0;
		this.qtBandeirasVizinhas = 0;
		this.qtBombasProvaveis = 0;
		this.qtSuspeitas = 0;

	}

	public int getQtSuspeitas() {
		return qtSuspeitas;
	}

	public void setQtSuspeitas(boolean reset) {
		if (!reset) {
			this.qtSuspeitas++;
		} else {
			this.qtSuspeitas = 0;
		}
	}

	public int getQtBombasProvaveis() {
		return qtBombasProvaveis;
	}

	public void setQtBombasProvaveis(boolean reset) {
		if (!reset) {
			this.qtBombasProvaveis++;
		} else {
			this.qtBombasProvaveis = 0;
		}
	}

	public int getQtCelulasVizinhasInvisiveis() {
		return qtCelulasVizinhasInvisiveis;
	}

	public void setQtCelulasVizinhasInvisiveis(boolean reset) {
		if (!reset) {
			this.qtCelulasVizinhasInvisiveis++;
		} else {
			this.qtCelulasVizinhasInvisiveis = 0;
		}
	}

	public int getQtBandeirasVizinhas() {
		return qtBandeirasVizinhas;
	}

	public void setQtBandeirasVizinhas(boolean reset) {
		if (!reset) {
			this.qtBandeirasVizinhas++;
		} else {
			this.qtBandeirasVizinhas = 0;
		}
	}

	public int getQtCelulasVizinhas() {
		return qtCelulasVizinhas;
	}

	public void setQtCelulasVizinhas(boolean reset) {
		if (!reset) {
			this.qtCelulasVizinhas++;
		} else {
			this.qtCelulasVizinhas = 0;
		}
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}

	public boolean isBandeira() {
		return bandeira;
	}

	public void setBandeira(boolean bandeira) {
		this.bandeira = bandeira;
	}

	public boolean isBomba() {
		return bomba;
	}

	public boolean isBombaProvavel() {
		return bombaProvavel;
	}

	public void setBomba(boolean bomba) {
		this.bomba = bomba;
	}

	public int getQtdBombasVizinhas() {
		return qtdBombasVizinhas;
	}

	public void setQtdBombasVizinhas(boolean reset) {
		if (!reset) {
			this.qtdBombasVizinhas++;
		} else {
			this.qtdBombasVizinhas = 0;
		}
	}

	public boolean isVisivel() {
		return visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

	public void setBombaProvavel(boolean provavel) {
		this.bombaProvavel = provavel;
	}

	public void buscarVizinhos(Celula[][] campo) {
		for (int w = -1; w < 2; w++) {
			for (int y = -1; y < 2; y++) {
				if (this.getLinha() + w >= 0 && this.getColuna() + y >= 0 && this.getLinha() + w < campo.length
						&& this.getColuna() + y < campo.length) {
					vizinhos.add(campo[this.getLinha() + w][this.getColuna() + y]);
				}
			}

		}
	}

	public boolean isEmBranco() {
		if (getQtdBombasVizinhas() == 0) {
			return true;
		} else {
			return false;
		}
	}

}

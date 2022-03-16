package br.com.poli.CampoMinadoVVAL.mapa;

import java.util.Random;

import br.com.poli.CampoMinadoVVAL.jogo.Dificuldade;

public abstract class Mapa {

	private Celula[][] campo;
	private int bombas;
	private int tamanhonfoc;
	private boolean fimDeJogo;
	private boolean ganhouJogo;
	private int celulasVisiveis;
	private boolean primeiraCasa;

	public Mapa(int bombas, Dificuldade dificuldade) {
		// Construtor!!! c:
		this.tamanhonfoc = dificuldade.getNumero();
		this.bombas = bombas;
		this.campo = new Celula[dificuldade.getNumero()][dificuldade.getNumero()];
		inicializarCelulas();
		distribuirBombas();
		contarBombas();
		this.primeiraCasa = true;

	}

	private void distribuirBombas() {
		// M�todo que coloca bombas no Campo!

		Random random = new Random();
		int geraBombaX, geraBombaY;
		/*
		 * Vari�veis que receber�o valores de 0 at� tamanho do campo que
		 * representar�o posi��es do tabuleiro para a atribui��o de
		 * bombas!
		 */
		int contadorDeBombas = 0;
		// Serve para contar a quantidade de bombas atuais no tabuleiro!
		do {
			geraBombaX = random.nextInt(this.tamanhonfoc);
			geraBombaY = random.nextInt(this.tamanhonfoc);
			if (!campo[geraBombaX][geraBombaY].isBomba()) {
				campo[geraBombaX][geraBombaY].setBomba(true);
				contadorDeBombas++;
			}
		} while (contadorDeBombas < this.bombas);
	}

	private void inicializarCelulas() {
		for (int i = 0; i < tamanhonfoc; i++) {
			for (int j = 0; j < tamanhonfoc; j++) {
				campo[i][j] = new Celula(i, j);
			}

		}
	}

	public void escolherPosicao(int linha, int coluna) {
		/*
		 * M�todo que seleciona uma Celula a partir de uma linha e coluna, e
		 * deixa-a vis�vel caso n�o possuir bomba, e finaliza o jogo caso
		 * seja bomba.
		 */
		if (linha >= 0 && linha < tamanhonfoc && coluna >= 0 && coluna < tamanhonfoc) {
			if (primeiraCasa) {
				while (campo[linha][coluna].getQtdBombasVizinhas() != 0 || campo[linha][coluna].isBomba()) {
					inicializarCelulas();
					distribuirBombas();
					contarBombas();

				}
				primeiraCasa = false;
			}
			if (!campo[linha][coluna].isVisivel()) {
				if (campo[linha][coluna].isBomba()) {
					System.out.println("Sylas tar! (Game Over)");
					this.fimDeJogo = true;
				} else if (campo[linha][coluna].isBandeira()) {
				} else if (!campo[linha][coluna].isEmBranco()) {
					campo[linha][coluna].setVisivel(true);
					this.celulasVisiveis++;
				} else {
					campo[linha][coluna].setVisivel(true);
					revelarEspacos(campo[linha][coluna]);
					this.celulasVisiveis++;
				}
			}
			verificarGanhouJogo();
		}

	}

	public void contarBombas() {
		// M�todo que atribui � Celula a quantidade de bombas vizinhas que
		// possui
		for (int i = 0; i < tamanhonfoc; i++) {
			for (int j = 0; j < tamanhonfoc; j++) {
				if (campo[i][j].isBomba()) {
					for (int w = -1; w < 2; w++) {
						for (int y = -1; y < 2; y++) {
							if (i + w >= 0 && j + y >= 0 && i + w < tamanhonfoc && j + y < tamanhonfoc
									&& !campo[i + w][j + y].isBomba()) {
								campo[i + w][j + y].setQtdBombasVizinhas(false);
							}
						}

					}

				}
			}
		}
	}

	public void imprimeTela(boolean teste) {
		// M�todo que constroi o campo e imprime-o na tela!
		for (int i = 0; i < campo.length; i++) {
			for (int j = 0; j < campo.length; j++) {
				if (teste) {
					if (campo[i][j].isBomba()) {
						System.out.print("B  ");
					} else {
						System.out.print(campo[i][j].getQtdBombasVizinhas() + "  ");
					}
				} else {
					if (campo[i][j].isVisivel()) {
						if (campo[i][j].isBandeira()) {
							System.out.print("^  ");
						} else if (campo[i][j].isBomba()) {
							System.out.print("B  ");

						} else {
							System.out.print(campo[i][j].getQtdBombasVizinhas() + "  ");
						}

					} else {
						System.out.print("?  ");
					}
				}
			}
			System.out.println();
		}
	}

	public Celula getCelula(int linha, int coluna) {
		return this.campo[linha][coluna];
	}

	private void revelarEspacos(Celula celulaEscolhida) {
		/*
		 * M�todo que funciona caso o usu�rio tenha escolhido uma
		 * posi��o sem bombas vizinhas, abrindo todas as casas adjacentes,
		 * se repetindo caso as casas adjacentes n�o possuam bombas tamb�m.
		 */
		for (int w = -1; w < 2; w++) {
			for (int y = -1; y < 2; y++) {
				if (celulaEscolhida.getLinha() + w >= 0 && celulaEscolhida.getColuna() + y >= 0
						&& celulaEscolhida.getLinha() + w < tamanhonfoc && celulaEscolhida.getColuna() + y < tamanhonfoc
						&& !campo[celulaEscolhida.getLinha() + w][celulaEscolhida.getColuna() + y].isBomba()
						&& !campo[celulaEscolhida.getLinha() + w][celulaEscolhida.getColuna() + y].isVisivel()) {
					// Checa se est� dentro do campo, se tem bomba, se �
					// vis�vel
					if (campo[celulaEscolhida.getLinha() + w][celulaEscolhida.getColuna() + y].isEmBranco())
					// Checa se n�o possui bombas adjacentes
					{
						escolherPosicao(celulaEscolhida.getLinha() + w, celulaEscolhida.getColuna() + y);
					} else {
						campo[celulaEscolhida.getLinha() + w][celulaEscolhida.getColuna() + y].setVisivel(true);
						this.celulasVisiveis++;
					}
				}
			}
		}
	}

	public void dica() {
		boolean acaorealizada = false;
		if (primeiraCasa) {
			Random random = new Random();
			int randLinha = random.nextInt(this.tamanhonfoc);
			int randColuna = random.nextInt(this.tamanhonfoc);
			escolherPosicao(randLinha, randColuna);
		} else {
			contarTabuleiro();
			for (int i = 0; i < campo.length; i++) {
				if (acaorealizada) {
					break;
				} else {
					for (int j = 0; j < campo.length; j++) {
						if (acaorealizada) {
							break;
						} else if (campo[i][j].isVisivel() && campo[i][j].getQtdBombasVizinhas() > 0) {
							for (int w = -1; w < 2; w++) {
								if (acaorealizada) {
									break;
								}
								for (int y = -1; y < 2; y++) {
									if (i + w >= 0 && j + y >= 0 && i + w < tamanhonfoc && j + y < tamanhonfoc) {
										if (campo[i][j].getQtBandeirasVizinhas() == campo[i][j].getQtdBombasVizinhas()
												&& !campo[i + w][j + y].isVisivel()
												&& !campo[i + w][j + y].isBandeira()) {
											escolherPosicao(i + w, j + y);
											acaorealizada = true;
										} else if (campo[i][j].getQtCelulasVizinhasInvisiveis()
												+ campo[i][j].getQtBandeirasVizinhas() == campo[i][j]
														.getQtdBombasVizinhas()
												&& !campo[i + w][j + y].isVisivel()
												&& !campo[i + w][j + y].isBandeira()) {
											campo[i + w][j + y].setBandeira(true);
											acaorealizada = true;
										}
										if (acaorealizada) {
											contarTabuleiro();
											break;
										}

									}

								}
							}
						}
					}
				}
			}
		}
	}

	private void contarTabuleiro() {
		int linha = 0;
		int coluna = 0;
		for (linha = 0; linha < campo.length; linha++) {
			for (coluna = 0; coluna < campo.length; coluna++) {
				contarCelulasVizinhas(linha, coluna);
				contarBandeiras(linha, coluna);
				contarCelulasVizinhasInvisiveis(linha, coluna);
				if (campo[linha][coluna].isVisivel() && campo[linha][coluna].getQtdBombasVizinhas() > 0) {
					System.out.print(campo[linha][coluna].getQtCelulasVizinhas());
					System.out.print(campo[linha][coluna].getQtBandeirasVizinhas());
					System.out.println(campo[linha][coluna].getQtCelulasVizinhasInvisiveis());
				}
			}
			if (linha == campo.length && coluna == campo.length) {
				System.out.println("fimdocampo");
			}
		}
	}

	private void contarCelulasVizinhasInvisiveis(int linha, int coluna) {
		campo[linha][coluna].setQtCelulasVizinhasInvisiveis(true);
		if (campo[linha][coluna].isVisivel()) {
			for (int w = -1; w < 2; w++) {
				for (int y = -1; y < 2; y++) {
					if (linha + w >= 0 && coluna + y >= 0 && linha + w < tamanhonfoc && coluna + y < tamanhonfoc
							&& (w != 0 || y != 0)) {
						if (!(campo[linha + w][coluna + y].isVisivel() || campo[linha + w][coluna + y].isBandeira())) {
							campo[linha][coluna].setQtCelulasVizinhasInvisiveis(false);
						}
					}
				}
			}
		}
	}

	private void contarCelulasVizinhas(int linha, int coluna) {
		campo[linha][coluna].setQtCelulasVizinhas(true);
		if (campo[linha][coluna].isVisivel()) {
			for (int w = -1; w < 2; w++) {
				for (int y = -1; y < 2; y++) {
					if (linha + w >= 0 && coluna + y >= 0 && linha + w < tamanhonfoc && coluna + y < tamanhonfoc
							&& (w != 0 || y != 0)) {
						campo[linha][coluna].setQtCelulasVizinhas(false);
					}
				}
			}

		}
	}

	private void contarBandeiras(int linha, int coluna) {
		campo[linha][coluna].setQtBandeirasVizinhas(true);
		if (campo[linha][coluna].isVisivel()) {
			for (int w = -1; w < 2; w++) {
				for (int y = -1; y < 2; y++) {
					if (linha + w >= 0 && coluna + y >= 0 && linha + w < tamanhonfoc && coluna + y < tamanhonfoc
							&& (w != 0 || y != 0)) {
						if (campo[linha + w][coluna + y].isBandeira()) {
							campo[linha][coluna].setQtBandeirasVizinhas(false);
						}
					}
				}
			}

		}
	}

	private boolean verificarGanhouJogo() {
		// Checa se ganhou o Jogo
		if (getCelulasVisiveis() + getBombas() == getTamanhonfoc() * getTamanhonfoc()) {
			this.ganhouJogo = true;
			this.fimDeJogo = true;
			System.out.println("parabains, ganhaste");
		} else {
			this.ganhouJogo = false;
		}
		return this.ganhouJogo;
	}

	public boolean isFimDeJogo() {
		return this.fimDeJogo;
	} // get fimDeJogo

	public boolean isGanhouJogo() {
		return this.ganhouJogo;
	} // get ganhouJogo

	public Celula[][] getCampo() {
		return campo;
	}

	public int getCelulasVisiveis() {
		return celulasVisiveis;
	}

	public void setCampo(Celula[][] campo) {
		this.campo = campo;
	}

	public int getBombas() {
		return bombas;
	}

	public void setBombas(int bombas) {
		this.bombas = bombas;
	}

	public int getTamanhonfoc() {
		return tamanhonfoc;
	}

	public void setTamanhonfoc(int tamanhonfoc) {
		this.tamanhonfoc = tamanhonfoc;
	}

}
package br.com.poli.CampoMinadoVVAL.gui;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import br.com.poli.CampoMinadoVVAL.jogo.CampoMinado;
import br.com.poli.CampoMinadoVVAL.jogo.Dificuldade;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

public class Botao {

	private int linha, coluna;
	protected JButton botao;

	public Botao(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
		this.botao = new JButton(
				new ImageIcon(Botao.class.getResource("/br/com/poli/CampoMinadoVVAL/resources/eusouaflowey.jpg")));
		botao.setForeground(Color.BLACK);
		botao.setBackground(Color.BLACK);
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
	}

	public void metodo(CampoMinado teste, MenuDeJogo jogo) {
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!teste.getMapa().getCampo()[linha][coluna].isBandeira()) {
					teste.getMapa().escolherPosicao(linha, coluna);
					metodo2(teste, jogo);
				}
			}

		});
	}

	public void metodo2(CampoMinado teste, MenuDeJogo jogo) {
		for (int i = 0; i < jogo.botoes.length; i++) {
			for (int j = 0; j < jogo.botoes.length; j++) {
				if (teste.getMapa().getCampo()[i][j].isVisivel()) {
					jogo.botoes[i][j].getBotao().setIcon(null);
					if (teste.getMapa().getCampo()[i][j].getQtdBombasVizinhas() > 0) {
						jogo.botoes[i][j].botao
								.setText(Integer.toString(teste.getMapa().getCampo()[i][j].getQtdBombasVizinhas()));

					}
					jogo.botoes[i][j].botao.setEnabled(false);
				}

			}
		}

		if (teste.getMapa().isFimDeJogo()) {
			if (teste.getMapa().isGanhouJogo()) {
				TelaGanhou ganhou = new TelaGanhou();
				ganhou.setVisible(true);
				Ranking ranking = new Ranking();
				String murilo;
				switch (teste.getDificuldade()) {
				case FACIL:
					murilo = "rankingfacil.txt";
					break;
				case MEDIO:
					murilo = "rankingmedio.txt";
					break;
				case DIFICIL:
					murilo = "rankingdificil.txt";
					break;
				default:
					murilo = "comodiabosvocechegouaqui.txt";
					break;
				}
				ranking.criaRanking(murilo);
				try {
					teste.getJogador().setTempo(jogo.getContador());
					ranking.escreveTexto(teste.getJogador());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				jogo.dispose();

			} else {
				TelaPerdeu perdeu = new TelaPerdeu();
				perdeu.setVisible(true);
				jogo.dispose();
			}

		}
	}

	public void addMouseListener(CampoMinado teste, MenuDeJogo jogo) {
		botao.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {

					if (!teste.getMapa().getCampo()[linha][coluna].isVisivel()
							&& !teste.getMapa().getCampo()[linha][coluna].isBandeira()) {

						teste.getMapa().getCampo()[linha][coluna].setBandeira(true);
						if (teste.getDificuldade().equals(Dificuldade.FACIL)) {
							jogo.botoes[linha][coluna].getBotao().setIcon(new ImageIcon(
									getClass().getResource("/br/com/poli/CampoMinadoVVAL/resources/bandeira.png")));
						}
						if (teste.getDificuldade().equals(Dificuldade.MEDIO)) {
							jogo.botoes[linha][coluna].getBotao().setIcon(new ImageIcon(
									getClass().getResource("/br/com/poli/CampoMinadoVVAL/resources/metatton.png")));
						}
						if (teste.getDificuldade().equals(Dificuldade.DIFICIL)) {
							jogo.botoes[linha][coluna].getBotao().setIcon(new ImageIcon(
									getClass().getResource("/br/com/poli/CampoMinadoVVAL/resources/cha.png")));
						}
					} else if (!teste.getMapa().getCampo()[linha][coluna].isVisivel()) {

						teste.getMapa().getCampo()[linha][coluna].setBandeira(false);
						jogo.botoes[linha][coluna].getBotao().setIcon(new ImageIcon(
								getClass().getResource("/br/com/poli/CampoMinadoVVAL/resources/eusouaflowey.jpg")));
					}
				}

			}

		});
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public JButton getBotao() {
		return botao;
	}

	public void setBotao(JButton botao) {
		this.botao = botao;
	}

	public void setMargin(Insets insets) {
		// TODO Auto-generated method stub

	}

	public void setFont1(Font font) {
		// TODO Auto-generated method stub

	}

	public void setFont(Font font) {
		// TODO Auto-generated method stub

	}

}

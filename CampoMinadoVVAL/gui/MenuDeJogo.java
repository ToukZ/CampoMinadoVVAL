package br.com.poli.CampoMinadoVVAL.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.poli.CampoMinadoVVAL.jogo.CampoMinado;
import br.com.poli.CampoMinadoVVAL.jogo.Dificuldade;

import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuDeJogo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 666L;
	private JPanel contentPane;
	private JPanel panelBotoes;
	protected Botao botoes[][];
	private Timer timer;
	private int contador = 0;

	public MenuDeJogo(CampoMinado teste) {
		botoes = new Botao[teste.getDificuldade().getNumero()][teste.getDificuldade().getNumero()];

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panelBotoes = new JPanel();
		panelBotoes.setBounds(51, 70, 700, 700);
		contentPane.add(panelBotoes);
		panelBotoes.setLayout(new GridLayout(teste.getDificuldade().getNumero(), teste.getDificuldade().getNumero()));

		for (int i = 0; i < botoes.length; i++) {
			for (int j = 0; j < botoes.length; j++) {
				botoes[i][j] = new Botao(i, j);
				if (teste.getDificuldade().equals(Dificuldade.DIFICIL)) {
					botoes[i][j].getBotao().setMargin(new Insets(0, 0, 0, 0));
					botoes[i][j].getBotao().setFont(new Font("Arial", Font.BOLD, 11));
				}
				botoes[i][j].metodo(teste, this);
				botoes[i][j].addMouseListener(teste, this);
				botoes[i][j].botao.setVisible(true);
				panelBotoes.add(botoes[i][j].botao);

			}
		}
		JLabel timerLabel = new JLabel("00:00");
		timerLabel.setForeground(new Color(255, 0, 0));
		timerLabel.setBackground(Color.RED);
		timerLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 25));
		timerLabel.setBounds(374, 9, 89, 50);
		contentPane.add(timerLabel);

		JButton dica = new JButton("");
		dica.setIcon(new ImageIcon(MenuDeJogo.class.getResource("/br/com/poli/CampoMinadoVVAL/resources/item.png")));
		dica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				teste.getMapa().dica();
				for (int i = 0; i < botoes.length; i++) {
					for (int j = 0; j < botoes.length; j++) {
						if (teste.getMapa().getCampo()[i][j].isVisivel()) {
							botoes[i][j].getBotao().setIcon(null);
							if (teste.getMapa().getCampo()[i][j].getQtdBombasVizinhas() > 0) {
								botoes[i][j].botao.setText(
										Integer.toString(teste.getMapa().getCampo()[i][j].getQtdBombasVizinhas()));
							}
							botoes[i][j].botao.setEnabled(false);
						} else if (teste.getMapa().getCampo()[i][j].isBandeira()) {
							teste.getMapa().getCampo()[i][j].setBandeira(true);
							if (teste.getDificuldade().equals(Dificuldade.FACIL)) {
								botoes[i][j].getBotao().setIcon(new ImageIcon(
										getClass().getResource("/br/com/poli/CampoMinadoVVAL/resources/bandeira.png")));
							} else if (teste.getDificuldade().equals(Dificuldade.MEDIO)) {
								botoes[i][j].getBotao().setIcon(new ImageIcon(
										getClass().getResource("/br/com/poli/CampoMinadoVVAL/resources/metatton.png")));
							} else if (teste.getDificuldade().equals(Dificuldade.DIFICIL)) {
								botoes[i][j].getBotao().setIcon(new ImageIcon(
										getClass().getResource("/br/com/poli/CampoMinadoVVAL/resources/cha.png")));
							}
						} else {
							botoes[i][j].getBotao().setIcon(new ImageIcon(
									getClass().getResource("/br/com/poli/CampoMinadoVVAL/resources/eusouaflowey.jpg")));

						}

					}

				}
			}
		});
		dica.setBounds(603, 17, 125, 40);
		contentPane.add(dica);

		JButton resolverTudo = new JButton("");
		resolverTudo.setIcon(new ImageIcon(MenuDeJogo.class.getResource("/br/com/poli/CampoMinadoVVAL/resources/mercy.png")));
		resolverTudo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do {
					teste.getMapa().dica();
					for (int i = 0; i < botoes.length; i++) {
						for (int j = 0; j < botoes.length; j++) {
							if (teste.getMapa().getCampo()[i][j].isVisivel()) {
								botoes[i][j].getBotao().setIcon(null);
								if (teste.getMapa().getCampo()[i][j].getQtdBombasVizinhas() > 0) {
									botoes[i][j].botao.setText(
											Integer.toString(teste.getMapa().getCampo()[i][j].getQtdBombasVizinhas()));
								}
								botoes[i][j].botao.setEnabled(false);
							} else if (teste.getMapa().getCampo()[i][j].isBandeira()) {
								teste.getMapa().getCampo()[i][j].setBandeira(true);
								if (teste.getDificuldade().equals(Dificuldade.FACIL)) {
									botoes[i][j].getBotao().setIcon(new ImageIcon(getClass()
											.getResource("/br/com/poli/CampoMinadoVVAL/resources/bandeira.png")));
								} else if (teste.getDificuldade().equals(Dificuldade.MEDIO)) {
									botoes[i][j].getBotao().setIcon(new ImageIcon(getClass()
											.getResource("/br/com/poli/CampoMinadoVVAL/resources/metatton.png")));
								} else if (teste.getDificuldade().equals(Dificuldade.DIFICIL)) {
									botoes[i][j].getBotao().setIcon(new ImageIcon(
											getClass().getResource("/br/com/poli/CampoMinadoVVAL/resources/cha.png")));
								}
							} else {
								botoes[i][j].getBotao().setIcon(new ImageIcon(getClass()
										.getResource("/br/com/poli/CampoMinadoVVAL/resources/eusouaflowey.jpg")));

							}

						}

					}

				} while (!teste.getMapa().isFimDeJogo());
			}
		});
		resolverTudo.setBounds(473, 17, 120, 40);
		contentPane.add(resolverTudo);

		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				contador++;
				int segundos = contador % 60;
				int minutos = contador / 60;
				timerLabel.setText(String.format("%02d:%02d", minutos, segundos));
				if (teste.getMapa().isFimDeJogo() == true) {
					timer.cancel();
					contador = 0;
				}

			}
		}, 1000, 1000);

	}

	public int getContador() {
		return this.contador;
	}
}

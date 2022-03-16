package br.com.poli.CampoMinadoVVAL.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;

public class MenuInicial extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 11111111111L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInicial frame = new MenuInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 900);
		contentPane = new JPanel();
		contentPane.setForeground(UIManager.getColor("Button.foreground"));
		contentPane.setBackground(Color.BLACK);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnPlay = new JButton();
		btnPlay.setIcon(
				new ImageIcon(MenuInicial.class.getResource("/br/com/poli/CampoMinadoVVAL/resources/playbot.png")));
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPrincipal escolhas = new TelaPrincipal();
				escolhas.setVisible(true);
				dispose();
			}
		});
		btnPlay.setBounds(390, 250, 165, 40);
		contentPane.add(btnPlay);

		JButton btnFlee = new JButton(
				new ImageIcon(MenuInicial.class.getResource("/br/com/poli/CampoMinadoVVAL/resources/fleebot.png")));
		btnFlee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});

		btnFlee.setBounds(435, 550, 75, 30);
		contentPane.add(btnFlee);

		JButton btnRanking = new JButton(
				new ImageIcon(MenuInicial.class.getResource("/br/com/poli/CampoMinadoVVAL/resources/ranking.png")));
		btnRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					PrintarRanking rank = null;
					try {
						rank = new PrintarRanking();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
		             rank.setVisible(true);
		
	
			
			}
		});
		btnRanking.setBounds(390, 350, 165, 40);
		contentPane.add(btnRanking);

		JLabel label = new JLabel("");
		label.setIcon(
				new ImageIcon(MenuInicial.class.getResource("/br/com/poli/CampoMinadoVVAL/resources/campominado.png")));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Courier New", Font.PLAIN, 50));
		label.setBackground(Color.BLACK);
		label.setBounds(160, 0, 661, 83);
		contentPane.add(label);
	}
}
package br.com.poli.CampoMinadoVVAL.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrintarRanking extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrintarRanking frame = new PrintarRanking();
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
	public PrintarRanking() throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
		Ranking ranking=new Ranking();
     
		try {
			ranking.criaRanking("rankingfacil.txt");
		ranking.scanTexto("rankingfacil.txt");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		JTextArea rankingFacil = new JTextArea();
		rankingFacil.setForeground(Color.GREEN);
		rankingFacil.setFont(new Font("Corbel", Font.BOLD, 14));
		rankingFacil.setText(ranking.retornaNome());
		rankingFacil.setEditable(false);
		rankingFacil.setOpaque(false);
		rankingFacil.setBounds(213, 146, 320, 135);
		contentPane.add(rankingFacil);
		
		JTextArea rankingFacil2 = new JTextArea();
		rankingFacil2.setForeground(Color.GREEN);
		rankingFacil2.setFont(new Font("Corbel", Font.BOLD, 14));
		rankingFacil2.setText(ranking.retornaTempo());
		
		rankingFacil2.setOpaque(false);
		rankingFacil2.setEditable(false);
		rankingFacil2.setBounds(535, 146, 320, 135);
		contentPane.add(rankingFacil2);
		ranking.clearArray();
	  ;
		try {
			ranking.criaRanking("rankingmedio.txt");
			ranking.scanTexto("rankingmedio.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JTextArea rankingMedio = new JTextArea();
	
		rankingMedio.setForeground(Color.CYAN);
		rankingMedio.setFont(new Font("Corbel", Font.BOLD, 14));
		rankingMedio.setText(ranking.retornaNome());
		rankingMedio.setEditable(false);
		rankingMedio.setOpaque(false);
		rankingMedio.setBounds(213, 292, 320, 135);
		contentPane.add(rankingMedio);
		
		JTextArea rankingMedio2 = new JTextArea();
	
		rankingMedio2.setForeground(Color.CYAN);
		rankingMedio2.setFont(new Font("Corbel", Font.BOLD, 14));
		rankingMedio2.setText(ranking.retornaTempo());
		rankingMedio2.setOpaque(false);
		rankingMedio2.setEditable(false);
		rankingMedio2.setBounds(535, 292, 320, 135);
		contentPane.add(rankingMedio2);
		ranking.clearArray();
	
		try {
		ranking.criaRanking("rankingdificil.txt");
			ranking.scanTexto("rankingdificil.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JTextArea rankingDificil = new JTextArea();
	
		rankingDificil.setForeground(Color.RED);
		rankingDificil.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		rankingDificil.setText(ranking.retornaNome());
		rankingDificil.setEditable(false);
		rankingDificil.setOpaque(false);
		rankingDificil.setBounds(205, 438, 320, 135);
		contentPane.add(rankingDificil);
		
		JTextArea rankingDificil2 = new JTextArea();
		rankingDificil2.setForeground(Color.RED);
		rankingDificil2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		rankingDificil2.setText(ranking.retornaTempo());
		rankingDificil2.setOpaque(false);
		rankingDificil2.setEditable(false);
		rankingDificil2.setBounds(535, 438, 320, 135);
		contentPane.add(rankingDificil2);
		ranking.clearArray();
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PrintarRanking.class.getResource("/br/com/poli/CampoMinadoVVAL/resources/rank.png")));
		lblNewLabel.setBounds(122, 0, 590, 101);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PrintarRanking.class.getResource("/br/com/poli/CampoMinadoVVAL/resources/easymode.png")));
		lblNewLabel_1.setBounds(232, 85, 498, 75);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(PrintarRanking.class.getResource("/br/com/poli/CampoMinadoVVAL/resources/mediummode.png")));
		lblNewLabel_2.setBounds(203, 248, 362, 44);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(PrintarRanking.class.getResource("/br/com/poli/CampoMinadoVVAL/resources/hardmode.png")));
		lblNewLabel_3.setBounds(214, 401, 323, 28);
		contentPane.add(lblNewLabel_3);
		
	
	}
}

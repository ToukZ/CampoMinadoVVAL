package br.com.poli.CampoMinadoVVAL.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPerdeu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 69L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPerdeu frame = new TelaPerdeu();
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
	public TelaPerdeu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 900);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(
				new ImageIcon(TelaPerdeu.class.getResource("/br/com/poli/CampoMinadoVVAL/resources/heartbreak.gif")));
		lblNewLabel.setBounds(207, 142, 516, 202);
		contentPane.add(lblNewLabel);

		JButton btnMenu = new JButton();
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuInicial menu = new MenuInicial();
				menu.setVisible(true);
				dispose();
			}
		});
		btnMenu.setIcon(new ImageIcon(TelaPerdeu.class.getResource("/br/com/poli/CampoMinadoVVAL/resources/menu.png")));
		btnMenu.setBounds(375, 445, 165, 50);
		contentPane.add(btnMenu);

		JButton btnFlee = new JButton();
		btnFlee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFlee.setIcon(
				new ImageIcon(TelaPerdeu.class.getResource("/br/com/poli/CampoMinadoVVAL/resources/fleebot.png")));
		btnFlee.setBounds(375, 530, 165, 50);
		contentPane.add(btnFlee);

		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(
				new ImageIcon(TelaPerdeu.class.getResource("/br/com/poli/CampoMinadoVVAL/resources/gameover.png")));
		lblNewLabel_1.setBounds(140, 22, 680, 109);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setIcon(
				new ImageIcon(TelaPerdeu.class.getResource("/br/com/poli/CampoMinadoVVAL/resources/stay.png")));
		lblNewLabel_2.setBounds(230, 359, 503, 63);
		contentPane.add(lblNewLabel_2);

	}
}

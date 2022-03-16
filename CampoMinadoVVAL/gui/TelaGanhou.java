package br.com.poli.CampoMinadoVVAL.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class TelaGanhou extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 420L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGanhou frame = new TelaGanhou();
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
	public TelaGanhou() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 900);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(
				new ImageIcon(TelaGanhou.class.getResource("/br/com/poli/CampoMinadoVVAL/resources/dncing.gif")));
		lblNewLabel.setBounds(297, 13, 498, 312);
		contentPane.add(lblNewLabel);

		JButton btnMenu = new JButton();
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuInicial menu = new MenuInicial();
				menu.setVisible(true);
				dispose();
			}
		});
		btnMenu.setIcon(new ImageIcon(TelaGanhou.class.getResource("/br/com/poli/CampoMinadoVVAL/resources/menu.png")));
		btnMenu.setBounds(375, 445, 165, 50);
		contentPane.add(btnMenu);

		JButton btnFlee = new JButton();
		btnFlee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFlee.setIcon(
				new ImageIcon(TelaGanhou.class.getResource("/br/com/poli/CampoMinadoVVAL/resources/fleebot.png")));
		btnFlee.setBounds(375, 530, 165, 50);
		contentPane.add(btnFlee);


		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(
				new ImageIcon(TelaGanhou.class.getResource("/br/com/poli/CampoMinadoVVAL/resources/didit.png")));
		lblNewLabel_1.setBounds(169, 336, 663, 63);
		contentPane.add(lblNewLabel_1);

	}
}

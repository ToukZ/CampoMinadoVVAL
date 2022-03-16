package br.com.poli.CampoMinadoVVAL.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.poli.CampoMinadoVVAL.jogo.CampoMinado;
import br.com.poli.CampoMinadoVVAL.jogo.Dificuldade;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField txtDigiteOSeu;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 900, 900);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setBounds(73, 39, 0, 0);
		contentPane.add(label);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(
				TelaPrincipal.class.getResource("/br/com/poli/CampoMinadoVVAL/resources/campominado.png")));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(160, 0, 661, 83);
		lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 50));
		contentPane.add(lblNewLabel);

		JButton btnSair = new JButton(
				new ImageIcon(TelaPrincipal.class.getResource("/br/com/poli/CampoMinadoVVAL/resources/fleebot.png")));
		btnSair.setBounds(440, 450, 70, 30);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		JButton btnDificil = new JButton(
				new ImageIcon(TelaPrincipal.class.getResource("/br/com/poli/CampoMinadoVVAL/resources/hardbot.png")));
		btnDificil.setBounds(400, 380, 150, 40);
		btnDificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().isEmpty() && textField.getText() != "Digite o seu nome:") {
					CampoMinado campoDificil = new CampoMinado(txtDigiteOSeu.getText(), Dificuldade.DIFICIL);
					MenuDeJogo dificil = new MenuDeJogo(campoDificil);
					dificil.setVisible(true);
					dispose();
				}
			}

		});

		JButton btnMedio = new JButton(
				new ImageIcon(TelaPrincipal.class.getResource("/br/com/poli/CampoMinadoVVAL/resources/medbot.png")));
		btnMedio.setBounds(400, 290, 150, 40);
		btnMedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().isEmpty() && textField.getText() != "") {
					CampoMinado campoMedio = new CampoMinado(txtDigiteOSeu.getText(), Dificuldade.MEDIO);
					MenuDeJogo medio = new MenuDeJogo(campoMedio);
					medio.setVisible(true);
					dispose();
				}
			}
		}

		);

		JButton btnFacil = new JButton(
				new ImageIcon(TelaPrincipal.class.getResource("/br/com/poli/CampoMinadoVVAL/resources/easybot.png")));
		btnFacil.setBounds(400, 210, 150, 40);
		btnFacil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().isEmpty() && textField.getText() != "") {
					CampoMinado campoFacil = new CampoMinado(textField.getText(), Dificuldade.FACIL);
					MenuDeJogo facil = new MenuDeJogo(campoFacil);
					facil.setVisible(true);
					dispose();
				}
			}

		});

		JLabel label_1 = new JLabel("");
		label_1.setBounds(439, 39, 0, 0);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("");
		label_2.setBounds(444, 39, 0, 0);
		contentPane.add(label_2);

		txtDigiteOSeu = new JTextField();
		txtDigiteOSeu.setForeground(Color.WHITE);
		txtDigiteOSeu.setBackground(Color.BLACK);
		txtDigiteOSeu.setEditable(false);
		txtDigiteOSeu.setBounds(400, 100, 150, 40);
		txtDigiteOSeu.setText("Digite o seu nome:");
		contentPane.add(txtDigiteOSeu);
		txtDigiteOSeu.setColumns(10);

		JLabel label_3 = new JLabel("");
		label_3.setBounds(540, 39, 0, 0);
		contentPane.add(label_3);
		contentPane.add(btnFacil);
		contentPane.add(btnMedio);
		contentPane.add(btnDificil);

		JLabel label_4 = new JLabel("");
		label_4.setBounds(755, 39, 0, 0);
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("");
		label_5.setBounds(760, 39, 0, 0);
		contentPane.add(label_5);
		contentPane.add(btnSair);

		textField = new JTextField();
		textField.setBounds(400, 150, 150, 25);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}

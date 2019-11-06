package br.com.facisa.projeto.damas.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JTelaInicio implements ActionListener {

	private JFrame frame = new JFrame();
	private JButton btnInicioPartida = new JButton();
	private JTextField JTextPlayerOneName = new JTextField();
	private JTextField JTextPlayerTwoName = new JTextField();
	private JTextField JTextTamanhoDoTabuleiro = new JTextField();
	private JPanel painel = new JPanel();
	private Integer tamanho = null;
	private String playerOneName;
	private String playerTwoName;
	private Boolean click = false;

	public void formInicio() {
		frame.addWindowListener(new WindowListener() {

			public void windowActivated(java.awt.event.WindowEvent arg0) {
			}

			public void windowClosed(java.awt.event.WindowEvent arg0) {
				System.exit(0);
			}

			public void windowClosing(java.awt.event.WindowEvent arg0) {
			}

			public void windowDeactivated(java.awt.event.WindowEvent arg0) {
			}

			public void windowDeiconified(java.awt.event.WindowEvent arg0) {
			}

			public void windowIconified(java.awt.event.WindowEvent arg0) {
			}

			public void windowOpened(java.awt.event.WindowEvent arg0) {
			}
		});

		// Ajustando telas
		ajustaPosicaoLayout();
		preencheTextoDefault();
		adicionaElementos();
	}

	public void ajustaPosicaoLayout() {
		frame.setSize(300, 200);
	}

	public void preencheTextoDefault() {
		JTextPlayerOneName.setText("Nome do player 1");
		JTextPlayerTwoName.setText("Nome do player 2");
		JTextTamanhoDoTabuleiro.setText("Tamanho do tabuleiro %2 == 0... Digite");
		btnInicioPartida.setText("Entrar");
	}

	public void adicionaElementos() {
		painel.add(JTextPlayerOneName);
		painel.add(JTextPlayerTwoName);
		painel.add(JTextTamanhoDoTabuleiro);
		painel.add(btnInicioPartida);

		btnInicioPartida.addActionListener(
				// Se clicar em entrar
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						// Valida campo do tamanho do tabuleiro
						if (JTextTamanhoDoTabuleiro.getText().matches("[0-9]*")) {
							if (Integer.valueOf(JTextTamanhoDoTabuleiro.getText()) % 2 == 0) {
								tamanho = Integer.valueOf(JTextTamanhoDoTabuleiro.getText());
								JTelaDama mainFrame = new JTelaDama(tamanho);
								mainFrame.setSize(640, 480);
								mainFrame.setVisible(true);
							} else {
								JOptionPane.showMessageDialog(null,
										"So eh permitido numero par", "Tamanho Invalido",
										JOptionPane.ERROR_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(null,
									"Voce digitou um texto, tente um numero inteiro par.", "Tamanho Invalido",
									JOptionPane.ERROR_MESSAGE);
						}

					}
				});

		frame.add(painel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent arg0) {
	}

}

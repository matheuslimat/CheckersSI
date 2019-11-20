package br.com.facisa.projeto.damas.controller;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class TabuleiroController extends JInternalFrame implements MouseListener, MouseMotionListener{

	private static final long serialVersionUID = 1L;
	protected Integer tamanho;
	protected char tabuleiro[][] = null;
	public Casa casa[][] = null;
	protected char vez = 'A';
	private char eu = ' ';
	private ObjectOutputStream output;
	private int posicaoB;
	private int selx = -1;
	private int sely = -1;
	private byte pecasA = 0;
	private byte pecasB = 0;
	public boolean bloq = false;
	public static final Integer PORCENTAGEM_POSICAO_B = 40;
	public static final Integer PORCENTAGEM_DEFAULT = 100;
	
	public GridBagConstraints gbConstraints = new GridBagConstraints();
	public Container container = getContentPane();
	public GridBagLayout gbLayout = new GridBagLayout();
	
	public ValidacaoController vc;
	
	private Color corA = new Color(255, 255, 255);
	private Color corB = new Color(0, 0, 0);
	
	public TabuleiroController(char me, Integer tamanho) {
		this.tamanho = tamanho;
		this.casa = new Casa[tamanho][tamanho];
		this.posicaoB = calculaPosicaoB(tamanho);
		this.tabuleiro = new char[tamanho][tamanho];
		this.eu = me;
		this.container.setLayout(gbLayout);
		vc = new ValidacaoController(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		
	}

	public void resetaTabuleiro() {
		int posX = 0;
		int posY = 0;

		for (posX = 0; posX < tamanho; posX++) {
			for (posY = 0; posY < tamanho; posY++) {

				if (posX % 2 == 0) {
					if (posY % 2 == 0)
						tabuleiro[posX][posY] = ' ';
					else
						tabuleiro[posX][posY] = '*';
				} else {
					if (posY % 2 != 0)
						tabuleiro[posX][posY] = ' ';
					else
						tabuleiro[posX][posY] = '*';
				}

				if (tabuleiro[posX][posY] == '*') {
					casa[posX][posY].setBackground(Color.DARK_GRAY);
					casa[posX][posY].setForeground(Color.DARK_GRAY);
				} else {
					casa[posX][posY].setBackground(Color.LIGHT_GRAY);
					casa[posX][posY].setForeground(Color.LIGHT_GRAY);
				}
			}
		}

	}

	public void posicionaJogador(char jogador, int posInicial) {
		int cont;
		int pos = 0;

		if (jogador == 'A' || jogador == 'B') {
			// quantidade de peÁa pra preencher em um lado do tabuleiro
			for (cont = 0; cont < Math.abs((tamanho * tamanho) - calculaPosicaoB(tamanho)) / 2; cont++) {
				// metade do tabuleiro
				while (pos < (tamanho * tamanho) / 2) {
					if (tabuleiro[(pos + posInicial) / tamanho][(int) ((pos + posInicial) % tamanho)] == ' ') {
						tabuleiro[(pos + posInicial) / tamanho][(int) ((pos + posInicial) % tamanho)] = jogador;
						if (jogador == 'A') {
							casa[(pos + posInicial) / tamanho][(int) ((pos + posInicial) % tamanho)]
									.setForeground(corA);
						} else if (jogador == 'B') {
							casa[(pos + posInicial) / tamanho][(int) ((pos + posInicial) % tamanho)]
									.setForeground(corB);
						}
						break;
					}
					pos++;
				}
			}
		}
	}

	private int calculaPosicaoB(Integer t) {
		t = t * t;
		return t - Math.abs((t * PORCENTAGEM_POSICAO_B) / PORCENTAGEM_DEFAULT);
	}
	
	public void trocaVez() {
		vez = (vez == 'A' ? 'B' : 'A');
	}

	public void movePeca(int xo, int yo, int xd, int yd) {
		movePeca(xo, yo, xd, yd, true);
	}

	public void movePeca(int xo, int yo, int xd, int yd, boolean local) {
		if (tabuleiro[yo][xo] != ' ') {
			Casa origem = casa[yo][xo];
			Casa destino = casa[yd][xd];
			tabuleiro[yd][xd] = tabuleiro[yo][xo];
			tabuleiro[yo][xo] = ' ';
			destino.setForeground(origem.getForeground());
			origem.setForeground(origem.getBackground());
			if ((yd == tamanho - 1 && tabuleiro[yd][xd] == 'A') || (yd == 0 && tabuleiro[yd][xd] == 'B')
					|| (origem.isDama())) {
				// Define uma dama
				destino.setDama(true);
			}
			casa[yo][xo].setDama(false);
			if (local) {
				try {
					output.writeObject((String) "MOVIMENTO");
					output.flush();
					output.writeObject((String) Integer.toString(xo) + "," + Integer.toString(yo) + ","
							+ Integer.toString(xd) + "," + Integer.toString(yd));
					output.flush();
				} catch (IOException io) {
					io.printStackTrace();
				}
			}
		}
	}

	public void comePeca(int x, int y) {
		comePeca(x, y, false);
	}

	public void comePeca(int x, int y, boolean local) {
		if (tabuleiro[y][x] == 'A')
			//pecasA--;
		//else if (tabuleiro[y][x] == 'B')
			//pecasB--;
		tabuleiro[y][x] = ' ';
		casa[y][x].setDama(false);
		casa[y][x].setForeground(casa[y][x].getBackground());
		if (local) {
			try {
				output.writeObject((String) "COME");
				output.flush();
				output.writeObject((String) Integer.toString(x) + "," + Integer.toString(y));
				output.flush();
			} catch (IOException io) {
				io.printStackTrace();
			}
		}
	}
	
	private void desPossibilita() {

		int posX = 0;
		int posY = 0;

		for (posX = 0; posX < tamanho; posX++) {
			for (posY = 0; posY < tamanho; posY++) {
				casa[posY][posX].setPossivel(false, Color.cyan);
				casa[posY][posX].seleciona(false, Color.red);
				selx = sely = -1;
			}
		}
	}

	// botao do mouse foi solto
	public void mouseReleased(MouseEvent e) {
		int x = 0;
		int y = 0;
		if (!bloq && vez == eu) {
			if (pecasA > 0 && pecasB > 0) {
				x = (e.getX()) / (super.getWidth() / tamanho);
				y = (e.getY() - 13) / (super.getHeight() / tamanho);
				if (casa[y][x].isPossivel()) {
					if (Math.abs(selx - x) == 2) {
						System.out.println("Pe√ßa comida pelo jogador " + vez);
						comePeca((selx + x) / 2, (sely + y) / 2, true);
					}

					movePeca(selx, sely, x, y);

					if (pecasA == 0)
						JOptionPane.showMessageDialog(this, "O Jogador B Ganhou !", "Fim de Jogo",
								JOptionPane.PLAIN_MESSAGE);

					if (pecasB == 0)
						JOptionPane.showMessageDialog(this, "O Jogador A Ganhou !", "Fim de Jogo",
								JOptionPane.PLAIN_MESSAGE);

					if (vez == 'A') {
						vez = 'B';
					} else {
						vez = 'A';
					}
				}

				desPossibilita();

				if (tabuleiro[y][x] != ' ' && tabuleiro[y][x] != '*') {
					casa[y][x].seleciona(true, Color.red);
					selx = x;
					sely = y;
					vc.lancesPossiveis(x, y);
				}
			}
		}
	}
	
	public void mostra(JDesktopPane main) {
		main.add(this);
		setOpaque(true);
		show();
	}

	public int getPosicaoB() {
		return posicaoB;
	}

	public Casa[][] getCasa() {
		return casa;
	}

	public void setCasa(Casa[][] casa) {
		this.casa = casa;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

	
	
}

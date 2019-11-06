package br.com.facisa.projeto.damas.controller;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class TabuleiroController {

	private Integer tamanho;
	private char tabuleiro[][] = null;
	private Casa casa[][] = null;
	private char vez;
	private ObjectOutputStream output;
	public static final Integer PORCENTAGEM_POSICAO_B = 40;
	public static final Integer PORCENTAGEM_DEFAULT = 100;
	
	public TabuleiroController(char[][] tabuleiro, Integer tamanho, Casa[][] casa, char vez) {
		this.tamanho = tamanho;
		this.tabuleiro = tabuleiro;
		this.casa = new Casa[tamanho][tamanho];
		this.vez = vez;
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
			// quantidade de peça pra preencher em um lado do tabuleiro
			for (cont = 0; cont < Math.abs((tamanho * tamanho) - calculaPosicaoB(tamanho)) / 2; cont++) {
				// metade do tabuleiro
				while (pos < (tamanho * tamanho) / 2) {
					if (tabuleiro[(pos + posInicial) / tamanho][(int) ((pos + posInicial) % tamanho)] == ' ') {
						tabuleiro[(pos + posInicial) / tamanho][(int) ((pos + posInicial) % tamanho)] = jogador;
						if (jogador == 'A') {
//							casa[(pos + posInicial) / tamanho][(int) ((pos + posInicial) % tamanho)]
//									.setForeground(corA);
						} else if (jogador == 'B') {
//							casa[(pos + posInicial) / tamanho][(int) ((pos + posInicial) % tamanho)]
//									.setForeground(corB);
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


}

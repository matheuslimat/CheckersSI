package br.com.facisa.projeto.damas.controller;

import java.awt.Color;

public class ValidacaoController {
	
	private char tabuleiro[][] = null;
	private Integer tamanho;
	private Casa[][] casa;
	private char vez;

	public ValidacaoController(char[][] tb, Integer tamanho, Casa[][] casa, char vez) {
		this.tabuleiro = tb;
		this.tamanho = tamanho;
		this.casa = casa;
		this.vez = vez;
	}

	private void lancesPossiveis(int x, int y) {

		if (tabuleiro[x][y] == 'A' && vez == 'A') {
			if (x < tamanho - 1) {
				if (y < tamanho - 1) {
					if (tabuleiro[x + 1][y + 1] == 'B' && y < 6 && x < 6) {
						if (tabuleiro[x + 2][y + 2] == ' ') {
							// pode comer B
							casa[x + 2][y + 2].setPossivel(true, Color.cyan);
						}
					}
					if (tabuleiro[x + 1][y + 1] == ' ') {
						casa[x + 1][y + 1].setPossivel(true, Color.cyan);
					}

				}
				if (y > 0) {
					if (tabuleiro[x + 1][y - 1] == 'B' && x < 6 && y > 1) {
						if (tabuleiro[x + 2][y - 2] == ' ') {
							// pode comer B
							casa[x + 2][y - 2].setPossivel(true, Color.cyan);
						}
					}
					if (tabuleiro[x + 1][y - 1] == ' ') {
						casa[x + 1][y - 1].setPossivel(true, Color.cyan);
					}
				}
			}
			if (x > 0 && casa[x][y].isDama()) {
				if (y < tamanho - 1) {
					if (tabuleiro[x - 1][y + 1] == 'B' && y < tamanho - 2 && x > 1) {
						if (tabuleiro[x - 2][y + 2] == ' ') {
							// pode comer A
							casa[x - 2][y + 2].setPossivel(true, Color.cyan);
						}
					}
					if (tabuleiro[x - 1][y + 1] == ' ') {
						casa[x - 1][y + 1].setPossivel(true, Color.cyan);
					}
				}
				if (y > 0) {
					if (tabuleiro[x - 1][y - 1] == 'B' && x > 1 && y > 1) {
						if (tabuleiro[x - 2][y - 2] == ' ') {
							// pode comer A
							casa[x - 2][y - 2].setPossivel(true, Color.cyan);
						}
					}
					if (tabuleiro[x - 1][y - 1] == ' ') {
						casa[x - 1][y - 1].setPossivel(true, Color.cyan);
					}
				}
			}

		}

		if (tabuleiro[x][y] == 'B' && vez == 'B') {
			if (x > 0) {
				if (y < tamanho - 1) {
					if (tabuleiro[x - 1][y + 1] == 'A' && y < tamanho - 2 && x > 1) {
						if (tabuleiro[x - 2][y + 2] == ' ') {
							// pode comer A
							casa[x - 2][y + 2].setPossivel(true, Color.cyan);
						}
					}
					if (tabuleiro[x - 1][y + 1] == ' ') {
						casa[x - 1][y + 1].setPossivel(true, Color.cyan);
					}
				}
				if (y > 0) {
					if (tabuleiro[x - 1][y - 1] == 'A' && x > 1 && y > 1) {
						if (tabuleiro[x - 2][y - 2] == ' ') {
							// pode comer A
							casa[x - 2][y - 2].setPossivel(true, Color.cyan);
						}
					}
					if (tabuleiro[x - 1][y - 1] == ' ') {
						casa[x - 1][y - 1].setPossivel(true, Color.cyan);
					}
				}
			}
			if (x < tamanho - 1 && casa[x][y].isDama()) {
				if (y < tamanho - 1) {
					if (tabuleiro[x + 1][y + 1] == 'A' && y < tamanho - 2 && x < tamanho - 2) {
						if (tabuleiro[x + 2][y + 2] == ' ') {
							// pode comer B
							casa[x + 2][y + 2].setPossivel(true, Color.cyan);
						}
					}
					if (tabuleiro[x + 1][y + 1] == ' ') {
						casa[x + 1][y + 1].setPossivel(true, Color.cyan);
					}

				}
				if (y > 0) {
					if (tabuleiro[x + 1][y - 1] == 'A' && x < tamanho - 2 && y > 1) {
						if (tabuleiro[x + 2][y - 2] == ' ') {
							// pode comer B
							casa[x + 2][y - 2].setPossivel(true, Color.cyan);
						}
					}
					if (tabuleiro[x + 1][y - 1] == ' ') {
						casa[x + 1][y - 1].setPossivel(true, Color.cyan);
					}
				}
			}
		}
	}
}

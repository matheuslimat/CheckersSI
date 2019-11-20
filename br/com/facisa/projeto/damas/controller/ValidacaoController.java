package br.com.facisa.projeto.damas.controller;

import java.awt.Color;

public class ValidacaoController {

	public TabuleiroController tc;

	public ValidacaoController(TabuleiroController tc) {
		this.tc = tc;
	}

	public void lancesPossiveis(int x, int y) {

		if (tc.tabuleiro[x][y] == 'A' && tc.vez == 'A') {
			if (x < tc.tamanho - 1) {
				if (y < tc.tamanho - 1) {
					if (tc.tabuleiro[x + 1][y + 1] == 'B' && y < 6 && x < 6) {
						if (tc.tabuleiro[x + 2][y + 2] == ' ') {
							// pode comer B
							tc.casa[x + 2][y + 2].setPossivel(true, Color.cyan);
						}
					}
					if (tc.tabuleiro[x + 1][y + 1] == ' ') {
						tc.casa[x + 1][y + 1].setPossivel(true, Color.cyan);
					}

				}
				if (y > 0) {
					if (tc.tabuleiro[x + 1][y - 1] == 'B' && x < 6 && y > 1) {
						if (tc.tabuleiro[x + 2][y - 2] == ' ') {
							// pode comer B
							tc.casa[x + 2][y - 2].setPossivel(true, Color.cyan);
						}
					}
					if (tc.tabuleiro[x + 1][y - 1] == ' ') {
						tc.casa[x + 1][y - 1].setPossivel(true, Color.cyan);
					}
				}
			}
			if (x > 0 && tc.casa[x][y].isDama()) {
				if (y < tc.tamanho - 1) {
					if (tc.tabuleiro[x - 1][y + 1] == 'B' && y < tc.tamanho - 2 && x > 1) {
						if (tc.tabuleiro[x - 2][y + 2] == ' ') {
							// pode comer A
							tc.casa[x - 2][y + 2].setPossivel(true, Color.cyan);
						}
					}
					if (tc.tabuleiro[x - 1][y + 1] == ' ') {
						tc.casa[x - 1][y + 1].setPossivel(true, Color.cyan);
					}
				}
				if (y > 0) {
					if (tc.tabuleiro[x - 1][y - 1] == 'B' && x > 1 && y > 1) {
						if (tc.tabuleiro[x - 2][y - 2] == ' ') {
							// pode comer A
							tc.casa[x - 2][y - 2].setPossivel(true, Color.cyan);
						}
					}
					if (tc.tabuleiro[x - 1][y - 1] == ' ') {
						tc.casa[x - 1][y - 1].setPossivel(true, Color.cyan);
					}
				}
			}

		}

		if (tc.tabuleiro[x][y] == 'B' && tc.vez == 'B') {
			if (x > 0) {
				if (y < tc.tamanho - 1) {
					if (tc.tabuleiro[x - 1][y + 1] == 'A' && y < tc.tamanho - 2 && x > 1) {
						if (tc.tabuleiro[x - 2][y + 2] == ' ') {
							// pode comer A
							tc.casa[x - 2][y + 2].setPossivel(true, Color.cyan);
						}
					}
					if (tc.tabuleiro[x - 1][y + 1] == ' ') {
						tc.casa[x - 1][y + 1].setPossivel(true, Color.cyan);
					}
				}
				if (y > 0) {
					if (tc.tabuleiro[x - 1][y - 1] == 'A' && x > 1 && y > 1) {
						if (tc.tabuleiro[x - 2][y - 2] == ' ') {
							// pode comer A
							tc.casa[x - 2][y - 2].setPossivel(true, Color.cyan);
						}
					}
					if (tc.tabuleiro[x - 1][y - 1] == ' ') {
						tc.casa[x - 1][y - 1].setPossivel(true, Color.cyan);
					}
				}
			}
			if (x < tc.tamanho - 1 && tc.casa[x][y].isDama()) {
				if (y < tc.tamanho - 1) {
					if (tc.tabuleiro[x + 1][y + 1] == 'A' && y < tc.tamanho - 2 && x < tc.tamanho - 2) {
						if (tc.tabuleiro[x + 2][y + 2] == ' ') {
							// pode comer B
							tc.casa[x + 2][y + 2].setPossivel(true, Color.cyan);
						}
					}
					if (tc.tabuleiro[x + 1][y + 1] == ' ') {
						tc.casa[x + 1][y + 1].setPossivel(true, Color.cyan);
					}

				}
				if (y > 0) {
					if (tc.tabuleiro[x + 1][y - 1] == 'A' && x < tc.tamanho - 2 && y > 1) {
						if (tc.tabuleiro[x + 2][y - 2] == ' ') {
							// pode comer B
							tc.casa[x + 2][y - 2].setPossivel(true, Color.cyan);
						}
					}
					if (tc.tabuleiro[x + 1][y - 1] == ' ') {
						tc.casa[x + 1][y - 1].setPossivel(true, Color.cyan);
					}
				}
			}
		}
	}
}

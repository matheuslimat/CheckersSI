package br.com.facisa.projeto.damas.model;

import javax.swing.JInternalFrame;

import br.com.facisa.projeto.damas.controller.Casa;

public class Tabuleiro extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	private Casa casa[][] = null;
	private char tabuleiro[][] = null;
	private int selx = -1;
	private int sely = -1;
	private int posicaoB = 0;
	public static final Integer PORCENTAGEM_POSICAO_B = 40;
	public static final Integer PORCENTAGEM_DEFAULT = 100;
	private int pecasA = 0;
	private int pecasB = 0;
	private char vez = 'A';
	private char eu = ' ';
	public boolean bloq = false;
	private String jogadorA;
	private String jogadorB;

	public String getJogadorA() {
		return jogadorA;
	}

	public void setJogadorA(String jogadorA) {
		this.jogadorA = jogadorA;
	}

	public String getJogadorB() {
		return jogadorB;
	}

	public void setJogadorB(String jogadorB) {
		this.jogadorB = jogadorB;
	}

	private Integer tamanho;

	public Tabuleiro(char me, Integer tamanho) {

		super("Teste", true, true);

		this.tamanho = tamanho;
		this.posicaoB = calculaPosicaoB(tamanho);
		this.casa = new Casa[tamanho][tamanho];
		this.tabuleiro = new char[tamanho][tamanho];
		this.pecasA = Math.abs(((tamanho*tamanho) - posicaoB) / 2);
		this.pecasB = Math.abs(((tamanho*tamanho) - posicaoB) / 2);

		eu = me;

		int lin;
		int col;

		setTitle("Jogo de Damas");

//		addMouseListener(this);
//		addMouseMotionListener(this);


		// instantiate gridbag constraints

		for (lin = 0; lin < tamanho; lin++) {
			for (col = 0; col < tamanho; col++) {
				// inicializa a casa
				casa[lin][col] = new Casa();
//				addComponent(casa[lin][col], lin, col, 1, 1);
			}
		}


	}
	
	private int calculaPosicaoB(Integer t) {
		t = t * t;
		return t - Math.abs((t * PORCENTAGEM_POSICAO_B) / PORCENTAGEM_DEFAULT);
	}

	public Integer getTamanho() {
		return tamanho;
	}

	public void setTamanho(Integer tamanho) {
		this.tamanho = tamanho;
	}

	public Casa[][] getCasa() {
		return casa;
	}

	public void setCasa(Casa[][] casa) {
		this.casa = casa;
	}

	public int getPosicaoB() {
		return posicaoB;
	}

	public void setPosicaoB(int posicaoB) {
		this.posicaoB = posicaoB;
	}

	public char[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(char[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public int getSelx() {
		return selx;
	}

	public void setSelx(int selx) {
		this.selx = selx;
	}

	public int getSely() {
		return sely;
	}

	public void setSely(int sely) {
		this.sely = sely;
	}

	public int getPecasA() {
		return pecasA;
	}

	public void setPecasA(int pecasA) {
		this.pecasA = pecasA;
	}

	public int getPecasB() {
		return pecasB;
	}

	public void setPecasB(int pecasB) {
		this.pecasB = pecasB;
	}

	public char getVez() {
		return vez;
	}

	public void setVez(char vez) {
		this.vez = vez;
	}

	public char getEu() {
		return eu;
	}

	public void setEu(char eu) {
		this.eu = eu;
	}
	
}

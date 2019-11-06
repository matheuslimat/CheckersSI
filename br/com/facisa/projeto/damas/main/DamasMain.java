package br.com.facisa.projeto.damas.main;
import br.com.facisa.projeto.damas.controller.TabuleiroController;
import br.com.facisa.projeto.damas.model.Tabuleiro;
import br.com.facisa.projeto.damas.view.JTelaDama;

public class DamasMain {
	public static void main(String args[]) {
		
		// MODEL
		Tabuleiro tb = new Tabuleiro(' ', 8);
		
		// CONTROLLER
		TabuleiroController tbc = new TabuleiroController(tb.getTabuleiro(), tb.getTamanho(), tb.getCasa(), tb.getVez());
		tbc.resetaTabuleiro();
		tbc.posicionaJogador('A', 0);
		tbc.posicionaJogador('B', tb.getPosicaoB());
		
		// VIEW
		JTelaDama jtd = new JTelaDama(tb.getTamanho());
		
	}
}
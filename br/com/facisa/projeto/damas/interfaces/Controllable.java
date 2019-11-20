package br.com.facisa.projeto.damas.interfaces;

import br.com.facisa.projeto.damas.controller.Casa;
import br.com.facisa.projeto.damas.controller.TabuleiroController;

public interface Controllable {

	void iniciar(TabuleiroController tc);
	
	void preencherCasasTabuleiro(TabuleiroController tc, Integer tamanho, Casa[][] casa);
	
}

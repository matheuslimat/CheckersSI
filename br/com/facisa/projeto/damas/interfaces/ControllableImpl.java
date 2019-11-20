package br.com.facisa.projeto.damas.interfaces;

import java.awt.Component;
import java.awt.GridBagConstraints;

import javax.swing.JInternalFrame;

import br.com.facisa.projeto.damas.controller.Casa;
import br.com.facisa.projeto.damas.controller.TabuleiroController;

public class ControllableImpl extends JInternalFrame implements Controllable{
	private static final long serialVersionUID = 1L;

	@Override
	public void iniciar(TabuleiroController tc) {
		tc.resetaTabuleiro();
		tc.posicionaJogador('A', 0);
		tc.posicionaJogador('B', tc.getPosicaoB());
		tc.setSize(400, 400);
	}

	@Override
	public void preencherCasasTabuleiro(TabuleiroController tc, Integer tamanho, Casa[][] casa) {
		tc.gbConstraints.fill = GridBagConstraints.BOTH;
		tc.gbConstraints.weightx = 1;
		tc.gbConstraints.weighty = 1;
		
		for (int lin = 0; lin < tamanho; lin++) {
			for (int col = 0; col < tamanho; col++) {
				tc.casa[lin][col] = new Casa(); // inicializa casa
				addComponent(tc, casa[lin][col], lin, col, 1, 1, tc.gbConstraints);
			}
		}
		
	}
	
	public void addComponent(TabuleiroController tc, Component c, int linha, int coluna, int width, int height, GridBagConstraints gbConstraints) {
		tc.gbConstraints.gridx = coluna;
		tc.gbConstraints.gridy = linha;

		tc.gbConstraints.gridwidth = width;
		tc.gbConstraints.gridheight = height;

		tc.gbLayout.setConstraints(c, gbConstraints);
		tc.container.add(c);
	}

}

package br.com.facisa.projeto.damas.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import br.com.facisa.projeto.damas.controller.TabuleiroController;
import br.com.facisa.projeto.damas.interfaces.Controllable;
import br.com.facisa.projeto.damas.interfaces.ControllableImpl;

public class JTelaDama extends JFrame {

	private static final long serialVersionUID = 1L;
	public JMenuBar menu = new JMenuBar();
	public final JDesktopPane mdiDamas = new JDesktopPane();
	public JMenu menuJogo = new JMenu("Jogo");
	public JMenuItem mItemNovo = new JMenuItem("Jogo Local");
	public JMenuItem mItemSair = new JMenuItem("Sair");
	public Controllable controllableInterface = new ControllableImpl();
	public TabuleiroController tabuleiroControler;

	public JTelaDama(Integer tamanho) {

		setJMenuBar(menu);
		getContentPane().add(mdiDamas);
		menuJogo.setMnemonic('J');
		menuJogo.addSeparator();

		mItemNovo.setMnemonic('N');
		mItemNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabuleiroControler = new TabuleiroController(' ', tamanho);
				controllableInterface.preencherCasasTabuleiro(tabuleiroControler, tamanho, tabuleiroControler.getCasa());
				controllableInterface.iniciar(tabuleiroControler);
				mdiDamas.add(tabuleiroControler);
				tabuleiroControler.setOpaque(true);
				tabuleiroControler.show();
			}
		});
		menuJogo.add(mItemNovo);
		menuJogo.addSeparator();

		mItemSair.setMnemonic('S');
		mItemSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}
		});
		menuJogo.add(mItemSair);
		menu.add(menuJogo);
	}
}
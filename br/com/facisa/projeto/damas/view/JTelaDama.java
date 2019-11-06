package br.com.facisa.projeto.damas.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import br.com.facisa.projeto.damas.model.Tabuleiro;

public class JTelaDama extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public JTelaDama(Integer tamanho) {
		
		super("Jogo de damas conectando dois player");
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		
		final JDesktopPane mdiDamas = new JDesktopPane();
		getContentPane().add(mdiDamas);
		
		JMenu menuJogo = new JMenu("Jogo");
		menuJogo.setMnemonic('J');
		
		JMenuItem mItemSobre = new JMenuItem("Sobre");

		menuJogo.add(mItemSobre);
		menuJogo.addSeparator();
		
		JMenuItem mItemNovo = new JMenuItem("Jogo Local");
		mItemNovo.setMnemonic('N');
		mItemNovo.addActionListener( 
			new ActionListener(){
				public void actionPerformed( ActionEvent e){
				Tabuleiro tabuleiro = new Tabuleiro(' ', tamanho);
		      	//tabuleiro.mostra(mdiDamas);
				}
			}
		);
		menuJogo.add(mItemNovo);
		menuJogo.addSeparator();

		JMenuItem mItemSair = new JMenuItem("Sair");
		
		mItemSair.setMnemonic('S');
		mItemSair.addActionListener( 
			new ActionListener(){
				public void actionPerformed( ActionEvent e){
					dispose();
					System.exit(0);
				}
			}
		);
		menuJogo.add(mItemSair);
		
		menu.add(menuJogo);
	}
}
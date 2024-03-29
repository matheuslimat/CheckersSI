package br.com.facisa.projeto.damas.view;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class JTelaPadrao extends JInternalFrame { 

	private static final long serialVersionUID = 1L;
	private Container container;
	private GridBagLayout gbLayout;
	private GridBagConstraints gbConstraints;
	
	public JTelaPadrao(){
        super("Teste",true,true,true,true);

		container = getContentPane();
		gbLayout = new GridBagLayout();
		container.setLayout(gbLayout);
		
		//instancia as limitacoes
		gbConstraints = new GridBagConstraints();

	}
	
	public void mostra()
	{
        setOpaque( true );
        show();
	}

	public void mostra(JDesktopPane main)
	{
		main.add(this);
        setOpaque( true );
        show();
	}


	public void addComponent(Component c, int linha, int coluna, int width, int height)
	{
		gbConstraints.gridx = coluna;
		gbConstraints.gridy = linha;
		
		gbConstraints.gridwidth = width;
		gbConstraints.gridheight = height;
		
		gbLayout.setConstraints(c,gbConstraints);
		container.add(c);
	}
	
	public void setConstraintFill(int fillConstraint){
		gbConstraints.fill = fillConstraint;
	}
	
	public void setConstraintGridwidth(int gridwidth){
		gbConstraints.gridwidth = gridwidth;
	}
	
	public void setWeightx(int v)
	{
       	gbConstraints.weightx = v;  
	}
	
	public void setWeighty(int v)
	{
       	gbConstraints.weighty = v;  
	}
	
}
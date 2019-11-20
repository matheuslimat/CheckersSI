package br.com.facisa.projeto.damas.main;
import br.com.facisa.projeto.damas.view.JTelaInicio;

public class DamasMain {
	public static void main(String args[]) {
		
		// MVC -> VIEW CHAMA CONTROLLER, CONTROLLER MANIPULA MODEL
		
		// VIEW
		JTelaInicio jti = new JTelaInicio();
		jti.formInicio();
		
	}
}
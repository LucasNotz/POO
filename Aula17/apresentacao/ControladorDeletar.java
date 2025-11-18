package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;

import negocio.Compra;

public class ControladorDeletar implements ActionListener {
	private JList<String> lstCompra = null;
	
	
	public ControladorDeletar(JList<String> lstCompra) {
		super();
		this.lstCompra = lstCompra;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Compra.getTodos().get(lstCompra.getSelectedIndex()).despersistir();
		} catch (Exception erro) {
			erro.printStackTrace();
		}
	}

}

///adicionar refresh

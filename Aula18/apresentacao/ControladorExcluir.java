package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class ControladorExcluir implements ActionListener {
	private JList<String> lstPartes = null;
	private DefaultListModel<String> dlmPartes = null;
	
	//Construtor
	public ControladorExcluir(JList<String> lstPartes, DefaultListModel<String> dlmPartes) {
		super();
		this.lstPartes = lstPartes;
		this.dlmPartes = dlmPartes;
	}

	//Método implementado da interface
	@Override
	public void actionPerformed(ActionEvent e) {
		if (lstPartes.getSelectedIndex() == -1) return;
		dlmPartes.remove(lstPartes.getSelectedIndex());
		
	}

}

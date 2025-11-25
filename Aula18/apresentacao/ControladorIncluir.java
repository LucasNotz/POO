package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ControladorIncluir implements ActionListener {
	private JTextField txtNome = null;
	private JTextField txtCpf = null;
	private JRadioButton optAutor = null;
	private DefaultListModel<String> dlmPartes = null;
	
	//Construtor
	public ControladorIncluir(JTextField txtNome, JTextField txtCpf, JRadioButton optAutor,
			DefaultListModel<String> dlmPartes) {
		super();
		this.txtNome = txtNome;
		this.txtCpf = txtCpf;
		this.optAutor = optAutor;
		this.dlmPartes = dlmPartes;
	}


	//Método implementado da interface
	@Override
	public void actionPerformed(ActionEvent e) {
		dlmPartes.addElement(txtCpf.getText() + ", " + txtNome.getText() + ", " +  (optAutor.isSelected() ? 1 : 0));
	}

}

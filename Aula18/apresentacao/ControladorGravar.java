package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.Especie;
import negocio.Parte;
import negocio.Processo;

public class ControladorGravar implements ActionListener {
	private JTextField txtNumero = null;
	private JComboBox<String> cboEspecie = null;
	private JTextField txtVara = null;
	private DefaultListModel<String> dlmPartes = null;
	
	//Construtor
	public ControladorGravar(JTextField txtNumero, JComboBox<String> cboEspecie, JTextField txtVara,
			DefaultListModel<String> dlmPartes) {
		super();
		this.txtNumero = txtNumero;
		this.cboEspecie = cboEspecie;
		this.txtVara = txtVara;
		this.dlmPartes = dlmPartes;
	}

	//Metodo implementado da interface
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (txtNumero.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Campo vazio");
				return;
			}
			if (cboEspecie.getSelectedIndex() == 0) {
				JOptionPane.showMessageDialog(null, "Campo vazio");
				return;
			}
			if (txtVara.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Campo vazio");
				return;
			}
			if (dlmPartes.size() < 2) {
				JOptionPane.showMessageDialog(null, "Campo vazio");
				return;
			}
			
			//Composicao do objeto
			ArrayList<Parte> colecao = new ArrayList<Parte>();
			for (int i = 0; i < dlmPartes.getSize(); i++) {
				colecao.add(new Parte(0, dlmPartes.getElementAt(i).split(",")[0], dlmPartes.getElementAt(i).split(",")[1], dlmPartes.getElementAt(i).split(",")[2].equals("1")));
			}
			
			Processo objProcesso = new Processo();
			objProcesso.setNumero(txtNumero.getText());
			objProcesso.setObjEspecie(Especie.getTodos().get(cboEspecie.getSelectedIndex()-1));
			objProcesso.setVara(txtVara.getText());
			objProcesso.setColecao(colecao);
			
			objProcesso.persistir();
			JOptionPane.showMessageDialog(null, "FOI");
			
		} catch (Exception error) {
			error.printStackTrace();
		}
		

	}

}

package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Logic.Pessoa;
import Logic.UF;

public class RegisterController implements ActionListener {
	//class properties
	private JTextField nameTextField = null;
	private JRadioButton sexOptionMale = null;
	private JRadioButton sexOptionFemale = null;
	private JTextField addressTextField = null;
	private JComboBox<String> ufBox = null;
	
	//filled constructor
	public RegisterController(JTextField nameTextField, JRadioButton sexOptionMale, JRadioButton sexOptionFemale,
			JTextField addressTextField, JComboBox<String> ufBox) {
		super();
		this.nameTextField = nameTextField;
		this.sexOptionMale = sexOptionMale;
		this.sexOptionFemale = sexOptionFemale;
		this.addressTextField = addressTextField;
		this.ufBox = ufBox;
	}
	
	public void actionPerformed(ActionEvent e) {
		//data check
		if (nameTextField.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Campo nome vazio");
			return;
		}
		if (addressTextField.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Campo endereço vazio");
			return;
		}
		if (ufBox.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null,"Campo uf não selecionado");
			return;
		}
			
		//data register
		Pessoa objPessoa = new Pessoa();
		objPessoa.setName(nameTextField.getText());
		objPessoa.setSex(sexOptionMale.isSelected() ? "Masculino" : sexOptionFemale.isSelected() ? "Feminino" : "Não Informado");
		objPessoa.setAddress(addressTextField.getText());
		objPessoa.setObjUF(new UF(ufBox.getSelectedItem().toString()));
		
		JOptionPane.showMessageDialog(null,"Gravação realizad com sucesso!\n\n " + "nome: " + objPessoa.getName() + "\n" + "sexo: "
		+ objPessoa.getSex() + "\n" + "endereço: " + objPessoa.getAddress() + "\n" + "uf:" + objPessoa.getObjUF().getSigla());
		
		
	}

}

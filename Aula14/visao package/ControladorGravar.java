package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.Pessoa;

public class ControladorGravar implements ActionListener {

	private JTextField txtNome = null;
	private JTextField txtEndereco = null;
	private JTextField txtTelefone = null;

	//classes de controlador so tem o construtor cheio
	
	public ControladorGravar(JTextField txtNome, JTextField txtEndereco, JTextField txtTelefone) {
		super();
		this.txtNome = txtNome;
		this.txtEndereco = txtEndereco;
		this.txtTelefone = txtTelefone;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			
			if (txtNome.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "insira um nome");
				return;
			}
			if (txtEndereco.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "insira um endereço");
				return;
			}
			if (txtTelefone.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "insira um telefone");
				return;
			}
			
			
			Pessoa objPessoa = new Pessoa();
			objPessoa.setNome(txtNome.getText());
			objPessoa.setEndereco(txtEndereco.getText());
			objPessoa.setTelefone(txtTelefone.getText());
			objPessoa.persistir();
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}

	}



}

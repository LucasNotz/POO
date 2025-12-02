package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import negocio.Cliente;
import negocio.Conta;

public class ControladorCliente implements ActionListener {
	private JComboBox<String> cboCliente = null;
	private JComboBox<String> cboConta = null;

	public ControladorCliente(JComboBox<String> cboCliente, JComboBox<String> cboConta) {
		super();
		this.cboCliente = cboCliente;
		this.cboConta = cboConta;
	}

	public void actionPerformed(ActionEvent e) {
		cboConta.removeAllItems();
		cboConta.addItem("-- Selecione o Conta --");
		if (cboCliente.getSelectedIndex() == 0) return;
		
		try {
			for (Conta objConta : Conta.getTodos(Cliente.getTodos().get(cboCliente.getSelectedIndex()-1))) {
				cboConta.addItem((objConta.isTipo() ? "Poupança" : "Corrente") + ": "+ objConta.getAgencia() + " / " + objConta.getNumero());
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
		
	}

}

package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextArea;

import negocio.Cliente;
import negocio.Conta;
import negocio.Movimentacao;

public class ControladorExtrato implements ActionListener {
	private JComboBox<String> cboCliente = null;
	private JComboBox<String> cboConta = null;
	private JTextArea txtExtrato = null;
	
	public ControladorExtrato(JComboBox<String> cboCliente, JComboBox<String> cboConta, JTextArea txtExtrato) {
		super();
		this.cboCliente = cboCliente;
		this.cboConta = cboConta;
		this.txtExtrato = txtExtrato;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (cboConta.getSelectedIndex() == 0) return;
			
			Cliente objCliente = Cliente.getTodos().get(cboCliente.getSelectedIndex()-1);
			Conta objConta = Conta.getTodos(objCliente).get(cboConta.getSelectedIndex()-1);
			double total = 0;
			
			txtExtrato.setText("Extrato de conta " + (objConta.isTipo() ? "Poupança" : "Corrente") + "\n");
			txtExtrato.append("Clinte: " + objCliente.getNome() + "\n");
			txtExtrato.append("Agencia / Número: " + objConta.getAgencia() + " / " + objConta.getNumero() + "\n\n");
			
			for (Movimentacao objMovimentacao : Movimentacao.getTodos(objConta)) {
				txtExtrato.append(objMovimentacao.getData() + " " + objMovimentacao.getObjTipo().getDescricao() + " " +  objMovimentacao.getValor() + "\n");
				total += ((objMovimentacao.getObjTipo().isOperacao() ? -1 : 1) * objMovimentacao.getValor());
			}
			
			txtExtrato.append("Total: R$" + total);
		} catch (Exception error) {
			error.printStackTrace();
		}
	}

}

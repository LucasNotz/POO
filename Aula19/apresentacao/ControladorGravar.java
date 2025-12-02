package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.Cliente;
import negocio.Conta;
import negocio.Movimentacao;
import negocio.Tipo;

public class ControladorGravar implements ActionListener {
	private JComboBox<String> cboConta = null;
	private JComboBox<String> cboTipo = null;
	private JTextField txtValor = null;
	private JComboBox<String> cboCliente = null;
	
	public ControladorGravar(JComboBox<String> cboConta, JComboBox<String> cboTipo, JTextField txtValor,
			JComboBox<String> cboCliente) {
		super();
		this.cboConta = cboConta;
		this.cboTipo = cboTipo;
		this.txtValor = txtValor;
		this.cboCliente = cboCliente;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			Movimentacao objMovimentacao = new Movimentacao();
			
			objMovimentacao.setObjConta(Conta.getTodos(Cliente.getTodos().get(cboCliente.getSelectedIndex()-1)).get(cboConta.getSelectedIndex()-1));
			objMovimentacao.setObjTipo(Tipo.getTodos().get(cboTipo.getSelectedIndex()-1));
			Calendar objCalendario = Calendar.getInstance();
			objMovimentacao.setData(objCalendario.get(Calendar.YEAR) + "-" +
									objCalendario.get(Calendar.MONTH) + "-" +
									objCalendario.get(Calendar.DAY_OF_MONTH) + " "+
									objCalendario.get(Calendar.HOUR_OF_DAY) + ":"+
									objCalendario.get(Calendar.MINUTE) + ":"+
									objCalendario.get(Calendar.SECOND));
			objMovimentacao.setValor(Double.parseDouble(txtValor.getText()));
			
			objMovimentacao.persistir();
			JOptionPane.showMessageDialog(null, "Merry Christmas");
			
		} catch (Exception error) {
			error.printStackTrace();
		}
	}

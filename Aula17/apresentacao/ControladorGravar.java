package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.Cliente;
import negocio.Compra;
import negocio.Produto;

public class ControladorGravar implements ActionListener {
	private JComboBox<String> cboProduto = null;
	private JComboBox<String> cboCliente = null;
	private JTextField txtData = null;
	private JTextField txtQuantidade = null;
	private Compra objCompra = null;
	private JList<String> lstCompra = null;
	
	public ControladorGravar(JComboBox<String> cboProduto, JComboBox<String> cboCliente, JTextField txtData, JTextField txtQuantidade, JList<String> lstCompra) {
		this.cboCliente = cboCliente;
		this.cboProduto = cboProduto;
		this.txtData = txtData;
		this.lstCompra = lstCompra;
		this.txtQuantidade = txtQuantidade;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*if (cboCliente.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Selecione um cliente");
			return;
		}
		if (cboProduto.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Selecione um produto");
			return;
		}*/
		if (txtData.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Insira uma data");
			return;
		}
		if (txtQuantidade.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Insira uma quantidade");
			return;
		}
		


		
		try {
			
			objCompra = new Compra();
			objCompra.setObjCliente(Cliente.getTodos().get(cboCliente.getSelectedIndex()));
			objCompra.setObjProduto(Produto.getTodos().get(cboProduto.getSelectedIndex()));
			objCompra.setData(txtData.getText());
			objCompra.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
			objCompra.persistir();

			JOptionPane.showMessageDialog(null, "Tudo certo");
			
			((DefaultListModel<String>) lstCompra.getModel()).clear();;
			for (Compra objCompra : Compra.getTodos()) {
				((DefaultListModel<String>) lstCompra.getModel()).addElement(objCompra.getData() + " " + objCompra.getObjProduto().getNome() + " " + objCompra.getQuantidade() + " R$" + 
						(objCompra.getObjProduto().getPreco() * objCompra.getQuantidade()) + " " + objCompra.getObjCliente().getNome());
			}
			
		} catch (Exception error) {
			error.printStackTrace();
		}

	}

}

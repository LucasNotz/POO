package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import negocio.Cliente;
import negocio.Compra;
import negocio.Produto;

public class Visao extends JFrame {

	private static final long serialVersionUID = 1L;
	//Class attributes 
	private JLabel lblProduto = new JLabel("Produto");
	private JComboBox<String> cboProduto = new JComboBox<String>();
	
	private JLabel lblCliente = new JLabel("Cliente");
	private JComboBox<String> cboCliente = new JComboBox<String>();
	
	private JLabel lblData = new JLabel("Data");
	private JTextField txtData = new JTextField();
	
	private JLabel lblQuantidade = new JLabel("Quantidade");
	private JTextField txtQuantidade = new JTextField();
	
	private JButton btnGravar = new JButton("Gravar");
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnSair = new JButton("Sair");
	private JButton btnDeletar = new JButton("Deletar");
	
	private JList<String> lstCompra = new JList<String>();
	private DefaultListModel<String> dlmCompra = new DefaultListModel<String>();
	private JScrollPane jspCompra = new JScrollPane(lstCompra);
	
	//PSVM
	public static void main(String[] args) {
		new Visao().setVisible(true);
	}
	
	//Constructor
	public Visao() {
		setSize(400,700);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Compra na AMAZONABRAZUCA");
		
		lblProduto.setBounds(20,20,200,20);
		add(lblProduto);
		
		cboProduto.setBounds(20,50,200,20);
		try {
			for (Produto objProduto : Produto.getTodos()) {
				cboProduto.addItem(objProduto.getNome() + "R$" + objProduto.getPreco());
			}
		} catch (Exception error) {
			error.printStackTrace();
			JOptionPane.showMessageDialog(null, error);
		}
		add(cboProduto);
		
		lblCliente.setBounds(20,80,200,20);
		add(lblCliente);
		
		cboCliente.setBounds(20,110, 200,20);
		try {
			for (Cliente objCliente : Cliente.getTodos()) {
				cboCliente.addItem(objCliente.getNome());
			}
		} catch (Exception error) {
			error.printStackTrace();
			JOptionPane.showMessageDialog(null, error);
		}

		add(cboCliente);
		
		lblData.setBounds(20,140,200,20);
		add(lblData);
		
		txtData.setBounds(20,170,80,20);
		add(txtData);
		
		lblQuantidade.setBounds(20,200,200,20);
		add(lblQuantidade);
		
		txtQuantidade.setBounds(20,220,80,20);
		add(txtQuantidade);
		
		btnGravar.setBounds(20,250,100,20);
		btnGravar.addActionListener(new ControladorGravar(cboProduto, cboCliente, txtData, txtQuantidade, lstCompra));
		add(btnGravar);
		
		btnLimpar.setBounds(20,280,100,20);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cboProduto.setSelectedIndex(0);
				cboCliente.setSelectedIndex(0);
				txtData.setText("");
				txtQuantidade.setText("");
			}
		});
		add(btnLimpar);
		
		btnSair.setBounds(20,310,100,20);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(btnSair);
		
		btnDeletar.setBounds(130, 250, 100, 20);
		btnDeletar.addActionListener(new ControladorDeletar(lstCompra));
		add(btnDeletar);
		
		lstCompra.setModel(dlmCompra);
		try {
			for(Compra objCompra : Compra.getTodos()) {
				dlmCompra.addElement(objCompra.getData() + " " + objCompra.getObjProduto().getNome() + " " + objCompra.getQuantidade() + " R$" + 
			(objCompra.getObjProduto().getPreco() * objCompra.getQuantidade()) + " " + objCompra.getObjCliente().getNome());
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		jspCompra.setBounds(20,340,340,270);
		add(jspCompra);

		
	}
}

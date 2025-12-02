package apresentacao;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import negocio.Cliente;
import negocio.Tipo;

public class VisaoATM extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JLabel lblCliente = new JLabel("Cliente");
	private JComboBox<String> cboCliente = new JComboBox<String>();
	
	private JLabel lblConta = new JLabel("Conta");
	private JComboBox<String> cboConta = new JComboBox<String>();
	
	private JLabel lblTipo = new JLabel("Tipo");
	private JComboBox<String> cboTipo = new JComboBox<String>();
	
	private JLabel lblValor = new JLabel("Valor");
	private JTextField txtValor = new JTextField();
	
	private JButton btnGravar = new JButton("Gravar");
	private JButton btnExtrato = new JButton("Extrato");
	
	private JTextArea txtExtrato = new JTextArea();
	private JScrollPane jspExtrato = new JScrollPane(txtExtrato);
	
	public static void main(String[] args) {
		new VisaoATM().setVisible(true);
	}
	
	public VisaoATM() {
		setTitle("ATM Bancário");
		setSize(400,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		lblCliente.setBounds(10,10,200,20);
		add(lblCliente);
		cboCliente.setBounds(10,30,200,20);
		add(cboCliente);
		cboCliente.addItem("-- Selecione o Cliente --");
		try {
			for (Cliente objCliente : Cliente.getTodos()) {
				cboCliente.addItem(objCliente.getNome());
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
		cboCliente.addActionListener(new ControladorCliente(cboCliente, cboConta));
		
		lblConta.setBounds(10,60,200,20);
		add(lblConta);
		cboConta.setBounds(10,80,200,20);
		add(cboConta);
		
		lblTipo.setBounds(10,110,200,20);
		add(lblTipo);
		cboTipo.setBounds(10,130,200,20);
		add(cboTipo);
		cboTipo.addItem("-- Selecione o Tipo da Operação --");

		try {
			for (Tipo objTipo : Tipo.getTodos()) {
				cboTipo.addItem(objTipo.getDescricao());
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
		
		lblValor.setBounds(10,160,200,20);
		add(lblValor);
		txtValor.setBounds(10,180,100,20);
		add(txtValor);
		
		btnGravar.setBounds(90,210,100,30);
		add(btnGravar);
		btnGravar.addActionListener(new ControladorGravar(cboConta, cboTipo, txtValor, cboCliente));
		
		btnExtrato.setBounds(210,210,100,30);
		add(btnExtrato);
		btnExtrato.addActionListener(new ControladorExtrato(cboCliente, cboConta, txtExtrato));
		
		jspExtrato.setBounds(10,250,365,300);
		add(jspExtrato);
		txtExtrato.setLineWrap(true);
		
		
		
	}
	
}

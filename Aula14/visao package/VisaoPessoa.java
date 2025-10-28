package visao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VisaoPessoa extends JFrame {
	
	//propriedade da classe
	static final long serialVersionUID = 1L;
	
	private JLabel lblNome = new JLabel("Inserir nome: ");
	private JTextField txtNome = new JTextField();
	
	private JLabel lblEndereco = new JLabel("Inserir endereço: ");
	private JTextField txtEndereco = new JTextField();
	
	private JLabel lblTelefone = new JLabel("Inserir telefone: ");
	private JTextField txtTelefone = new JTextField();
	
	private JButton btnGravar = new JButton("Gravar");
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnSair = new JButton("Sair");
	
	
	//psvm
	public static void main(String[] args) {
		new VisaoPessoa().setVisible(true);
	}
	
	
	//construturo
	public VisaoPessoa() {
		setSize(500,300);
		setTitle("Registrar Pessoa");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		lblNome.setBounds(20,20,200,20);
		add(lblNome);
		
		txtNome.setBounds(20,50,200,20);
		add(txtNome);
		
		lblEndereco.setBounds(20,80,200,20);
		add(lblEndereco);
		
		txtEndereco.setBounds(20,110,200,20);
		add(txtEndereco);
		
		lblTelefone.setBounds(20,140,200,20);
		add(lblTelefone);
		
		txtTelefone.setBounds(20,170,200,20);
		add(txtTelefone);
		
		btnGravar.setBounds(300,50,100,20);
		add(btnGravar);
		
		btnGravar.addActionListener(new ControladorGravar(txtNome, txtEndereco, txtTelefone));

		btnLimpar.setBounds(300,110,100,20);
		add(btnLimpar);
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtEndereco.setText("");
				txtTelefone.setText("");
			}
		});
		
		btnSair.setBounds(300,170,100,20);
		add(btnSair);
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});
	}
	
	
}

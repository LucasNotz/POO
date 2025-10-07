package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import negocio.Tipo;

public class VisaoProduto extends JFrame {
	
	//propriedades da classe
	private static final long serialVersionUID = 1L;
	private JLabel lblNome = new JLabel("Nome");
	private JTextField txtNome = new JTextField();
	
	private JLabel lblPreco = new JLabel("Preço");
	private JTextField txtPreco = new JTextField();
	
	private JLabel lblTipo = new JLabel("Tipo");
	private JComboBox<String> cboTipo = new JComboBox<String>();
	
	private JCheckBox chkPerecivel = new JCheckBox("Perecivel");
	
	private JLabel lblDetalhamento = new JLabel("Detalhamento");
	private JTextArea txtDetalhamento = new JTextArea();
	private JScrollPane jspDetalhamento = new JScrollPane(txtDetalhamento);
	
	private JButton btnGravar = new JButton("Gravar");
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnSair = new JButton("Sair");
	
	//método principal de execução da classe
	public static void main(String[] arms) {
		new VisaoProduto().setVisible(true);
	}
	
	//método construção da classe
	public VisaoProduto() {
		//configuração da janela
		setTitle("Cadastro de Produtos");
		setSize(400,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		
		//config do nome
		lblNome.setBounds(10,10,200,20);
		add(lblNome);
		txtNome.setBounds(10,30,365,20);
		add(txtNome);
		
		//config do preco
		lblPreco.setBounds(10,60,200,20);
		add(lblPreco);
		txtPreco.setBounds(10,80,80,20);
		add(txtPreco);
		
		//config da caixa de selecao
		lblTipo.setBounds(10,110,200,20);
		add(lblTipo);
		cboTipo.setBounds(10,130,200,20);
		add(cboTipo);
		cboTipo.addItem("---Selecione---");
		try {
			for (Tipo objTipo : Tipo.getTodos()) {
				cboTipo.addItem(objTipo.getDescrição());
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null,erro);
		}
		
		//config da caixa de marcaçao perecível
		chkPerecivel.setBounds(10,160,200,20);
		add(chkPerecivel);
		
		//config da área da caixa de detalhamento
		lblDetalhamento.setBounds(10,190,200,20);
		add(lblDetalhamento);
		jspDetalhamento.setBounds(10,210,365,190);
		add(jspDetalhamento);
		txtDetalhamento.setLineWrap(true);
		
		//butões 
		btnGravar.setBounds(30,410, 100, 30);
		add(btnGravar);
		btnGravar.addActionListener(new ControladorGravar(txtNome,txtPreco,cboTipo,chkPerecivel,txtDetalhamento));

		btnLimpar.setBounds(140, 410, 100,30);
		add(btnLimpar);
		btnLimpar.addActionListener(new ControladorLimpar(txtNome,txtPreco,cboTipo,chkPerecivel,txtDetalhamento));
		
		btnSair.setBounds(250,410, 100,30);
		add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e ) {
				System.exit(0);
			}
		});
	}
}

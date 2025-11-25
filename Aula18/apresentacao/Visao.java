package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import negocio.Especie;

public class Visao extends JFrame {
	private static final long serialVersionUID = 1L;
	
	//Propriedades da classe
	
	private JLabel lblNumero = new JLabel("Numero do processo");
	private JTextField txtNumero = new JTextField();
	
	private JLabel lblEspecie = new JLabel("Especie");
	private JComboBox<String> cboEspecie = new JComboBox<String>();
	
	private JLabel lblVara = new JLabel("Vara do processo");
	private JTextField txtVara = new JTextField();
	
	private JLabel lblCpf = new JLabel("CPF da parte");
	private JTextField txtCpf = new JTextField();
	
	private JLabel lblNome = new JLabel("Nome da parte");
	private JTextField txtNome = new JTextField();
	
	private JLabel lblTipo = new JLabel("Tipo da parte");
	private JRadioButton optAutor = new JRadioButton("Autor");
	private JRadioButton optReu = new JRadioButton("Reu");
	private ButtonGroup btgTipo = new ButtonGroup();
	
	private JList<String> lstPartes = new JList<String>();
	private DefaultListModel<String> dlmPartes = new DefaultListModel<String>();
	private JScrollPane jspPartes = new JScrollPane(lstPartes);
	
	private JButton btnIncluir = new JButton("=>");
	private JButton btnExcluir = new JButton("<=");
	private JButton btnGravar = new JButton("Gravar");
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnSair = new JButton("Sair");
	
	// Método principal
	
	public static void main(String[] args) {
		new Visao().setVisible(true);
	}
	
	//Construtor
	public Visao() {
		setSize(800,600);
		setResizable(false);
		setTitle("Cadastro de processo judiciario");
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Configuracao do numero do processo
		lblNumero.setBounds(10,10,200,20);
		add(lblNumero);
		txtNumero.setBounds(10,30,200,20);
		add(txtNumero);
		
		lblEspecie.setBounds(10,60,200,20);
		add(lblEspecie);
		cboEspecie.setBounds(10,80,400,20);
		add(cboEspecie);
		cboEspecie.addItem("---SELECIONE---");
		try {
			for (Especie objEspecie : Especie.getTodos()) {
				cboEspecie.addItem(objEspecie.getDescricao());
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
		
		lblVara.setBounds(10,110,200,20);
		add(lblVara);
		txtVara.setBounds(10,130,400,20);
		add(txtVara);
		
		lblCpf.setBounds(10,200,200,20);
		add(lblCpf);
		txtCpf.setBounds(10,220,200,20);
		add(txtCpf);
		
		lblNome.setBounds(10,250,200,20);
		add(lblNome);
		txtNome.setBounds(10,280,250,20);
		add(txtNome);
		
		lblTipo.setBounds(10,300,200,20);
		optAutor.setBounds(10,320,100,20);
		add(optAutor);
		optReu.setBounds(110,320,100,20);
		add(optReu);
		btgTipo.add(optAutor);
		btgTipo.add(optReu);
		optAutor.setSelected(true);
		
		jspPartes.setBounds(400,200,350,150);
		add(jspPartes);
		lstPartes.setModel(dlmPartes);
		
		btnIncluir.setBounds(300,240,80,20);
		add(btnIncluir);
		btnIncluir.addActionListener(new ControladorIncluir(txtCpf, txtNome, optAutor, dlmPartes));
		
		btnExcluir.setBounds(300,270,80,20);
		add(btnExcluir);
		btnExcluir.addActionListener(new ControladorExcluir(lstPartes, dlmPartes));
		
		btnSair.setBounds(230,380,80,30);
		add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnGravar.setBounds(330,380,80,30);
		add(btnGravar);
		btnGravar.addActionListener(new ControladorGravar(txtNumero, cboEspecie, txtVara, dlmPartes));
		
		btnLimpar.setBounds(430,380,80,30);
		add(btnLimpar);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNumero.setText("");
				cboEspecie.setSelectedIndex(0);
				txtVara.setText("");
				txtCpf.setText("");
				txtNome.setText("");
				optAutor.setSelected(true);
				dlmPartes.removeAllElements();
			}
		});
		
	}
	
}

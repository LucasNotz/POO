package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import negocio.Autor;

public class visao extends JFrame{

	private static final long serialVersionUID = 1L;
	//propriedades 
	
	private JLabel lblTitulo = new JLabel("Titulo");
	private JTextField txtTitulo = new JTextField();
	private JLabel lblAutor = new JLabel("Autor");
	private JComboBox<String> cboAutor = new JComboBox<String>();
	private JButton btnGravar = new JButton("Gravar");
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnSair = new JButton("Sair");
	
	public static void main(String[] args) throws Exception {
		new visao().setVisible(true);
	}
	
	public visao() throws Exception {
		setTitle("Cadastro de livros");
		setSize(500,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		lblTitulo.setBounds(20,10,200,20);
		add(lblTitulo);
		
		txtTitulo.setBounds(20,30,300,20);
		add(txtTitulo);
		
		lblAutor.setBounds(20,60,200,20);
		add(lblAutor);
		
		cboAutor.setBounds(20,90,180,20);
		add(cboAutor);
		cboAutor.addItem("---------------Autor---------------");
		try {
			for (Autor objAutor : Autor.getTodos()) {
				cboAutor.addItem(objAutor.getAutorNome());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		btnGravar.setBounds(10,120,120,20);
		add(btnGravar);
		btnGravar.addActionListener(new ControladorGravar(txtTitulo, cboAutor));
		
		btnLimpar.setBounds(140,120,120,20);
		add(btnLimpar);
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTitulo.setText("");
				cboAutor.setSelectedIndex(0);
			}
		});
		
		btnSair.setBounds(270,120,120,20);
		add(btnSair);
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}

	

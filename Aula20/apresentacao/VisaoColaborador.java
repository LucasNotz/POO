package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import negocio.Cargo;
import negocio.Colaborador;
import negocio.FolhaDePagamento;

public class VisaoColaborador extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JLabel lblNome = new JLabel("Nome");
	private JTextField txtNome = new JTextField();
	
	private JLabel lblCargo = new JLabel("Cargo");
	private JComboBox<String> cboCargo = new JComboBox<String>();
	
	private JButton btnGravar = new JButton("Gravar");
	private JButton btnCalcular = new JButton("Calcular");
	
	private JTextArea txtFolha = new JTextArea();
	private JScrollPane jspFolha = new JScrollPane(txtFolha);

	public static void main(String[] args) {
		new VisaoColaborador().setVisible(true);
	}
	
	public VisaoColaborador() {
		setTitle("Cadastro de Colaboradores e Cálculo de Folha");
		setSize(500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		lblNome.setBounds(10,10,200,20);
		add(lblNome);
		
		txtNome.setBounds(10,30,465,20);
		add(txtNome);
		
		lblCargo.setBounds(10,60,200,20);
		add(lblCargo);
		
		cboCargo.setBounds(10,80, 465,20);
		add(cboCargo);
		cboCargo.addItem("--- Selecione o Cargo ---");
		try {
			for (Cargo objCargo : Cargo.getTodos()) {
				cboCargo.addItem(objCargo.getNome());
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro);
		}
		
		btnGravar.setBounds(140,110, 100, 30);
		add(btnGravar);
		btnGravar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Colaborador objColaborador = new Colaborador();
					
					objColaborador.setNome(txtNome.getText());
					objColaborador.setObjCargo(Cargo.getTodos().get(cboCargo.getSelectedIndex()-1));
					objColaborador.persitir();
					JOptionPane.showMessageDialog(null, "Gravação realizada");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		btnCalcular.setBounds(260,110, 100, 30);
		add(btnCalcular);
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					txtFolha.setText(FolhaDePagamento.calcular());
				} catch (Exception error) {
					error.printStackTrace();
				}
			}
		});
		
		
		jspFolha.setBounds(10, 150, 465, 200);
		add(jspFolha);
		txtFolha.setLineWrap(true);
		
		
	}
	
}

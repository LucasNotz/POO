package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.Disciplina;
import negocio.Professor;

public class VisaoTurma extends JFrame {

	private static final long serialVersionUID = 1L;
	//Class attributes 
	private JLabel lblDisciplina = new JLabel("Disciplina");
	private JComboBox<String> cboDisciplina = new JComboBox<String>();
	
	private JLabel lblProfessor = new JLabel("Professor");
	private JComboBox<String> cboProfessor = new JComboBox<String>();
	
	private JLabel lblLetra = new JLabel("Letra");
	private JTextField txtLetra = new JTextField();
	
	private JButton btnGravar = new JButton("Gravar");
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnSair = new JButton("Sari");
	
	//PSVM
	public static void main(String[] args) {
		new VisaoTurma().setVisible(true);
	}
	
	//Constructor
	public VisaoTurma() {
		setSize(400,400);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Turma Registrar");
		
		lblDisciplina.setBounds(20,20,200,20);
		add(lblDisciplina);
		
		cboDisciplina.setBounds(20,50,200,20);
		cboDisciplina.addItem("Selecione a disciplina");
		try {
			for (Disciplina objDisciplina : Disciplina.getTodos()) {
				cboDisciplina.addItem(objDisciplina.getNome());
			}
		} catch (Exception error) {
			error.printStackTrace();
			JOptionPane.showMessageDialog(null, error);
		}
		add(cboDisciplina);
		
		lblProfessor.setBounds(20,80,200,20);
		add(lblProfessor);
		
		cboProfessor.setBounds(20,110, 200,20);
		cboProfessor.addItem("Selecione o professor");
		try {
			for (Professor objProfessor : Professor.getTodos()) {
				cboProfessor.addItem(objProfessor.getTitulacao() + " " + objProfessor.getNome());
			}
		} catch (Exception error) {
			error.printStackTrace();
			JOptionPane.showMessageDialog(null, error);
		}

		add(cboProfessor);
		
		lblLetra.setBounds(20,140,200,20);
		add(lblLetra);
		
		txtLetra.setBounds(20,170,20,20);
		add(txtLetra);
		
		btnGravar.setBounds(20,200,100,20);
		btnGravar.addActionListener(new ControladorGravar(cboDisciplina, cboProfessor, txtLetra));
		add(btnGravar);
		
		btnLimpar.setBounds(20,230,100,20);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cboDisciplina.setSelectedIndex(0);
				cboProfessor.setSelectedIndex(0);
				txtLetra.setText("");
			}
		});
		add(btnLimpar);
		
		btnSair.setBounds(20,260,100,20);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(btnSair);
		
	}
}

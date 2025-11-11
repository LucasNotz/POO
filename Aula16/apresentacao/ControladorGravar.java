package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.Disciplina;
import negocio.Professor;
import negocio.Turma;

public class ControladorGravar implements ActionListener {
	//Class attributes
	private JComboBox<String> cboDisciplina = null;
	private JComboBox<String> cboProfessor = null;
	private JTextField txtLetra = null;
	
	public ControladorGravar(JComboBox<String> cboDisciplina, JComboBox<String> cboProfessor, JTextField txtLetra) {
		this.cboDisciplina = cboDisciplina;
		this.cboProfessor = cboProfessor;
		this.txtLetra = txtLetra;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Data check
		if (cboDisciplina.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Selecione uma disciplina");
			return;
		}
		if (cboProfessor.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "Selecione um professor");
			return;
		}
		if (txtLetra.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Insira uma letra");
			return;
		}
		if (txtLetra.getText().length() > 2) {
			JOptionPane.showMessageDialog(null, "Insira apenas uma letra");
			return;
		}
		
		//Composicao do obj
		try {
			Turma objTurma = new Turma();
			objTurma.setObjDisciplina(
					((ArrayList<Disciplina>) Disciplina.getTodos()).get(cboDisciplina.getSelectedIndex() - 1));
			objTurma.setObjProfessor(
					((ArrayList<Professor>) Professor.getTodos()).get(cboProfessor.getSelectedIndex() - 1));
			objTurma.setLetra(txtLetra.getText());
			objTurma.persistir(); // persistir this
		} catch (Exception error) {
			error.printStackTrace();
		}

	}

}

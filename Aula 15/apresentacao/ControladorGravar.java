package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import negocio.Autor;
import negocio.Livro;

public class ControladorGravar implements ActionListener {

	private JTextField txtTitulo = null;
	private JComboBox<String> cboAutor = null;
	private Livro objLivro = new Livro();
	
	public ControladorGravar(JTextField txtTitulo, JComboBox<String> cboAutor) {
		this.txtTitulo = txtTitulo;
		this.cboAutor = cboAutor;
	}
	
	public void actionPerformed(ActionEvent e) {
		//critica de dados
		if (txtTitulo.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "inserir titulo");
			return;
		}
		
		if (cboAutor.getSelectedIndex() == 0) {
			JOptionPane.showMessageDialog(null, "selecione autor");
			return;
		}
		
		try {
			objLivro.setTituloLivro(txtTitulo.getText());
			objLivro.setObjAutor((Autor) Autor.getTodos().toArray()[cboAutor.getSelectedIndex() -1]);
			objLivro.persistir();
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}

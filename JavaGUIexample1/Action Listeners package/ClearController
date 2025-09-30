package ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ClearController implements ActionListener{
	//class properties
	private JTextField nameTextField = null;
	private JRadioButton sexOptionMale = null;
	private JTextField addressTextField = null;
	private JComboBox<String> ufBox = null;
	
	
	//filled constructor
	public ClearController(JTextField nameTextField, JRadioButton sexOptionMale, JTextField addressTextField,
			JComboBox<String> ufBox) {
		super();
		this.nameTextField = nameTextField;
		this.sexOptionMale = sexOptionMale;
		this.addressTextField = addressTextField;
		this.ufBox = ufBox;
	}



	public void actionPerformed(ActionEvent e) {
		nameTextField.setText("");
		sexOptionMale.setSelected(true);
		addressTextField.setText("");
		ufBox.setSelectedIndex(0);
	}

}

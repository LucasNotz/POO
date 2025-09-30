package Visual;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ActionListeners.ClearController;
import ActionListeners.ExitController;
import ActionListeners.RegisterController;

import Logic.UF;

public class GUI extends JFrame {
	//class properties
	private static final long serialVersionUID = 1L;
	
	//labels 
	private JLabel nameLabel = new JLabel("Nome: "); //for name
	private JLabel sexLabel = new JLabel("Sex: "); //for sex
	private JLabel addressLabel = new JLabel("Endereço: ");// for address
	private JLabel ufLabel = new JLabel("UF: "); //for state
	
	//textfields
	private JTextField nameTextField = new JTextField(); // for name
	private JTextField addressTextField = new JTextField(); // for address
	
	//Radiobutton 
	private ButtonGroup sexButtonGroup = new ButtonGroup(); //for sex 
	private JRadioButton sexOptionMale = new JRadioButton("Masculino");
	private JRadioButton sexOptionFemale = new JRadioButton("Feminino");
	private JRadioButton sexOptionOther = new JRadioButton("Outro");
	
	//Dropdown option
	private JComboBox<String> ufBox = new JComboBox<String>(); // for uf 
		//items are added later

	//Buttons
	private JButton buttonRegister = new JButton("Gravar");
	private JButton buttonClear = new JButton("Limpar");
	private JButton buttonExit = new JButton("Sair");
	
	
	//main method
	public static void main(String args[]) {
		new GUI().setVisible(true);
	}
	
	//GUI creator method
	public GUI() {
		//create window
		setTitle("Cadastrar Pessoa");
		setSize(400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		//name 
		nameLabel.setBounds(30,10,100,50);
		add(nameLabel);
		
		nameTextField.setBounds(30,60,300,20);
		add(nameTextField);
			//x:30 y:80(max)
		
		//sex
		sexLabel.setBounds(30,100,100,20);
		add(sexLabel);
		
		sexOptionMale.setBounds(30,140,100,20); // yMAX 160 xMAX 130
		add(sexOptionMale);
		sexOptionFemale.setBounds(140,140,100,20); // yMAX 160 xMAX 240
		add(sexOptionFemale);
		sexOptionOther.setBounds(250,140,100,20); // yMAX 160 xMAX 350
		add(sexOptionOther);
		sexOptionMale.setSelected(true);
		
		sexButtonGroup.add(sexOptionMale);
		sexButtonGroup.add(sexOptionFemale);
		sexButtonGroup.add(sexOptionOther);
			//adds to button group
			//x: 30 ymax:160
		
		//address
		addressLabel.setBounds(30,180,100,20); 
		add(addressLabel);
		
		addressTextField.setBounds(30,220,300,20);
		add(addressTextField);
			//x:30  ymax:240
		
		//UF
		ufLabel.setBounds(30,260,100,20); // yMAX: 280
		add(ufLabel);
		
		ufBox.setBounds(30,300,100,20);
		add(ufBox);
		
		ufBox.addItem("--Selecione--");
		
		//try catch dont know why we added it
		try {
			for (UF objUF : UF.getTodos()) { //cria uma instancia de objUF para cada elemento do array
				ufBox.addItem(objUF.getSigla()); //adiciona a sigla dessa instancia
			}
			
		}catch (Exception error) {
			JOptionPane.showMessageDialog(null,error);
		}
			//xmax:130   ymax:320
		
		
		//buttons
		buttonRegister.setBounds(150,270,90,30); //xmax: 240
		add(buttonRegister);
		buttonRegister.addActionListener(new RegisterController(nameTextField,sexOptionMale,sexOptionFemale,addressTextField,ufBox));
		
		buttonClear.setBounds(250,270,90,30);
		add(buttonClear);
		buttonClear.addActionListener(new ClearController(nameTextField,sexOptionMale,addressTextField,ufBox));
		
		buttonExit.setBounds(200,310,90,30);
		add(buttonExit);
		buttonExit.addActionListener(new ExitController());
		
	}
}

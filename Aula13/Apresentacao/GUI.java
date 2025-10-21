package Visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Negocio.Fabricante;
import Negocio.Veiculo;

public class GUI extends JFrame {
	//class variables
	private static final long serialVersionUID = 1L;
		//Labels
	private JLabel fabLbl = new JLabel("Fabricante");
	private JLabel modLbl = new JLabel("Modelo");
	private JLabel corLbl = new JLabel("Cor");
		//Buttons
	private JButton gravarBtn = new JButton("Gravar");
	private JButton sairBtn = new JButton("Sair");
	private JButton limparBtn = new JButton("Limpar");
		//Combo boxes
	private JComboBox<String> fabBox = new JComboBox<String>();
	private JComboBox<String> corBox = new JComboBox<String>();
		//Textfield
	private JTextField modTxt = new JTextField();
		//Check box
	private JCheckBox ttsChk = new JCheckBox("Teto solar");
	
	
	public static void main(String[] args) {
		new GUI().setVisible(true);
		
	}
	
	public GUI() {
		setSize(410,350);
		setResizable(false);
		setTitle("CAD VEICULO");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);
		
		//Elementos da tela
		
		//Fabricante
		fabLbl.setBounds(20,20,200,20);
		add(fabLbl);
		fabBox.setBounds(20,50,200,20);
		add(fabBox);
		fabBox.addItem("--------------Selecione------------");
		try {
			for (Fabricante objFab : Fabricante.getTodos()) {
				fabBox.addItem(objFab.getNome());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		//Modelo
		modLbl.setBounds(20,80,200,20);
		add(modLbl);
		modTxt.setBounds(20,110,200,20);
		add(modTxt);
		
		//Cor
		corLbl.setBounds(20,140,200,20);
		add(corLbl);
		corBox.setBounds(20,170,150,20);
		add(corBox);
		corBox.addItem("-----Selecione-----");
		corBox.addItem("Azul");
		corBox.addItem("Vermelho");
		corBox.addItem("Amarelo");
		corBox.addItem("Verde");
		corBox.addItem("Marrom");
		corBox.addItem("Roxo");
		corBox.addItem("Rosa");
		corBox.addItem("Branco");
		corBox.addItem("Cinza");
		corBox.addItem("Preto");
		
		//Teto solar
		ttsChk.setBounds(20,210,200,20);
		add(ttsChk);
		
		//botões
		gravarBtn.setBounds(110,240,80,20);
		add(gravarBtn);
		
		limparBtn.setBounds(200,240,80,20);
		add(limparBtn);
		
		sairBtn.setBounds(290,240,80,20);
		add(sairBtn);
		
		//funcao 
		gravarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//critica de dados
				if (fabBox.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Escolha um fabricante");
					return;
				}
				
				if (corBox.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Escolha uma cor");
					return;
				}
				
				if (modTxt.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Insira um modelo");
					return;
				}
				
				//composicao do obj
				Veiculo objVeiculo = new Veiculo();
				objVeiculo.setObjFabricante(new Fabricante(fabBox.getSelectedItem().toString()));
				objVeiculo.setModelo(modTxt.getText());
				objVeiculo.setCor(corBox.getSelectedItem().toString());
				objVeiculo.setTetoSolar(ttsChk.isSelected());
				JOptionPane.showMessageDialog(null,
						"Veiculo criado com sucesso" + "\n" + 
						"Fabricante: " + objVeiculo.getObjFabricante().getNome() + "\n" +
						"Modelo: " + objVeiculo.getModelo() + "\n" +
						"Cor: " + objVeiculo.getCor() + "\n" +
						"Teto solar" + (objVeiculo.isTetoSolar() ? "Sim" : "Não")
						);
				
				
			}
		});
		
		sairBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		limparBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fabBox.setSelectedIndex(0);
				corBox.setSelectedIndex(0);
				modTxt.setText("");
				ttsChk.setSelected(false);
			}
		});
	}
}

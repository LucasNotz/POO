package Negocio;

import java.util.ArrayList;
import java.util.Collection;

public class Fabricante {
	//class variables
	private String nome = "";

	//constructors
	public Fabricante() {
		super();
	}

	public Fabricante(String nome) {
		super();
		this.nome = nome;
	}
	
	//getters and setters (access methods)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//Class methods
	//create generic collection
	//defines it as array list 
	//static so you can access without instancing the class
	public static Collection<Fabricante> getTodos() throws Exception {
		ArrayList<Fabricante> colecao = new ArrayList<Fabricante>();
		colecao.add(new Fabricante("Audi"));
		colecao.add(new Fabricante("BMW"));
		colecao.add(new Fabricante("Chevrolet"));
		colecao.add(new Fabricante("Ferrari"));
		colecao.add(new Fabricante("GMW"));
		colecao.add(new Fabricante("Honda"));
		colecao.add(new Fabricante("Kia"));
		colecao.add(new Fabricante("Mclaren"));
		colecao.add(new Fabricante("Rolls-Royce"));
		colecao.add(new Fabricante("Volvo"));
		
		
		return colecao;
	}
	
	
}

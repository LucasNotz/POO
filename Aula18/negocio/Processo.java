package negocio;

import java.util.ArrayList;

import persistencia.ParteDAO;
import persistencia.ProcessoDAO;
import persistencia.ProcessoParteDAO;

public class Processo {
	// Propriedades
	private int id = 0;
	private String numero = "";
	private Especie objEspecie = null;
	private String vara = "";
	//Onde o java diferencia do banco de dados
	private ArrayList<Parte> colecao = null;
	
	// Construtores
	public Processo() {
		super();
	}
	public Processo(int id, String numero, Especie objEspecie, String vara, ArrayList<Parte> colecao) {
		super();
		this.id = id;
		this.numero = numero;
		this.objEspecie = objEspecie;
		this.vara = vara;
		this.colecao = colecao;
	}
	
	// Getters & Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Especie getObjEspecie() {
		return objEspecie;
	}
	public void setObjEspecie(Especie objEspecie) {
		this.objEspecie = objEspecie;
	}
	public String getVara() {
		return vara;
	}
	public void setVara(String vara) {
		this.vara = vara;
	}
	public ArrayList<Parte> getColecao() {
		return colecao;
	}
	public void setColecao(ArrayList<Parte> colecao) {
		this.colecao = colecao;
	}
	
	// Métodos da classe
	public void persistir() throws Exception {
		//Gravacao das pessoas
		for (Parte objParte : this.getColecao()) {
			objParte.persistir();
			objParte.setId(objParte.getUltimoId());
		}
		//Gravacao do processo
		new ProcessoDAO().persistir(this);
		this.setId(this.getUltimoId());
		
		//Associcao das pessoas às partes do processo
		new ProcessoParteDAO().persistir(this);
		

	}
	
	public int getUltimoId() throws Exception {
		return new ProcessoDAO().getUltimoId();
	}
}

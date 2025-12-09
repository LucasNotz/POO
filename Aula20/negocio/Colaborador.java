package negocio;

import java.util.ArrayList;

import persistencia.ColaboradorDAO;

public class Colaborador {
	private int id = 0;
	private String nome = "";
	private Cargo objCargo = null;
	
	public Colaborador() {
		super();
	}
	
	public Colaborador(int id, String nome, Cargo objCargo) {
		super();
		this.id = id;
		this.nome = nome;
		this.objCargo = objCargo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Cargo getObjCargo() {
		return objCargo;
	}
	public void setObjCargo(Cargo objCargo) {
		this.objCargo = objCargo;
	}
	
	public static ArrayList<Colaborador> getTodos() throws Exception {
		return new ColaboradorDAO().getTodos();
	}
	
	public void persitir() throws Exception {
		new ColaboradorDAO().persistir(this);
	}
}

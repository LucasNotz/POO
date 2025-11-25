package negocio;

import persistencia.ParteDAO;

public class Parte {
	// Propriedades da classe
	private int id = 0;
	private String cpf = "";
	private String nome = "";
	private boolean tipo = false;
	
	// Construtores
	public Parte() {
		super();
	}
	public Parte(int id, String cpf, String nome, boolean tipo) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.tipo = tipo;
	}
	
	// Getters & Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isTipo() {
		return tipo;
	}
	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	
	// Métodos da classe
	
	public void persistir() throws Exception {
		new ParteDAO().persistir(this);
	}
	
	public int getUltimoId() throws Exception {
		return new ParteDAO().getUltimoId();
	}
	
}

package negocio;

import java.util.Collection;

import persistencia.ProfessorDAO;

public class Professor {
	//Class attributes
	private int id = 0;
	private String nome = "";
	private String titulacao = "";
	
	//Constructor
	public Professor() {
		super();
	}
	public Professor(int id, String nome, String titulacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.titulacao = titulacao;
	}
	
	//Access methods
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
	public String getTitulacao() {
		return titulacao;
	}
	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}
	
	//Class methods
	public static Collection<Professor> getTodos() throws Exception {
		return new ProfessorDAO().getTodos();
	}
}
	
	

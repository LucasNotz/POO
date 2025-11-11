package negocio;

import java.util.Collection;

import persistencia.DisciplinaDAO;

public class Disciplina {
	//Class attributes
	private int id = 0;
	private String nome = "";
	
	//Constructor
	public Disciplina() {
		super();
	}
	public Disciplina(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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
	
	
	//Class methods
	public static Collection<Disciplina> getTodos() throws Exception {
		return new DisciplinaDAO().getTodos();
	}
}

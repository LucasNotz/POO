package negocio;

import java.util.Collection;

import persistencia.AutorDAO;

public class Autor {
	//propriedades da classe
	private int id = 0;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String autorNome = "";
	
	public Autor() {
		
	}
	
	public Autor(int id,String autorNome) {
		this.id = id;
		this.autorNome = autorNome;
	}
	
	public String getAutorNome() {
		return autorNome;
	}
	
	public void setAutorNome(String autorNome) {
		this.autorNome = autorNome;
	}
	
	public static Collection<Autor> getTodos() throws Exception {
		return new AutorDAO().getTodos();
	}
}

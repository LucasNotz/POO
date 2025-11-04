package negocio;

import persistencia.LivroDAO;

public class Livro {
	//propriedades da classe
	private int id = 0;
	private String tituloLivro = "";
	private Autor objAutor = null;
	
	public Livro() {
		
	}
	
	public Livro(String tituloLivro, Autor objAutor, int id) {
		this.id = id;
		this.tituloLivro = tituloLivro;
		this.objAutor = objAutor;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTituloLivro() {
		return tituloLivro;
	}
	
	public void setTituloLivro(String titulo) {
		this.tituloLivro = titulo;
	}
	
	public Autor getObjAutor() {
		return objAutor;
	}
	
	public void setObjAutor(Autor objAutor) {
		this.objAutor = objAutor;
	}
	
	public void persistir() throws Exception {
		new LivroDAO().persistir(this);
	}
}

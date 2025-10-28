package negocio;

import persistencia.PessoaDAO;

public class Pessoa {
	//propriedades da classe
	private int id = 0;
	private String nome = "";
	private String endereco = "";
	private String telefone = "";
	
	//construtores
	public Pessoa() {
		super();
	}
	public Pessoa(int id, String nome, String endereco, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	
	//getters setters
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	//métodos da classe
	
	public void persistir() throws Exception {
		//instancia da camadada dao
		//persistir a mim mesmo 
			//invoca dao e faz sql gravacao
		new PessoaDAO().persistir(this);
	}
}

package negocio;

import java.util.ArrayList;

import persistencia.TipoDAO;

public class Tipo {
	private int id = 0;
	private String descricao = "";
	private boolean operacao = false;
	
	//Constructors 
	public Tipo() {
		super();
	}
	public Tipo(int id, String descricao, boolean operacao) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.operacao = operacao;
	}
	
	//Access
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isOperacao() {
		return operacao;
	}
	public void setOperacao(boolean operacao) {
		this.operacao = operacao;
	}
	
	//Methods
	public static ArrayList<Tipo> getTodos() throws Exception {
		return new TipoDAO().getTodos();
	}
	
}

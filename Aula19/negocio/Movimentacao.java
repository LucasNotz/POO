package negocio;

import java.util.ArrayList;

import persistencia.MovimentacaoDAO;

public class Movimentacao {
	private int id = 0;
	private Conta objConta = null;
	private Tipo objTipo = null;
	private String data = "";
	private double valor = 0;
	
	//Constructors
	public Movimentacao() {
		super();
	}
	public Movimentacao(int id, Conta objConta, Tipo objTipo, String data, double valor) {
		super();
		this.id = id;
		this.objConta = objConta;
		this.objTipo = objTipo;
		this.data = data;
		this.valor = valor;
	}
	
	//Access
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Conta getObjConta() {
		return objConta;
	}
	public void setObjConta(Conta objConta) {
		this.objConta = objConta;
	}
	public Tipo getObjTipo() {
		return objTipo;
	}
	public void setObjTipo(Tipo objTipo) {
		this.objTipo = objTipo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	//Methods
	public static ArrayList<Movimentacao> getTodos(Conta objConta) throws Exception {
		return new MovimentacaoDAO().getTodos(objConta);
	}
	
	public void persistir() throws Exception {
		new MovimentacaoDAO().persistir(this);
	}
}

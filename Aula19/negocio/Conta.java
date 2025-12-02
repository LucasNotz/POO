package negocio;

import java.util.ArrayList;

import persistencia.ContaDAO;

public class Conta {
	private int id = 0;
	private Cliente objCliente = null;
	private int agencia = 0;
	private int numero = 0;
	private boolean tipo = false;
	
	//Constructors
	public Conta() {
		super();
	}
	public Conta(int id, Cliente objCliente, int agencia, int numero, boolean tipo) {
		super();
		this.id = id;
		this.objCliente = objCliente;
		this.agencia = agencia;
		this.numero = numero;
		this.tipo = tipo;
	}
	
	//Access
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getObjCliente() {
		return objCliente;
	}
	public void setObjCliente(Cliente objCliente) {
		this.objCliente = objCliente;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public boolean isTipo() {
		return tipo;
	}
	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	
	//Methods
	public static ArrayList<Conta> getTodos(Cliente objCliente) throws Exception {
		return new ContaDAO().getTodos(objCliente);
	}
}

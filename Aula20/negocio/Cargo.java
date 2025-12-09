package negocio;

import java.util.ArrayList;

import persistencia.CargoDAO;

public class Cargo {
	private int id = 0;
	private String nome = "";
	private double salario = 0;
	
	public Cargo() {
		super();
	}
	
	public Cargo(int id, String nome, double salario) {
		super();
		this.id = id;
		this.nome = nome;
		this.salario = salario;
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
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public static ArrayList<Cargo> getTodos() throws Exception {
		return new CargoDAO().getTodos();
	}
	
}

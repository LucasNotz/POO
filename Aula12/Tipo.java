package negocio;

import java.util.Collection;
import java.util.LinkedList;

public class Tipo {
	//propriedade da class
	private String descrição = "";

	//métodos contstrutuores da classe
	public Tipo() {
		super();
	}

	public Tipo(String descrição) {
		super();
		this.descrição = descrição;
	}

	//métodos de acesso da classe
	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
	
	//metodos da classe
	public static Collection<Tipo> getTodos() throws Exception {
		LinkedList<Tipo> colecao = new LinkedList<Tipo>();
		
		colecao.add(new Tipo("Eletrônico"));
		colecao.add(new Tipo("Vestuário"));
		colecao.add(new Tipo("Livro"));
		colecao.add(new Tipo("Produto de Beleza"));
		colecao.add(new Tipo("Ferramenta"));
		
		return colecao;
	}
}

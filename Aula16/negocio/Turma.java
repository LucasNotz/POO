package negocio;

import persistencia.TurmaDAO;

public class Turma {
	//Class attributes
	private int id = 0;
	private Disciplina objDisciplina = null;
	private Professor objProfessor = null;
	private String letra = "";
	
	//Constructor
	public Turma() {
		super();
	}
	public Turma(int id, Disciplina objDisciplina, Professor objProfessor, String letra) {
		super();
		this.id = id;
		this.objDisciplina = objDisciplina;
		this.objProfessor = objProfessor;
		this.letra = letra;
	}
	
	//Access methods
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Disciplina getObjDisciplina() {
		return objDisciplina;
	}
	public void setObjDisciplina(Disciplina objDisciplina) {
		this.objDisciplina = objDisciplina;
	}
	public Professor getObjProfessor() {
		return objProfessor;
	}
	public void setObjProfessor(Professor objProfessor) {
		this.objProfessor = objProfessor;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	
	//
	public void persistir() throws Exception {
		new TurmaDAO().persistir(this);
	}
}

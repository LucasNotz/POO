package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import negocio.Professor;

public class ProfessorDAO {
	//Class attributes
	private BancoDeDados database = new BancoDeDados();
	private PreparedStatement objExecucao = null;
	private ResultSet objCursor = null;
	
	//
	public Collection<Professor> getTodos() throws Exception {
		ArrayList<Professor> colecao = new ArrayList<Professor>();
		
		database.conectar();
		
		objExecucao = database.getObjConexao().prepareStatement("SELECT * FROM PRF_PROFESSOR");
				
		objCursor = objExecucao.executeQuery();
		
		while(objCursor.next()) {
			colecao.add(new Professor(objCursor.getInt("PRF_ID"), objCursor.getString("PRF_NOME"), objCursor.getString("PRF_TITULACAO")));
		}
		
		database.desconectar();
		
		return colecao;
	}
}

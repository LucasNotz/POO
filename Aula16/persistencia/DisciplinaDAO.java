package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import negocio.Disciplina;

public class DisciplinaDAO {
	//Class attributes
	private BancoDeDados database = new BancoDeDados();
	private PreparedStatement objExecucao = null;
	private ResultSet objCursor = null;
	
	//
	public Collection<Disciplina> getTodos() throws Exception {
		ArrayList<Disciplina> colecao = new ArrayList<Disciplina>();
		
		database.conectar();
		
		objExecucao = database.getObjConexao().prepareStatement("SELECT * FROM DIS_DISCIPLINA");
				
		objCursor = objExecucao.executeQuery();
		
		while(objCursor.next()) {
			colecao.add(new Disciplina(objCursor.getInt("DIS_ID"), objCursor.getString("DIS_NOME")));
		}
		
		database.desconectar();
		
		return colecao;
	}
}

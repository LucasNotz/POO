package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import negocio.Turma;

public class TurmaDAO {
	//Class attributes
	private BancoDeDados database = new BancoDeDados();
	private PreparedStatement objExecucao = null;
	
	//
	public void persistir(Turma objTurma) throws Exception{
		database.conectar();
		
		objExecucao = database.getObjConexao().prepareStatement("INSERT INTO TUR_TURMA"
				+ "(TUR_IDDISCIPLINA, TUR_IDPROFESSOR, TUR_LETRA)"
				+ "VALUES ( ?,?,?)");
		
		objExecucao.setInt(1,objTurma.getObjDisciplina().getId());
		objExecucao.setInt(2,objTurma.getObjProfessor().getId());
		objExecucao.setString(3,objTurma.getLetra());
		
		objExecucao.executeUpdate();
		
		database.desconectar();
	}
}

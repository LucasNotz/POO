package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import negocio.Processo;

public class ProcessoDAO {
	//Class attributes
	private BancoDeDados database = new BancoDeDados();
	private PreparedStatement objExecucao = null;
	private ResultSet objCursor = null;
	
	//Métodos da classe
	public void persistir(Processo objProcesso) throws Exception{
		database.conectar();
		
		objExecucao = database.getObjConexao().prepareStatement(
				  "INSERT INTO PRC_PROCESSO"
				+ "(PRC_NUMERO, PRC_IDESPECIE, PRC_VARA)"
				+ "VALUES ( ?,?,?)");
		
		objExecucao.setString(1,objProcesso.getNumero());
		objExecucao.setInt(2,objProcesso.getObjEspecie().getId());
		objExecucao.setString(3,objProcesso.getVara());
		
		objExecucao.executeUpdate();
		
		database.desconectar();
	}
	
	public int getUltimoId() throws Exception {
		int ultimoId = 0;
		database.conectar();
		
		objExecucao = database.getObjConexao().prepareStatement(
				"SELECT MAX(PRC_ID) FROM PRC_PROCESSO"
				);
		
		objCursor = objExecucao.executeQuery();
		
		while (objCursor.next()) {
			ultimoId = objCursor.getInt(1);
		}
		
		database.desconectar();
		
		return ultimoId;
	}
	
}

package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import negocio.Parte;

public class ParteDAO {
	//Class attributes
	private BancoDeDados database = new BancoDeDados();
	private PreparedStatement objExecucao = null;
	private ResultSet objCursor = null;
	
	//Métodos da classe
	public void persistir(Parte objParte) throws Exception{
		database.conectar();
		
		objExecucao = database.getObjConexao().prepareStatement(
				  "INSERT INTO PRT_PARTE"
				+ "(PRT_CPF, PRT_NOME, PRT_TIPO)"
				+ "VALUES ( ?,?,?)");
		
		objExecucao.setString(1,objParte.getCpf());
		objExecucao.setString(2,objParte.getNome());
		objExecucao.setInt(3,objParte.isTipo() ? 1 : 0);
		
		objExecucao.executeUpdate();
		
		database.desconectar();
	}
	
	public int getUltimoId() throws Exception {
		int ultimoId = 0;
		database.conectar();
		
		objExecucao = database.getObjConexao().prepareStatement(
				"SELECT MAX(PRT_ID) FROM PRT_PARTE"
				);
		
		objCursor = objExecucao.executeQuery();
		
		while (objCursor.next()) {
			ultimoId = objCursor.getInt(1);
		}
		
		database.desconectar();
		
		return ultimoId;
	}
	
}

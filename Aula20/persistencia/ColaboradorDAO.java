package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import negocio.Cargo;
import negocio.Colaborador;


public class ColaboradorDAO {
	//Class attributes
	private BancoDeDados database = new BancoDeDados();
	private PreparedStatement objExecucao = null;
	private ResultSet objCursor = null;
	
	
	public ArrayList<Colaborador> getTodos() throws Exception {
		ArrayList<Colaborador> colecao = new ArrayList<Colaborador>();
		
		database.conectar();
		
		objExecucao = database.getObjConexao().prepareStatement("SELECT * FROM COL_COLABORADOR, CRG_CARGO WHERE COL_IDCARGO = CRG_ID");
				
		objCursor = objExecucao.executeQuery();
		
		while(objCursor.next()) {
			colecao.add(new Colaborador(objCursor.getInt("COL_ID"), objCursor.getString("COL_NOME"), 
					new Cargo(objCursor.getInt("CRG_ID"), objCursor.getString("CRG_NOME"), objCursor.getDouble("CRG_SALARIO"))));
		}
		
		database.desconectar();
		
		return colecao;
	}
	
	public void persistir(Colaborador objColaborador) throws Exception{
		database.conectar();
		
		objExecucao = database.getObjConexao().prepareStatement(
				  "INSERT INTO COL_COLABORADOR"
				+ "(COL_NOME, COL_IDCARGO)"
				+ "VALUES (?,?)");
		
		objExecucao.setString(1,objColaborador.getNome());
		objExecucao.setInt(2,objColaborador.getObjCargo().getId());
		
		objExecucao.executeUpdate();
		
		database.desconectar();
	}
	
	
}

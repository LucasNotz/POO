package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import negocio.Cargo;


public class CargoDAO {
	//Class attributes
	private BancoDeDados database = new BancoDeDados();
	private PreparedStatement objExecucao = null;
	private ResultSet objCursor = null;
	
	
	public ArrayList<Cargo> getTodos() throws Exception {
		ArrayList<Cargo> colecao = new ArrayList<Cargo>();
		
		database.conectar();
		
		objExecucao = database.getObjConexao().prepareStatement("SELECT * FROM CRG_CARGO");
				
		objCursor = objExecucao.executeQuery();
		
		while(objCursor.next()) {
			colecao.add(new Cargo(objCursor.getInt("CRG_ID"), objCursor.getString("CRG_NOME"), objCursor.getDouble("CRG_SALARIO")));
		}
		
		database.desconectar();
		
		return colecao;
	}
	
	
}

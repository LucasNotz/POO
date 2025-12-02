package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import negocio.Tipo;




public class TipoDAO {
	//Class attributes
	private BancoDeDados database = new BancoDeDados();
	private PreparedStatement objExecucao = null;
	private ResultSet objCursor = null;
	
	
	public ArrayList<Tipo> getTodos() throws Exception {
		ArrayList<Tipo> colecao = new ArrayList<Tipo>();
		
		database.conectar();
		
		objExecucao = database.getObjConexao().prepareStatement("SELECT * FROM TIP_TIPO");
				
		objCursor = objExecucao.executeQuery();
		
		while(objCursor.next()) {
			colecao.add(new Tipo(objCursor.getInt("TIP_ID"), objCursor.getString("TIP_DESCRICAO"), objCursor.getBoolean("TIP_OPERACAO")));
		}
		
		database.desconectar();
		
		return colecao;
	}
	
	
}

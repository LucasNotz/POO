package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import negocio.Especie;




public class EspecieDAO {
	//Class attributes
	private BancoDeDados database = new BancoDeDados();
	private PreparedStatement objExecucao = null;
	private ResultSet objCursor = null;
	
	
	public ArrayList<Especie> getTodos() throws Exception {
		ArrayList<Especie> colecao = new ArrayList<Especie>();
		
		database.conectar();
		
		objExecucao = database.getObjConexao().prepareStatement("SELECT * FROM ESP_ESPECIE");
				
		objCursor = objExecucao.executeQuery();
		
		while(objCursor.next()) {
			colecao.add(new Especie(objCursor.getInt("ESP_ID"), objCursor.getString("ESP_DESCRICAO")));
		}
		
		database.desconectar();
		
		return colecao;
	}
	
	
}

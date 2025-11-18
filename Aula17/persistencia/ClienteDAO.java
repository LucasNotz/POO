package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import negocio.Cliente;



public class ClienteDAO {
	//Class attributes
	private BancoDeDados database = new BancoDeDados();
	private PreparedStatement objExecucao = null;
	private ResultSet objCursor = null;
	
	//
	public ArrayList<Cliente> getTodos() throws Exception {
		ArrayList<Cliente> colecao = new ArrayList<Cliente>();
		
		database.conectar();
		
		objExecucao = database.getObjConexao().prepareStatement("SELECT * FROM CLI_cliente");
				
		objCursor = objExecucao.executeQuery();
		
		while(objCursor.next()) {
			colecao.add(new Cliente(objCursor.getInt("CLI_id"), objCursor.getString("CLI_nome"), objCursor.getString("CLI_cartao")));
		}
		
		database.desconectar();
		
		return colecao;
	}
	
	
}

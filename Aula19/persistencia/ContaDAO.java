package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import negocio.Cliente;
import negocio.Conta;




public class ContaDAO {
	//Class attributes
	private BancoDeDados database = new BancoDeDados();
	private PreparedStatement objExecucao = null;
	private ResultSet objCursor = null;
	
	
	public ArrayList<Conta> getTodos(Cliente objCliente) throws Exception {
		ArrayList<Conta> colecao = new ArrayList<Conta>();
		
		database.conectar();
		
		objExecucao = database.getObjConexao().prepareStatement("SELECT * FROM CNT_CONTA, CLI_CLIENTE where CNT_IDCLIENTE = ? AND CNT_IDCLIENTE = CLI_ID");
		
		objExecucao.setInt(1, objCliente.getId());
		
		objCursor = objExecucao.executeQuery();
		
		while(objCursor.next()) {
			colecao.add(new Conta(objCursor.getInt("CNT_ID"), 
					new Cliente(objCursor.getInt("CLI_ID"), objCursor.getString("CLI_NOME"), objCursor.getDouble("CLI_SALARIO")),
					objCursor.getInt("CNT_AGENCIA"), 
					objCursor.getInt("CNT_NUMERO"), 
					objCursor.getBoolean("CNT_TIPO")));
		}
		
		database.desconectar();
		
		return colecao;
	}
	
	
}

package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import negocio.Produto;



public class ProdutoDAO {
	//Class attributes
	private BancoDeDados database = new BancoDeDados();
	private PreparedStatement objExecucao = null;
	private ResultSet objCursor = null;
	
	//
	public ArrayList<Produto> getTodos() throws Exception {
		ArrayList<Produto> colecao = new ArrayList<Produto>();
		
		database.conectar();
		
		objExecucao = database.getObjConexao().prepareStatement("SELECT * FROM PRD_produto");
				
		objCursor = objExecucao.executeQuery();
		
		while(objCursor.next()) {
			colecao.add(new Produto(objCursor.getInt("PRD_id"), objCursor.getString("PRD_nome"), objCursor.getDouble("PRD_preco")));
		}
		
		database.desconectar();
		
		return colecao;
	}
}

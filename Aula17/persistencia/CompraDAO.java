package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import negocio.Cliente;
import negocio.Compra;
import negocio.Produto;

public class CompraDAO {
	//Class attributes
	private BancoDeDados database = new BancoDeDados();
	private PreparedStatement objExecucao = null;
	private ResultSet objCursor = null;
	
	//Métodos da classe
	
	public ArrayList<Compra> getTodos() throws Exception {
		ArrayList<Compra> colecao = new ArrayList<Compra>();
		
		database.conectar();
		
		objExecucao = database.getObjConexao().prepareStatement(
				//Produto cartesiano
				"SELECT * FROM CMP_COMPRA, PRD_Produto, CLI_Cliente WHERE CMP_idProduto = PRD_id AND CMP_idCliente = CLI_id" 
				);
		
		objCursor = objExecucao.executeQuery();
		
		while (objCursor.next()) {
			colecao.add(new Compra(
					objCursor.getInt("CMP_id"),
					new Cliente(objCursor.getInt("CLI_id"),
								objCursor.getString("CLI_nome"),
								objCursor.getString("CLI_cartao")),
					new Produto(objCursor.getInt("PRD_id"),
								objCursor.getString("PRD_nome"),
								objCursor.getDouble("PRD_preco")),
					objCursor.getString("CMP_data"),
					objCursor.getInt("CMP_quantidade")));
		}
		
		database.desconectar();
		
		return colecao;
	}
	
	public void persistir(Compra objCompra) throws Exception {
		database.conectar();
		
		if (objCompra.getId() == 0) {
			objExecucao = database.getObjConexao().prepareStatement(
					"INSERT INTO CMP_Compra (CMP_idCliente, CMP_idProduto, CMP_data, CMP_quantidade) VALUES (?,?,?,?)"
					);
		} else {
			objExecucao = database.getObjConexao().prepareStatement(
					"UPDATE CMP_Compra SET CMP_idProduto = ?, CMP_idCliente = ?, CMP_data = ?, CMP_quantidade = ? WHERE CMP_id = ?"
					);
		}
		
		objExecucao.setInt(1, objCompra.getObjProduto().getId());
		objExecucao.setInt(2, objCompra.getObjCliente().getId());
		objExecucao.setString(3, objCompra.getDataParaBanco());
		objExecucao.setInt(4, objCompra.getQuantidade());
		
		if (objCompra.getId() > 0) {
			objExecucao.setInt(5, objCompra.getId());
		}
		
		objExecucao.executeUpdate();
		database.desconectar();

	}
	
	public void despersistir(Compra objCompra) throws Exception {
		database.conectar();
		
		objExecucao = database.getObjConexao().prepareStatement(
				"DELETE FROM CMP_Compra WHERE CMP_id = ?"
				);
		
		objExecucao.setInt(1, objCompra.getId());
		
		objExecucao.executeUpdate();
		
		database.desconectar();
	}
}

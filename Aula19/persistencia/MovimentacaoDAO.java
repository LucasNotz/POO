package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import negocio.Cliente;
import negocio.Conta;
import negocio.Movimentacao;
import negocio.Tipo;




public class MovimentacaoDAO {
	//Class attributes
	private BancoDeDados database = new BancoDeDados();
	private PreparedStatement objExecucao = null;
	private ResultSet objCursor = null;
	
	
	public ArrayList<Movimentacao> getTodos(Conta objConta) throws Exception {
		ArrayList<Movimentacao> colecao = new ArrayList<Movimentacao>();
		
		database.conectar();
		
		objExecucao = database.getObjConexao().prepareStatement("SELECT * FROM CNT_CONTA, CLI_CLIENTE, MOV_MOVIMENTACAO, TIP_TIPO where MOV_IDCONTA = ? AND MOV_IDCONTA = CNT_ID AND CNT_IDCLIENTE = CLI_ID AND MOV_IDTIPO = TIP_ID");
		
		objExecucao.setInt(1, objConta.getId());
		
		objCursor = objExecucao.executeQuery();
		
		while(objCursor.next()) {
			colecao.add(new Movimentacao(objCursor.getInt("MOV_ID"), 
					new Conta(objCursor.getInt("CNT_ID"), 
							new Cliente(objCursor.getInt("CLI_ID"), objCursor.getString("CLI_NOME"), objCursor.getDouble("CLI_SALARIO")),
							objCursor.getInt("CNT_AGENCIA"),
							objCursor.getInt("CNT_NUMERO"),
							objCursor.getBoolean("CNT_TIPO")),
					new Tipo(objCursor.getInt("TIP_ID"), 
							objCursor.getString("TIP_DESCRICAO"), 
							objCursor.getBoolean("TIP_OPERACAO")), 
					objCursor.getString("MOV_DATA"), 
					objCursor.getDouble("MOV_VALOR")));
		}
		
		database.desconectar();
		
		return colecao;
	}
	
	public void persistir(Movimentacao objMovimentacao) throws Exception{
		database.conectar();
		
		objExecucao = database.getObjConexao().prepareStatement(
				  "INSERT INTO MOV_MOVIMENTACAO"
				+ "(MOV_IDCONTA, MOV_IDTIPO, MOV_DATA, MOV_VALOR)"
				+ "VALUES ( ?,?,?,?)");
		
		objExecucao.setInt(1,objMovimentacao.getObjConta().getId());
		objExecucao.setInt(2,objMovimentacao.getObjTipo().getId());
		objExecucao.setString(3,objMovimentacao.getData());
		objExecucao.setDouble(4, objMovimentacao.getValor());
		
		objExecucao.executeUpdate();
		
		database.desconectar();
	}
	
}

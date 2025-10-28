package persistencia;

import java.sql.PreparedStatement;

import negocio.Pessoa;

public class PessoaDAO {
	//DATA ACCESS OBJECT PARA A PESSOA
	//propriedade da classe
	private BancoDeDados objBanco = new BancoDeDados();
	private PreparedStatement objExecucao = null;
	
	//métodos da classe
	public void persistir(Pessoa objPessoa) throws Exception {
		//pegar obj pessoa e gravar no banco de dados
		objBanco.conectar();
		
		objExecucao = objBanco.getObjConexao().prepareStatement(
				"insert into PES_PESSOA "
				+ "(PES_NOME, PES_ENDERECO, PES_TELEFONE)"
				+ "values"
				+ "(?, ?, ?)");
		objExecucao.setString(1, objPessoa.getNome());
		objExecucao.setString(2, objPessoa.getEndereco());
		objExecucao.setString(3, objPessoa.getTelefone());
		
		objExecucao.executeUpdate();
		
		objBanco.desconectar();
	}
	
}

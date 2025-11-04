package persistencia;

import java.sql.PreparedStatement;

import negocio.Livro;

public class LivroDAO {
	//propriedades
	private Database objBanco = new Database();
	private PreparedStatement objExecucao = null;
	
	public void persistir(Livro objLivro) throws Exception {
		objBanco.conectar();
		
		objExecucao = objBanco.getObjConexao().prepareStatement(
				"insert into liv_livro (liv_titulo, liv_idautor) values (?,?) "
				);
		
		objExecucao.setString(1, objLivro.getTituloLivro());
		objExecucao.setInt(2, objLivro.getObjAutor().getId()); // exportar chave estrangeira
		
		objExecucao.executeUpdate();
		
		objBanco.desconectar();
	}
}

package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class BancoDeDados {
	//Propriedades da classe
	private Connection objConexao = null;
	
	//Métodos da classe
	public Connection getObjConexao() {
		return objConexao;
	}
	
	public void conectar() throws Exception {
		objConexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/aula18?user=root&password=ceub123456&serverTimezone=UTC&-3&userSSL=false");
	}
	
	public void desconectar() throws Exception {
		objConexao.close();
	}
}

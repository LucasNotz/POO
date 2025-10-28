package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class BancoDeDados {
	//propriedades da classe
	private Connection objConexao = null;
	
	//métodos da classe
	Connection getObjConexao() throws Exception {
		return objConexao;
	}
	
	void conectar() throws Exception {
		objConexao = DriverManager.getConnection(
				//local host can be 127.0.0.1
				"jdbc:mysql://localhost:3306/pooaula14?user=root&password=ceub123456&serverTimezone=UTC&userSSL=false");
	}
	
	void desconectar() throws Exception {
		objConexao.close();
	}
}

package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class BancoDeDados {
	//Class attributes
	private Connection objConexao = null;
	
	//Class methods
	Connection getObjConexao() throws Exception {
		return objConexao;
	}
	
	void conectar() throws Exception {
		objConexao = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/aula16?user=root&password=ceub123456&serverTimezone=UTC-3&userSSL=false"
				);
	}
	
	void desconectar() throws Exception {
		objConexao.close();
	}
}

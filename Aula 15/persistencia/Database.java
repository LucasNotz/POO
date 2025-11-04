package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	//propriedades da classe
	Connection objConexao = null;
	
	//métodos da classe
	Connection getObjConexao() {
		return objConexao;
	}
	
	void conectar() throws SQLException {
		objConexao = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/pooaula15?user=root&password=ceub123456&serverTimezone=UTC&useSSL=false");
			
	}
	void desconectar() throws SQLException {
		objConexao.close();
	}
}

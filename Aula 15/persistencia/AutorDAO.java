package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import negocio.Autor;

public class AutorDAO {
	//prop
	private Database objBanco = new Database();
	private PreparedStatement objExecucao = null;
	private ResultSet objCursor = null;
	
	public Collection<Autor> getTodos() throws Exception {
		ArrayList<Autor> colecao = new ArrayList<Autor>();
		
		objBanco.conectar();
		
		objExecucao = objBanco.getObjConexao().prepareStatement(
				"select * from aut_autor"
				);
		
		objCursor = objExecucao.executeQuery();
		while (objCursor.next()) {
			colecao.add(new Autor(objCursor.getInt("aut_id"), objCursor.getString("aut_nome")));
		}
		
		return colecao;
	}
			
			
}

package controle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.MPaciente;

public class CDao {
	private CConexao con;
	//Insert
	public boolean inserir(MPaciente p) {
con = CConexao.getInstancia();
		
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO paciente (cpf, nome) VALLUES (?, ?);";
			PreparedStatement stm = c.prepareStatement(null);
			
			stm.setInt(1, 123);
			stm.setString(2, "alexandre");
			
			int valida = stm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con.fecharConexao();
		
		return false;
	}
	
}

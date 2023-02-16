package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CConexao {
	private static Connection conexao;
	private static CConexao instancia;
	private static final String DATABASE = "Adicionar";
	private static final String USER = "root";
	private static final String PSW = "aluno";
	
	private CConexao() {
		
	}
	//Conexão
	public static CConexao getInstancia() {
		if(instancia == null) {
			instancia = new CConexao();
		}
		return instancia;
	}
		public Connection conectar() {
			try {
				conexao = DriverManager.getConnection("jdbc:mysql://localhost/"
						+ DATABASE + "?serverTimezone=UTC",USER, PSW);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conexao;
			
	}
		public boolean fecharConexao() {
			 try {
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			 return true;
		}
}

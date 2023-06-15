package controle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CConexao {
	private static Connection conexao;
	private static CConexao instancia;
	private static String DATABASE;
	private static String USER;
	private static String PSW;
	
	private CConexao() {
		
	}
	//Conexão
	public static CConexao getInstancia() {
		if(instancia == null) {
			instancia = new CConexao();
			leituraArquivoBD();
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
		public static void leituraArquivoBD() {
			// Lê as informações de login e senha do arquivo de texto
			try {
				BufferedReader reader = new BufferedReader(new FileReader("arquivoBD.txt"));
				if (reader != null) {
					DATABASE = reader.readLine(); 
					USER = reader.readLine(); 
					PSW = reader.readLine(); 
				}
				reader.close();

			} catch (IOException e) {
				System.err.println("Erro ao ler o arquivo: " + e.getMessage());
				return;
			}
		}
}

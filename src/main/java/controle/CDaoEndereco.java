package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.MEndereco;
import modelo.MUsuario;

public class CDaoEndereco {
	private static CDaoEndereco instancia;
	private CConexao con;
	
	
	public static CDaoEndereco getInstancia() {
		if (instancia == null) {
			instancia = new CDaoEndereco();
		}
		return instancia;
		}
		public CDaoEndereco() {
		}
	//Insert -------------------------------------------------------------------------------
		public boolean inserir(MEndereco a) {
	con = CConexao.getInstancia();
			Connection c = con.conectar();
			int valida = 0;
			try {
				String query = "INSERT INTO endereco (cep, rua, cidade, estado) VALUES (?, ?, ?, ?);";
				PreparedStatement stm = c.prepareStatement(query);
				
				stm.setLong(1, a.getCep());
				stm.setString(2, a.getRua());
				stm.setString(3, a.getCidade());
				stm.setString(4, a.getEstado());				
				valida = stm.executeUpdate();
				System.out.println(stm);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				con.fecharConexao();
			}
			return (valida == 0 ? false : true);
		}
		//Update -------------------------------------------------------------------------------
		public boolean update(MEndereco a) {
			con = CConexao.getInstancia();
					Connection c = con.conectar();
					int valida = 0;
					try {
						String query = "UPDATE endereco Set rua = ?, cidade = ?, estado = ? WHERE cep = ?";
						PreparedStatement stm = c.prepareStatement(query);
						
						stm.setString(1, a.getRua());
						stm.setString(2, a.getCidade());
						stm.setString(3, a.getEstado());				
						stm.setLong(4, a.getCep());
						valida = stm.executeUpdate();					
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						con.fecharConexao();
					}
					return (valida == 0 ? false : true);
				}
		//Delete -------------------------------------------------------------------------------
		public boolean delete(MEndereco a) {
			con = CConexao.getInstancia();
					Connection c = con.conectar();
					int valida = 0;
					try {
						String query = "DELETE FROM endereco Where cep = ?"; 
						PreparedStatement stm = c.prepareStatement(query);
						stm.setLong(1, a.getCep());				
						stm.executeUpdate();
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						con.fecharConexao();
					}
					return (valida == 0 ? false : true);
				}
		//List -------------------------------------------------------------------------------
		public ArrayList<MEndereco> listarEndereco() {
			ArrayList<MEndereco> endereco = new ArrayList<>();
			
			con = CConexao.getInstancia();
			Connection c = con.conectar();
			
			try {
				Statement stm = c.createStatement();
				String query = "SELECT * FROM endereco";
				ResultSet rs = stm.executeQuery(query);
				while (rs.next()) {
					long cep = rs.getLong("cep");
					String rua = rs.getString("rua");
					String cidade = rs.getString("cidade");
					String estado = rs.getString("estado");
					MEndereco a = new MEndereco();
					a.setCep(cep);
					a.setRua(rua);
					a.setCidade(cidade);
					a.setEstado(estado);
					endereco.add(a);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				con.fecharConexao();
			}
			return endereco;
		}
}

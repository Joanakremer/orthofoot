package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.MMedico;


public class CDaoMedico {

	private CConexao con;
	//Insert -------------------------------------------------------------------------------
	public boolean inserir(MMedico m) {
con = CConexao.getInstancia();
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO medico (crm ,nomeCompleto, dataNasc, sexo) VALLUES (?, ?, ?, ?);";
			PreparedStatement stm = c.prepareStatement(query);
			
			stm.setLong(1, m.getCrm());
			stm.setString(2, m.getnomeCompleto());
			stm.setDate(3, m.getdataNasc());
			stm.setString(4, m.getSexo());				
			stm.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.fecharConexao();
			return false;
		}
	}
	//Update -------------------------------------------------------------------------------
	public boolean update(MMedico m) {
		con = CConexao.getInstancia();
				Connection c = con.conectar();
				try {
					String query = "UPDATE medico Set nomeCompleto = ?, set dataNasc = ?, set sexo = ? WHERE crm = ?";
					PreparedStatement stm = c.prepareStatement(query);
					
					stm.setLong(1, m.getCrm());
					stm.setString(2, m.getnomeCompleto());
					stm.setDate(3, m.getdataNasc());
					stm.setString(4, m.getSexo());				
					stm.executeUpdate();
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					con.fecharConexao();
				}
				return false;
			}
	//Delete -------------------------------------------------------------------------------
	public boolean delete(MMedico m) {
		con = CConexao.getInstancia();
				Connection c = con.conectar();
				try {
					String query = "DELETE FROM medico Where crm = ?"; 
					PreparedStatement stm = c.prepareStatement(query);
					stm.setLong(1, m.getCrm());
					stm.setString(2, m.getnomeCompleto());
					stm.setDate(3, m.getdataNasc());
					stm.setString(4, m.getSexo());				
					stm.executeUpdate();
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					con.fecharConexao();
				}
				return false;
			}
	//List -------------------------------------------------------------------------------
	public ArrayList<MMedico> listarMedico() {
		ArrayList<MMedico> medico = new ArrayList<>();
		
		con = CConexao.getInstancia();
		Connection c = con.conectar();
		
		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM medico";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Long crm = rs.getLong("crm");
				String nomeCompleto = rs.getString("nomeCompleto");
				Date dataNasc = rs.getDate("dataNasc");
				String sexo = rs.getString("sexo");
				
				MMedico m = new MMedico();
				m.setCrm(crm);
				m.setnomeCompleto(nomeCompleto);
				m.setdataNasc(dataNasc);
				m.setSexo(sexo);
				medico.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.fecharConexao();
		}
		return medico;

	}
}

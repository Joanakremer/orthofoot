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
	
	private static CDaoMedico instancia;
	private CConexao con;

	public static CDaoMedico getInstancia() {
		if (instancia == null) {
			instancia = new CDaoMedico();
		}
		return instancia;
	}

	 public CDaoMedico() {
	}


	//Insert -------------------------------------------------------------------------------
	public boolean inserir(MMedico m) {
con = CConexao.getInstancia();
		Connection c = con.conectar();
		int valida = 0;
		try {
			String query = "INSERT INTO medicos (crm ,nomeCompleto, dataNasc, sexo) VALUES (?, ?, ?, ?);";
			PreparedStatement stm = c.prepareStatement(query);
			
			stm.setLong(1, m.getCrm());
			stm.setString(2, m.getnomeCompleto());
			stm.setDate(3, Date.valueOf(m.getdataNasc()));
			stm.setString(4, m.getSexo());		
			System.out.println(stm);
			valida = stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.fecharConexao();
		}
		return (valida == 0 ? false : true);
	}
	//Update -------------------------------------------------------------------------------
	public boolean update(MMedico m) {
		con = CConexao.getInstancia();
				Connection c = con.conectar();
				int valida = 0;
				try {
					String query = "UPDATE medicos Set nomeCompleto = ?, set dataNasc = ?, set sexo = ? WHERE crm = ?";
					PreparedStatement stm = c.prepareStatement(query);
					
					stm.setLong(1, m.getCrm());
					stm.setString(2, m.getnomeCompleto());
					stm.setDate(3, Date.valueOf(m.getdataNasc()));
					stm.setString(4, m.getSexo());				
					valida = stm.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					con.fecharConexao();
				}
				return (valida == 0 ? false : true);
			}
	//Delete -------------------------------------------------------------------------------
	public boolean delete(MMedico m) {
		con = CConexao.getInstancia();
				Connection c = con.conectar();
				int valida = 0;
				try {
					String query = "DELETE FROM medicos Where crm = ?"; 
					PreparedStatement stm = c.prepareStatement(query);
					stm.setLong(1, m.getCrm());
					stm.setString(2, m.getnomeCompleto());
					stm.setDate(3, Date.valueOf(m.getdataNasc()));
					stm.setString(4, m.getSexo());				
					valida = stm.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					con.fecharConexao();
				}
				return (valida == 0 ? false : true);
			}
	//List -------------------------------------------------------------------------------
	public ArrayList<MMedico> listarMedico() {
		ArrayList<MMedico> medico = new ArrayList<>();
		
		con = CConexao.getInstancia();
		Connection c = con.conectar();
		
		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM medicos";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Long crm = rs.getLong("crm");
				String nomeCompleto = rs.getString("nomeCompleto");
				Date dataNasc = rs.getDate("dataNasc");
				String sexo = rs.getString("sexo");
				
				MMedico m = new MMedico();
				m.setCrm(crm);
				m.setnomeCompleto(nomeCompleto);
				m.setdataNasc(dataNasc.toLocalDate());
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

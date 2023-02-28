package controle;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.MPaciente;

public class CDao {
	private CConexao con;
	//Insert -------------------------------------------------------------------------------
	public boolean inserir(MPaciente p) {
con = CConexao.getInstancia();
		Connection c = con.conectar();
		try {
			String query = "INSERT INTO paciente (pronturaio, nomeCompleto, cpf, contato, dataNasc, convenio, nCarteira, sexo) VALLUES (?, ?);";
			PreparedStatement stm = c.prepareStatement(query);
			
			stm.setInt(1, p.getProntuario());
			stm.setString(2, p.getnomeCompleto());
			stm.setLong(3, p.getCpf());
			stm.setString(4, p.getContato());
			stm.setDate(5, p.getdataNasc());
			stm.setString(6, p.getConvenio());
			stm.setString(7, p.getnCarteira());
			stm.setString(8, p.getSexo());
						
			stm.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con.fecharConexao();
		
		return false;
	}
	//Update -------------------------------------------------------------------------------
	public boolean update(MPaciente p) {
		con = CConexao.getInstancia();
				Connection c = con.conectar();
				try {
					String query = "UPDATE pessoa Set nome = ?, Set cpf = ?, Set contato = ?, Set dataNasc = ?, Set convenio = ?, Set nCarteira = ?, Set sexo = ? WHERE prontuario = ?";
					PreparedStatement stm = c.prepareStatement(query);
					
					stm.setInt(1, p.getProntuario());
					stm.setString(2, p.getnomeCompleto());
					stm.setLong(3, p.getCpf());
					stm.setString(4, p.getContato());
					stm.setDate(5, p.getdataNasc());
					stm.setString(6, p.getConvenio());
					stm.setString(7, p.getnCarteira());
					stm.setString(8, p.getSexo());
					stm.executeUpdate();
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				con.fecharConexao();
				return false;
			}
	//Delete -------------------------------------------------------------------------------
	public boolean delete(MPaciente p) {
		con = CConexao.getInstancia();
				Connection c = con.conectar();
				try {
					String query = "DELETE FROM paciente Where cpf = ?"; 
					PreparedStatement stm = c.prepareStatement(query);
					stm.setInt(1, p.getProntuario());
					stm.setString(2, p.getnomeCompleto());
					stm.setLong(3, p.getCpf());
					stm.setString(4, p.getContato());
					stm.setDate(5, p.getdataNasc());
					stm.setString(6, p.getConvenio());
					stm.setString(7, p.getnCarteira());
					stm.setString(8, p.getSexo());
					stm.executeUpdate();
					return true;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				con.fecharConexao();
				return false;
			}
	//List -------------------------------------------------------------------------------
	public ArrayList<MPaciente> listarPaciente() {
		ArrayList<MPaciente> paciente = new ArrayList<>();
		
		con = CConexao.getInstancia();
		Connection c = con.conectar();
		
		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM pessoa";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				int prontuario = rs.getInt("prontuario");
				String nomeCompleto = rs.getString("nomeCompleto");
				Long cpf = rs.getLong("cpf");
				String contato = rs.getString("contato");
				Date dataNasc = rs.getDate("dataNasc");
				String convenio = rs.getString("convenio");
				String nCarteira = rs.getString("nCarteira");
				String sexo = rs.getString("sexo");
				MPaciente p = new MPaciente();
				p.setProntuario(prontuario);
				p.setnomeCompleto(nomeCompleto);
				p.setCpf(cpf);
				p.setContato(contato);
				p.setdataNasc(dataNasc);
				p.setConvenio(convenio);
				p.setnCarteira(nCarteira);
				p.setSexo(sexo);
				paciente.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		con.fecharConexao();

		return paciente;
	}
}

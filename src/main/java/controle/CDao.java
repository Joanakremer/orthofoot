package controle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import modelo.MPaciente;

public class CDao {

	private static CDao instancia;
	private CConexao con;

	public static CDao getInstancia() {
		if (instancia == null) {
			instancia = new CDao();
		}
		return instancia;
	}

	public CDao() {
	}

	// Insert
	// -------------------------------------------------------------------------------
	public boolean inserir(MPaciente p) {
		con = CConexao.getInstancia();
		Connection c = con.conectar();
		int valida = 0;
		try {
			String query = "INSERT INTO paciente (prontuario, nomeCompleto, cpf, contato, dataNasc, convenio, nCarteira, sexo) VALUES (?,?,?,?,?,?,?,?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setInt(1, p.getProntuario());
			stm.setString(2, p.getnomeCompleto());
			stm.setLong(3, p.getCpf());
			stm.setString(4, p.getContato());
			stm.setDate(5, Date.valueOf(p.getdataNasc()));
			stm.setString(6, p.getConvenio());
			stm.setInt(7, p.getnCarteira());
			stm.setString(8, p.getSexo());
			System.out.println(stm);
			valida = stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return (valida == 0 ? false : true); // if ternario
	}

	// Update
	// -------------------------------------------------------------------------------
	public boolean update(MPaciente p) {
		con = CConexao.getInstancia();
		Connection c = con.conectar();
		int valida = 0;
		try {
			String query = "UPDATE paciente Set nomeCompleto = ?,cpf = ?, contato = ?, dataNasc = ?, convenio = ?, nCarteira = ?, sexo = ? WHERE prontuario = ?";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setString(1, p.getnomeCompleto());
			stm.setLong(2, p.getCpf());
			stm.setString(3, p.getContato());
			stm.setDate(4, Date.valueOf(p.getdataNasc()));
			stm.setString(5, p.getConvenio());
			stm.setInt(6, p.getnCarteira());
			stm.setString(7, p.getSexo());
			stm.setInt(8, p.getProntuario());
			valida = stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return (valida == 0 ? false : true);
	}

	// Delete
	// -------------------------------------------------------------------------------
	public boolean delete(MPaciente p) {
		con = CConexao.getInstancia();
		Connection c = con.conectar();
		int valida = 0;
		try {
			String query = "DELETE FROM paciente Where prontuario = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setInt(1, p.getProntuario());
			
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return (valida == 0 ? false : true);
	}

	// List
	// -------------------------------------------------------------------------------
	public ArrayList<MPaciente> listarPaciente() {
		ArrayList<MPaciente> paciente = new ArrayList<>();

		con = CConexao.getInstancia();
		Connection c = con.conectar();

		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM paciente";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				int prontuario = rs.getInt("prontuario");
				String nomeCompleto = rs.getString("nomeCompleto");
				Long cpf = rs.getLong("cpf");
				String contato = rs.getString("contato");
				Date dataNasc = rs.getDate("dataNasc");
				String convenio = rs.getString("convenio");
				int nCarteira = rs.getInt("nCarteira");
				String sexo = rs.getString("sexo");
				MPaciente p = new MPaciente();
				p.setProntuario(prontuario);
				p.setnomeCompleto(nomeCompleto);
				p.setCpf(cpf);
				p.setContato(contato);
				p.setDataNasc(dataNasc.toLocalDate());
				p.setConvenio(convenio);
				p.setnCarteira(nCarteira);
				p.setSexo(sexo);
				paciente.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.fecharConexao();
		}
		return paciente;
	}
}

package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.MUsuario;

public class CDaoUsuario {
	private CConexao con;

	// Insert
	// -------------------------------------------------------------------------------
	public boolean inserir(MUsuario u) {
		con = CConexao.getInstancia();
		Connection c = con.conectar();
		int valida = 0;
		try {
			String query = "INSERT INTO medicos (idUsuario, login, senha, tipoUsuario) VALLUES (?, ?, ?, ?);";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setInt(1, u.getIdUsuario());
			stm.setString(2, u.getLogin());
			stm.setString(3, u.getSenha());
			stm.setInt(4, u.getTipoUsuario());
			valida = stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.fecharConexao();
		}
		return (valida == 0 ? false : true);
	}

	// Update
	// -------------------------------------------------------------------------------
	public boolean update(MUsuario u) {
		con = CConexao.getInstancia();
		Connection c = con.conectar();
		int valida = 0;
		try {
			String query = "UPDATE usuarios Set idUsuario = ?, set login = ?, set senha = ?, set tipoUsuario = ? WHERE idUsuario = ?";
			PreparedStatement stm = c.prepareStatement(query);

			stm.setInt(1, u.getIdUsuario());
			stm.setString(2, u.getLogin());
			stm.setString(3, u.getSenha());
			stm.setInt(4, u.getTipoUsuario());
			valida = stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.fecharConexao();
		}
		return (valida == 0 ? false : true);
	}

	// Delete
	// -------------------------------------------------------------------------------
	public boolean delete(MUsuario u) {
		con = CConexao.getInstancia();
		Connection c = con.conectar();
		int valida = 0;
		try {
			String query = "DELETE FROM usuarios Where idUsuario = ?";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setInt(1, u.getIdUsuario());
			stm.setString(2, u.getLogin());
			stm.setString(3, u.getSenha());
			stm.setInt(4, u.getTipoUsuario());
			valida = stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.fecharConexao();
		}
		return (valida == 0 ? false : true);
	}

	// List
	// -------------------------------------------------------------------------------
	public ArrayList<MUsuario> listarUsuario() {
		ArrayList<MUsuario> usuarios = new ArrayList<>();

		con = CConexao.getInstancia();
		Connection c = con.conectar();

		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM medicos";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				int idUsuario = rs.getInt("idUsuario");
				String login = rs.getString("login");
				String senha = rs.getString("senha");
				int tipoUsuario = rs.getInt("tipoUsuario");
				MUsuario u = new MUsuario();
				u.setIdUsuario(idUsuario);
				u.setLogin(login);
				u.setSenha(senha);
				u.setTipoUsuario(tipoUsuario);
				usuarios.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.fecharConexao();
		}
		return usuarios;
	}

	public MUsuario efetuarLogin(String usuario, String senha) {
		con = CConexao.getInstancia();
		Connection c = con.conectar();
		MUsuario u = null;
		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM usuarios WHERE login = '" + usuario + "' AND senha = '" + senha + "'";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {

				int idUsuario = rs.getInt("idusuario");
				String login = rs.getString("login");
				String psw = rs.getString("senha");
				int tipoUsuario = rs.getInt("tipoUsuario");

				u = new MUsuario();
				u.setIdUsuario(idUsuario);
				u.setLogin(login);
				u.setSenha(psw);
				u.setTipoUsuario(tipoUsuario);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			con.fecharConexao();
		}
		return u;
	}
}
